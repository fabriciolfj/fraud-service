package com.github.fabriciolfj.fraud.adapters.providers;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.github.fabriciolfj.fraud.adapters.gateways.FindLastTransactionGateway;
import com.github.fabriciolfj.fraud.adapters.providers.repository.FraudRepository;
import com.github.fabriciolfj.fraud.adapters.providers.repository.data.FraudData;
import com.github.fabriciolfj.fraud.entities.FraudEntity;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class FindTransactionTimeProvider implements FindLastTransactionGateway {

    private final FraudRepository fraudRepository;

    @ConfigProperty(name = "time.transaction.min")
    private String timer;

    @Override
    public Optional<String> process(final FraudEntity entity) {
        final var params = new HashMap<String, AttributeValue>();
        params.put(":customer", new AttributeValue().withS(entity.getCustomer()));

        var date = entity.getDate()
                .minusMinutes(Long.parseLong(timer));
        params.put(":date", new AttributeValue().withS(date.toString()));

        final var query = new DynamoDBQueryExpression<FraudData>()
                .withIndexName("dateCustomer-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("customer = :customer and date_registry >= :date")
                .withExpressionAttributeValues(params);

        return fraudRepository.findData(query).map(FraudData::getTransaction);
    }
}

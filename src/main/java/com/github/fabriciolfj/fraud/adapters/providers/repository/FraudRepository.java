package com.github.fabriciolfj.fraud.adapters.providers.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.github.fabriciolfj.fraud.exceptions.FraudSaveException;
import com.github.fabriciolfj.fraud.adapters.providers.repository.data.FraudData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FraudRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public Optional<FraudData> findData(DynamoDBQueryExpression<FraudData> query) {
        try {
            return dynamoDBMapper.query(FraudData.class, query).stream().findAny();
        } catch (Exception e) {
            log.error("fail find data, details {}", e.getMessage());
            return Optional.empty();
        }
    }

    public void save(final FraudData data) {
        try {
            dynamoDBMapper.save(data);
        } catch (Exception e) {
            log.error("fail save data {}, details", data, e.getMessage());
            throw new FraudSaveException();
        }
    }
}

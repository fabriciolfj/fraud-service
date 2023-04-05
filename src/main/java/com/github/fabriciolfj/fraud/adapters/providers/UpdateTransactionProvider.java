package com.github.fabriciolfj.fraud.adapters.providers;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.adapters.gateways.UpdateTransactionGateway;
import com.github.fabriciolfj.fraud.adapters.providers.http.TransactionHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class UpdateTransactionProvider implements UpdateTransactionGateway {

    @Inject
    @RestClient
    private TransactionHttpClient client;

    @Override
    public void process(final FraudEntity entity) {
        log.info("process update status {}, to transaction {}", entity.getTransaciton(), entity.getStatus());

        client.process(entity.getTransaciton(), entity.getStatus().getDescribe());
    }
}

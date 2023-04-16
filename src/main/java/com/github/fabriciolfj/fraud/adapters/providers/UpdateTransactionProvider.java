package com.github.fabriciolfj.fraud.adapters.providers;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.adapters.gateways.UpdateTransactionGateway;
import com.github.fabriciolfj.fraud.adapters.providers.http.TransactionHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.temporal.ChronoUnit;

@Slf4j
@ApplicationScoped
public class UpdateTransactionProvider implements UpdateTransactionGateway {

    @Inject
    @RestClient
    private TransactionHttpClient client;

    @Override
    @Retry(maxRetries = 5, delayUnit = ChronoUnit.SECONDS, delay = 60, jitter = 50)
    public void process(final FraudEntity entity) {
        log.info("process update status {}, to transaction {}", entity.getTransaciton(), entity.getStatus());

        client.process(entity.getTransaciton(), entity.getStatus().getDescribe());
    }
}

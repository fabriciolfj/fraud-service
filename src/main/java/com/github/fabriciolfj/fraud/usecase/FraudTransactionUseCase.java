package com.github.fabriciolfj.fraud.usecase;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.adapters.gateways.SaveFraudGateway;
import com.github.fabriciolfj.fraud.adapters.gateways.UpdateTransactionGateway;
import com.github.fabriciolfj.fraud.exceptions.FraudTransactionUseCaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FraudTransactionUseCase {

    private final Instance<FraudProcessingUseCase> fraudProcessingUseCases;
    private final UpdateTransactionGateway updateTransactionGateway;
    private final SaveFraudGateway saveFraudGateway;

    public void execute(final FraudEntity entity) {
        log.info("init process to transaction {}", entity.getTransaciton());

        try {
            var result = getResultProcess(entity);

            saveFraudGateway.process(result);
            updateTransactionGateway.process(result);
        } catch (Exception e) {
            log.error("fraud detected to transaction {}, details {}", entity.getTransaciton(), e.getMessage());
            throw new FraudTransactionUseCaseException();
        }
    }

    private FraudEntity getResultProcess(FraudEntity entity) {
        return fraudProcessingUseCases.stream().map(e -> e.execute(entity))
                .findFirst().get();
    }
}

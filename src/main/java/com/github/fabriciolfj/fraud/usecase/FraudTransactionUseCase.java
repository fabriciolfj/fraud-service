package com.github.fabriciolfj.fraud.usecase;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.adapters.gateways.SaveFraudGateway;
import com.github.fabriciolfj.fraud.adapters.gateways.UpdateTransactionGateway;
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
        log.info("init processo to transaction {}", entity.getTransaciton());

        try {
            var result = fraudProcessingUseCases.stream().map(e -> e.execute(entity))
                    .toList().get(0);

            saveFraudGateway.process(result);
            updateTransactionGateway.process(result.toApproved());
        } catch (Exception e) {
            log.error("fraud detected to transaction {}, details {}", entity.getTransaciton(), e.getMessage());
            updateTransactionGateway.process(entity.toDisapproved());
        }
    }
}

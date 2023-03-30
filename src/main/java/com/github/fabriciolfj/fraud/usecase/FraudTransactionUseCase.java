package com.github.fabriciolfj.fraud.usecase;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.gateways.UpdateTransactionGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FraudTransactionUseCase {

    private final List<FraudProcessingUseCase> fraudProcessingUseCases;
    private final UpdateTransactionGateway updateTransactionGateway;

    public void execute(final FraudEntity entity) {
        log.info("init processo to transaction {}", entity.getTransaciton());

        try {
            var result = fraudProcessingUseCases.stream().map(e -> e.execute(entity))
                    .toList().get(0);

            updateTransactionGateway.process(result.toApproved());
        } catch (Exception e) {
            log.error("fraud detected to transaction {}, details {}", entity.getTransaciton(), e.getMessage());
            updateTransactionGateway.process(entity.toDisapproved());
        }
    }
}

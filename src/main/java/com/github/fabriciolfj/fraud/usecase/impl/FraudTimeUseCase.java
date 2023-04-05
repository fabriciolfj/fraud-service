package com.github.fabriciolfj.fraud.usecase.impl;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.exceptions.FraudTimeException;
import com.github.fabriciolfj.fraud.adapters.gateways.FindLastTransactionGateway;
import com.github.fabriciolfj.fraud.usecase.FraudProcessingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class FraudTimeUseCase implements FraudProcessingUseCase {

    private final FindLastTransactionGateway findLastTransactionGateway;

    @Override
    public FraudEntity execute(final FraudEntity entity) {
        log.info("fraud time initial execute to transaction {}", entity.getTransaciton());

        var result = findLastTransactionGateway.process(entity);

        if (result.isPresent()) {
            log.warn("fraud time detected to transaction {}", entity.getTransaciton());
            throw new FraudTimeException();
        }

        return entity;
    }
}

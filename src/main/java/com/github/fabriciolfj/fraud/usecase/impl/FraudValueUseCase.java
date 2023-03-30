package com.github.fabriciolfj.fraud.usecase.impl;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.usecase.FraudProcessingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FraudValueUseCase implements FraudProcessingUseCase {

    @Override
    public FraudEntity execute(final FraudEntity entity) {
        log.info("fraude value execute initial to transaciton {}", entity.getTransaciton());

        log.warn("fraud value detected to transaction {}", entity.getTransaciton());
        return entity;
    }
}

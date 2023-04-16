package com.github.fabriciolfj.fraud.usecase.impl;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.usecase.FraudProcessingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FraudValueUseCase implements FraudProcessingUseCase {

    @ConfigProperty(name = "value.transaction.max")
    private BigDecimal value;

    @ConfigProperty(name = "value.transaction.hour")
    private Integer hours;

    @Override
    public FraudEntity execute(final FraudEntity entity) {
        log.info("fraude value execute initial to transaciton {}", entity.getTransaciton());

        if (entity.isTransactionValid(value, hours)) {
            return entity.toApproved();
        }

        log.warn("fraud value detected to transaction {}", entity.getTransaciton());
        return entity.toDisapproved();
    }
}

package com.github.fabriciolfj.fraud.usecase;

import com.github.fabriciolfj.fraud.entities.FraudEntity;

public interface FraudProcessingUseCase {

    FraudEntity execute(final FraudEntity entity);
}

package com.github.fabriciolfj.fraud.adapters.gateways;

import com.github.fabriciolfj.fraud.entities.FraudEntity;

import java.util.Optional;

public interface FindLastTransactionGateway {

    Optional<String> process(FraudEntity entity);
}

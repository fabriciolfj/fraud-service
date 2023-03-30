package com.github.fabriciolfj.fraud.gateways;

import com.github.fabriciolfj.fraud.entities.FraudEntity;

import java.util.Optional;

public interface FindLastTransactionGateway {

    Optional<String> process(FraudEntity entity);
}

package com.github.fabriciolfj.fraud.gateways;

import com.github.fabriciolfj.fraud.entities.FraudEntity;

public interface UpdateTransactionGateway {

    void process(final FraudEntity entity);
}

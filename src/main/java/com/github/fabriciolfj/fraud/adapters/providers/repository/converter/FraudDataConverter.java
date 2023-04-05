package com.github.fabriciolfj.fraud.adapters.providers.repository.converter;

import com.github.fabriciolfj.fraud.adapters.providers.repository.data.FraudData;
import com.github.fabriciolfj.fraud.entities.FraudEntity;

public class FraudDataConverter {

    private FraudDataConverter() {

    }

    public static FraudData toData(final FraudEntity entity) {
        return FraudData.builder()
                .code(entity.getCode())
                .status(entity.getStatus().getDescribe())
                .transaction(entity.getTransaciton())
                .customer(entity.getCustomer())
                .dateRegistry(entity.getDate().toString())
                .build();
    }
}

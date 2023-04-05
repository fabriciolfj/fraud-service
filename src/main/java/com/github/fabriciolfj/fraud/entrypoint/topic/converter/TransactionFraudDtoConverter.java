package com.github.fabriciolfj.fraud.entrypoint.topic.converter;

import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.entrypoint.topic.dto.TransactionFraudDto;

import java.util.UUID;

public class TransactionFraudDtoConverter {

    private TransactionFraudDtoConverter() {

    }

    public static FraudEntity toEntity(final TransactionFraudDto dto) {
        return FraudEntity.builder()
                .date(dto.getDate())
                .value(dto.getValue())
                .transaciton(dto.getTransaction())
                .customer(dto.getCustomer())
                .code(UUID.randomUUID().toString())
                .build();
    }
}

package com.github.fabriciolfj.fraud.entrypoint.topic.deserializer;

import com.github.fabriciolfj.fraud.entrypoint.topic.dto.TransactionFraudDto;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TransactionFraudDtoDeserializer extends JsonbDeserializer<TransactionFraudDto> {

    public TransactionFraudDtoDeserializer() {
        super(TransactionFraudDto.class);
    }
}

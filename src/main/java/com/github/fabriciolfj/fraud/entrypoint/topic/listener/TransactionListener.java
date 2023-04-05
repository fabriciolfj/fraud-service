package com.github.fabriciolfj.fraud.entrypoint.topic.listener;

import com.github.fabriciolfj.fraud.entrypoint.topic.converter.TransactionFraudDtoConverter;
import com.github.fabriciolfj.fraud.entrypoint.topic.dto.TransactionFraudDto;
import com.github.fabriciolfj.fraud.usecase.FraudTransactionUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@RequiredArgsConstructor
@ApplicationScoped
@Slf4j
public class TransactionListener {

    private final FraudTransactionUseCase fraudTransactionUseCase;

    @Incoming("fraud-service")
    public void process(final TransactionFraudDto dto) {
        log.info("message received {}", dto);

        fraudTransactionUseCase.execute(TransactionFraudDtoConverter.toEntity(dto));
    }
}

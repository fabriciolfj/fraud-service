package com.github.fabriciolfj.fraud.entrypoint.topic.listener;

import com.github.fabriciolfj.fraud.entrypoint.topic.dto.TransactionFraudDto;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
public class TransactionListener {

    @Incoming("fraud-service")
    public void process(final TransactionFraudDto dto) {
        log.info("message received {}", dto);
    }
}

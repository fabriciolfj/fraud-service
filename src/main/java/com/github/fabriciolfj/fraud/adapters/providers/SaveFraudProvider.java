package com.github.fabriciolfj.fraud.adapters.providers;

import com.github.fabriciolfj.fraud.adapters.gateways.SaveFraudGateway;
import com.github.fabriciolfj.fraud.adapters.providers.repository.FraudRepository;
import com.github.fabriciolfj.fraud.entities.FraudEntity;
import com.github.fabriciolfj.fraud.adapters.providers.repository.converter.FraudDataConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@RequiredArgsConstructor
@ApplicationScoped
@Slf4j
public class SaveFraudProvider implements SaveFraudGateway {

    private final FraudRepository repository;

    @Override
    public void process(final FraudEntity entity) {
        log.info("init save fraud {}", entity.getCode());

        repository.save(FraudDataConverter.toData(entity));
    }
}

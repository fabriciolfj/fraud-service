package com.github.fabriciolfj.fraud.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusFraudEntity {

    APPROVED("approved"),
    DISAPPROVED("disapproved");

    private final String describe;
}

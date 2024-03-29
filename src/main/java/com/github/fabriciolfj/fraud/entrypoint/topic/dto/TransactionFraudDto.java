package com.github.fabriciolfj.fraud.entrypoint.topic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionFraudDto {

    private String customer;
    private String transaction;
    private BigDecimal value;
    private String date;
}

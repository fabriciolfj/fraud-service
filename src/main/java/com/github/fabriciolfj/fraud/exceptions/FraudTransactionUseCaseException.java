package com.github.fabriciolfj.fraud.exceptions;

import static com.github.fabriciolfj.fraud.exceptions.enums.Errors.FRAUD_CASE;

public class FraudTransactionUseCaseException extends RuntimeException {

    public FraudTransactionUseCaseException() {
        super(FRAUD_CASE.toMessage());
    }
}

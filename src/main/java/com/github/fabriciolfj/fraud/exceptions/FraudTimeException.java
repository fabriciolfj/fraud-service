package com.github.fabriciolfj.fraud.exceptions;


import com.github.fabriciolfj.fraud.exceptions.enums.Errors;

public class FraudTimeException extends RuntimeException {

    public FraudTimeException() {
        super(Errors.FRAUD_TIME.toMessage());
    }
}

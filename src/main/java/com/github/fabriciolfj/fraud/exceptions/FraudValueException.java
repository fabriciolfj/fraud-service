package com.github.fabriciolfj.fraud.exceptions;


import com.github.fabriciolfj.fraud.exceptions.enums.Errors;

public class FraudValueException extends RuntimeException {

    public FraudValueException() {
        super(Errors.FRAUD_VALUE.toMessage());
    }
}

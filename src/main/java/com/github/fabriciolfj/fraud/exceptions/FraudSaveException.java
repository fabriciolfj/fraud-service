package com.github.fabriciolfj.fraud.exceptions;


import com.github.fabriciolfj.fraud.exceptions.enums.Errors;

public class FraudSaveException extends RuntimeException {

    public FraudSaveException() {
        super(Errors.SAVE_FRAUD.toMessage());
    }
}

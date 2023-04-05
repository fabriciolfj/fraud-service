package com.github.fabriciolfj.fraud.exceptions;

import com.github.fabriciolfj.fraud.exceptions.enums.Errors;

public class UpdateTransactionStatusException extends RuntimeException {

    public UpdateTransactionStatusException() {
        super(Errors.UPDATE_TRANSACTION.toMessage());
    }
}

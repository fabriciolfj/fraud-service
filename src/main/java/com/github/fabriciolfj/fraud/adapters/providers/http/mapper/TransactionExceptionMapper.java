package com.github.fabriciolfj.fraud.adapters.providers.http.mapper;

import com.github.fabriciolfj.fraud.exceptions.UpdateTransactionStatusException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class TransactionExceptionMapper implements ResponseExceptionMapper<UpdateTransactionStatusException> {

    @Override
    public UpdateTransactionStatusException toThrowable(Response response) {
        return new UpdateTransactionStatusException();
    }
}

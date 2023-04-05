package com.github.fabriciolfj.fraud.adapters.providers.http;

import com.github.fabriciolfj.fraud.adapters.providers.http.mapper.TransactionExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/transactions")
@RegisterRestClient(configKey = "transaction-service")
@RegisterProvider(TransactionExceptionMapper.class)
@Produces(MediaType.APPLICATION_JSON)
public interface TransactionHttpClient {

    @PUT
    @Path("{code}/{status}")
    void process(@PathParam("code") final String code, @PathParam("status") final String status);
}

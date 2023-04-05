package com.github.fabriciolfj.fraud.adapters.providers.repository.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "fraud")
public class FraudData {

    private String code;
    private String dateRegistry;
    private String transaction;
    private String status;
    private String customer;

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @DynamoDBAttribute(attributeName = "customer")
    public String getCustomer() {
        return customer;
    }

    @DynamoDBHashKey(attributeName = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @DynamoDBRangeKey(attributeName = "date_registry")
    public String getDateRegistry() {
        return dateRegistry;
    }

    public void setDateRegistry(String dateRegistry) {
        this.dateRegistry = dateRegistry;
    }

    @DynamoDBAttribute(attributeName = "transaction")
    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FraudData{" +
                "code='" + code + '\'' +
                ", dateRegistry='" + dateRegistry + '\'' +
                ", transaction='" + transaction + '\'' +
                ", status='" + status + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}

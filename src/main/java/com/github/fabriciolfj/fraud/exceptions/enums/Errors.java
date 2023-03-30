package com.github.fabriciolfj.fraud.exceptions.enums;

import java.util.ResourceBundle;

public enum Errors {

    FRAUD_TIME,
    FRAUD_VALUE;

    public String toMessage() {
        var bundle = ResourceBundle.getBundle("messages/exceptions");
        return bundle.getString(this.name() + ".message");
    }
}

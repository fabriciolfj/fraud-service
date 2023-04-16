package com.github.fabriciolfj.fraud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FraudEntity {

    private String code;
    private String transaciton;
    private LocalDateTime date;
    private String customer;
    private BigDecimal value;
    private StatusFraudEntity status;

    public FraudEntity toDisapproved() {
        this.status = StatusFraudEntity.DISAPPROVED;
        return this;
    }

    public FraudEntity toApproved() {
        this.status = StatusFraudEntity.APPROVED;
        return this;
    }

    private boolean isHoursValid(final Integer hours) {
        return date.getHour() >= hours;
    }

    private boolean isValueValid(final BigDecimal value) {
        return value.compareTo(value) >= 0;
    }

    public boolean isTransactionValid(final BigDecimal value, final Integer hours) {
        return isHoursValid(hours) && isValueValid(value);
    }
}

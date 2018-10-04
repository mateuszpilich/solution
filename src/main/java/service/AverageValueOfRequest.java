package service;

import java.math.BigDecimal;

public class AverageValueOfRequest {
    private BigDecimal value;

    public AverageValueOfRequest(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

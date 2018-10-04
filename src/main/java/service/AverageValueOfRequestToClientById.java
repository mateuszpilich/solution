package service;

import java.math.BigDecimal;

public class AverageValueOfRequestToClientById {
    private Long clientId;
    private BigDecimal value;

    public AverageValueOfRequestToClientById(Long clientId, BigDecimal value) {
        this.clientId = clientId;
        this.value = value;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

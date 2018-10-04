package service;

import java.math.BigDecimal;

public class TotalRequestsPriceToClientById {
    private Long clientId;
    private BigDecimal price;

    public TotalRequestsPriceToClientById(Long clientId, BigDecimal price) {
        this.clientId = clientId;
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

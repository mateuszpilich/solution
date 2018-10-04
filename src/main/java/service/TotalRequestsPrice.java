package service;

import java.math.BigDecimal;

public class TotalRequestsPrice {
    private BigDecimal price;

    public TotalRequestsPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

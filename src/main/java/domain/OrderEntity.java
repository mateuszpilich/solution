package domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderEntity implements Serializable {

    private String clientId;
    private Long requestId;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public OrderEntity(String clientId, Long requestId, String name, Integer quantity, BigDecimal price) {
        this.clientId = clientId;
        this.requestId = requestId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getClientId() {
        return clientId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

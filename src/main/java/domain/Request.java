package domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The class helps represents request.
 */
public class Request implements Serializable {

    private Long id;
    private String clientId;
    private Long requestId;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public Request() {
    }

    public Request(Long id, String clientId, Long requestId, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.clientId = clientId.replaceAll(" ","");
        this.requestId = requestId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

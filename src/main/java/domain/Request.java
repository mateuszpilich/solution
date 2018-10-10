package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The class helps represents request.
 */
public class Request implements Serializable {

    /**
     * This is id for request.
     */
    private Long id;

    /**
     * This is id for client.
     */
    private String clientId;

    /**
     * This is request id.
     */
    private Long requestId;

    /**
     * This is name of request.
     */
    private String name;

    /**
     * This is quantity for request.
     */
    private Integer quantity;

    /**
     * This is price for request.
     */
    private BigDecimal price;

    /**
     * This is empty constructor for request.
     */
    public Request() {
    }

    /**
     * This is construcotor for request.
     *
     * @param rId        is rId for request
     * @param rClientId  is client rId for request
     * @param rRequestId is request rId
     * @param rName      is rName for request
     * @param rQuantity  is rQuantity for request
     * @param rPrice     is rPrice for request
     */
    public Request(final Long rId, final String rClientId,
                   final Long rRequestId,
                   final String rName,
                   final Integer rQuantity, final BigDecimal rPrice) {
        this.id = rId;
        this.clientId = rClientId.replaceAll(" ", "");
        this.requestId = rRequestId;
        this.name = rName;
        this.quantity = rQuantity;
        this.price = rPrice;
    }

    /**
     * This is getter for id for request.
     *
     * @return is id for request
     */
    public final Long getId() {
        return id;
    }

    /**
     * This is setter for rId for request.
     *
     * @param rId is rId for request
     */
    public final void setId(final Long rId) {
        this.id = rId;
    }

    /**
     * This is getter for client id for request.
     *
     * @return is client id for request
     */
    public final String getClientId() {
        return clientId;
    }

    /**
     * This is setter for client id for request.
     *
     * @param rClientId is client for request
     */
    public final void setClientId(final String rClientId) {
        this.clientId = rClientId;
    }

    /**
     * This is getter for request id for request.
     *
     * @return is request id for request
     */
    public final Long getRequestId() {
        return requestId;
    }

    /**
     * This is setter for request id for request.
     *
     * @param rRequestId is request id for request
     */
    public final void setRequestId(final Long rRequestId) {
        this.requestId = rRequestId;
    }

    /**
     * This is getter for request name for request.
     *
     * @return is request name for request
     */
    public final String getName() {
        return name;
    }

    /**
     * This is setter for request name for request.
     *
     * @param rName is request name for request.
     */
    public final void setName(final String rName) {
        this.name = rName;
    }

    /**
     * This is getter for quantity for request.
     *
     * @return is quantity for request
     */
    public final Integer getQuantity() {
        return quantity;
    }

    /**
     * This is setter for rQuantity for request.
     *
     * @param rQuantity is rQuantity for request
     */
    public final void setQuantity(final Integer rQuantity) {
        this.quantity = rQuantity;
    }

    /**
     * This is getter for price for request.
     *
     * @return is price for request
     */
    public final BigDecimal getPrice() {
        return price;
    }

    /**
     * This is setter for rPrice for request.
     *
     * @param rPrice is rPrice for request
     */
    public final void setPrice(final BigDecimal rPrice) {
        this.price = rPrice;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        return Objects.equals(id, request.id)
                && Objects.equals(clientId, request.clientId)
                && Objects.equals(requestId, request.requestId)
                && Objects.equals(name, request.name)
                && Objects.equals(quantity, request.quantity)
                && Objects.equals(price, request.price);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, clientId, requestId, name, quantity, price);
    }

    @Override
    public final String toString() {
        return "Request{"
                + "id=" + id
                + ", clientId='" + clientId + '\''
                + ", requestId=" + requestId
                + ", name='" + name + '\''
                + ", quantity=" + quantity
                + ", price=" + price
                + '}';
    }
}

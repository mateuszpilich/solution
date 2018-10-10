package service;

import java.math.BigDecimal;

/**
 * The class helps represents reports in xml file for total requests price to
 * client by id.
 */
public class TotalRequestsPriceToClientById {
    /**
     * This is client id for total requests price to client by id.
     */
    private Long clientId;

    /**
     * This is price for total requests price to client by id.
     */
    private BigDecimal price;

    /**
     * This is constructor for total requests rPrice to client by id.
     *
     * @param rClientId is client id for total requests rPrice to client by id
     * @param rPrice    is rPrice for total requests rPrice to client by id
     */
    public TotalRequestsPriceToClientById(final Long rClientId,
                                          final BigDecimal rPrice) {
        this.clientId = rClientId;
        this.price = rPrice;
    }

    /**
     * This is getter for total requests rPrice to client by id.
     *
     * @return is client id for total requests rPrice to client by id
     */
    public final Long getClientId() {
        return clientId;
    }

    /**
     * This is setter for total requests rPrice to client by id.
     *
     * @param rClientId is client id for total requests rPrice to client by id
     */
    public final void setClientId(final Long rClientId) {
        this.clientId = rClientId;
    }

    /**
     * This is getter for price for total requests rPrice to client by id.
     *
     * @return is price for total requests rPrice to client by id
     */
    public final BigDecimal getPrice() {
        return price;
    }

    /**
     * This is setter for rPrice for total requests rPrice to client by id.
     *
     * @param rPrice is rPrice for total requests rPrice to client by id
     */
    public final void setPrice(final BigDecimal rPrice) {
        this.price = rPrice;
    }
}

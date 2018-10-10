package service;

import java.math.BigDecimal;

/**
 * The class helps represents reports in xml file for total requests price.
 */
public class TotalRequestsPrice {
    /**
     * This is price for total requests price.
     */
    private BigDecimal price;

    /**
     * This is constructor for total requests rPrice.
     *
     * @param rPrice is rPrice for total requests rPrice
     */
    public TotalRequestsPrice(final BigDecimal rPrice) {
        this.price = rPrice;
    }

    /**
     * This is getter for price for total requests price.
     *
     * @return is price for total requests price
     */
    public final BigDecimal getPrice() {
        return price;
    }

    /**
     * This is setter for rPrice for total requests rPrice.
     *
     * @param rPrice is rPrice for total requests rPrice
     */
    public final void setPrice(final BigDecimal rPrice) {
        this.price = rPrice;
    }
}

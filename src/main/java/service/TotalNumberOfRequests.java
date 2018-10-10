package service;

/**
 * The class helps represent reports in xml file for total number of requests.
 */
public class TotalNumberOfRequests {
    /**
     * This is amount for total number of requests.
     */
    private Long amount;

    /**
     * This is constructor for total number of requests.
     *
     * @param rAmount is rAmount for total number of requests
     */
    public TotalNumberOfRequests(final Long rAmount) {
        this.amount = rAmount;
    }

    /**
     * This is getter for amount for total number of requests.
     *
     * @return is amount for total number of requests
     */
    public final Long getAmount() {
        return amount;
    }

    /**
     * This is setter for rAmount for total number of requests.
     *
     * @param rAmount is rAmount for total number of requests
     */
    public final void setAmount(final Long rAmount) {
        this.amount = rAmount;
    }
}

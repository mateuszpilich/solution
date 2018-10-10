package service;

/**
 * This class helps represents reports in xml file for total requests number
 * to client by id.
 */
public class TotalRequestsNumberToClientById {
    /**
     * This is client id for total requests number to client by id.
     */
    private Long clientId;

    /**
     * This is amount for total requests number to client by id.
     */
    private Long amount;

    /**
     * This is constructor for total requests number to client by id.
     *
     * @param rClientId is client id for total requests number to client by id
     * @param rAmount   is rAmount for total requests number to client by id
     */
    public TotalRequestsNumberToClientById(final Long rClientId,
                                           final Long rAmount) {
        this.clientId = rClientId;
        this.amount = rAmount;
    }

    /**
     * This is getter for client id for total requests number to client by id.
     *
     * @return is client id for total requests number to client by id
     */
    public final Long getClientId() {
        return clientId;
    }

    /**
     * This is setter for client id for total requests number to client by id.
     *
     * @param rClientId is client id for total requests number to client by id
     */
    public final void setClientId(final Long rClientId) {
        this.clientId = rClientId;
    }

    /**
     * This is getter for amount for total requests number to client by id.
     *
     * @return is amount for total requests number to client by id
     */
    public final Long getAmount() {
        return amount;
    }

    /**
     * This is setter for rAmount for total requests number to client by id.
     *
     * @param rAmount is rAmount for total requests number to client by id
     */
    public final void setAmount(final Long rAmount) {
        this.amount = rAmount;
    }
}

package service;

import java.math.BigDecimal;

/**
 * The class helps represents reports in xml for average value of request to
 * client by id.
 */
public class AverageValueOfRequestToClientById {

    /**
     * This is client id for average value of request to client by id.
     */
    private Long clientId;

    /**
     * This is value for average value of request to client by id.
     */
    private BigDecimal value;

    /**
     * This is constructor for average rValue of request to client by id.
     *
     * @param rClientId is client id for average rValue of request to client by
     *                  id
     * @param rValue    is rValue for average rValue of request to client by id
     */
    public AverageValueOfRequestToClientById(final Long rClientId,
                                             final BigDecimal rValue) {
        this.clientId = rClientId;
        this.value = rValue;
    }

    /**
     * This is getter for client id for average value of request to client by
     * id.
     *
     * @return is client id for average value of request to client by id
     */
    public final Long getClientId() {
        return clientId;
    }

    /**
     * This is setter for client id for average value of request to client by
     * id.
     *
     * @param rClientId is client id for average value of request to client by
     *                  id
     */
    public final void setClientId(final Long rClientId) {
        this.clientId = rClientId;
    }

    /**
     * This is getter for value for average value of request to client by
     * id.
     *
     * @return is value for average value of request to client by id
     */
    public final BigDecimal getValue() {
        return value;
    }

    /**
     * This is setter for rValue for average rValue of request to client by
     * id.
     *
     * @param rValue is rValue for average rValue of request to client by id
     */
    public final void setValue(final BigDecimal rValue) {
        this.value = rValue;
    }
}

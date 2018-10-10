package service;

import java.math.BigDecimal;

/**
 * The class helps represents reports in xml for average value of request.
 */
public class AverageValueOfRequest {

    /**
     * This is value for average value of request.
     */
    private BigDecimal value;

    /**
     * This is constructor for average rValue of request.
     *
     * @param rValue is rValue for average rValue of request
     */
    public AverageValueOfRequest(final BigDecimal rValue) {
        this.value = rValue;
    }

    /**
     * This is getter for rValue for average rValue of request.
     *
     * @return is value for average of request
     */
    public final BigDecimal getValue() {
        return value;
    }

    /**
     * This is setter for rValue for average rValue of request.
     *
     * @param rValue is rValue for average rValue of request
     */
    public final void setValue(final BigDecimal rValue) {
        this.value = rValue;
    }
}

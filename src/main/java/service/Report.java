/**
 * Service contain set of functionalities for generating reports.
 *
 * @version 1.0
 */
package service;

import java.sql.SQLException;

/**
 * The class have a set of functionalities for the ReportImpl class.
 */
public interface Report {
    /**
     * Method to count total number of request.
     *
     * @throws SQLException when query is wrong
     */
    void totalRequestsNumber() throws SQLException;

    /**
     * Method to count total number of request to client by id.
     *
     * @param clientId is id to client
     * @throws SQLException when query is wrong
     */
    void totalRequestsNumberToClientById(Long clientId) throws SQLException;

    /**
     * Method to count price for total requests.
     *
     * @throws SQLException when query is wrong
     */
    void totalRequestsPrice() throws SQLException;

    /**
     * Method to count price for total requests to client by id.
     *
     * @param clientId is id to client
     * @throws SQLException when query is wrong
     */
    void totalRequestsPriceToClientById(Long clientId) throws SQLException;

    /**
     * Method to count the list of all requests.
     *
     * @throws SQLException when query is wrong
     */
    void listOfAllRequests() throws SQLException;

    /**
     * Method to count the list of all requests to client by id.
     *
     * @param clientId is id to client
     * @throws SQLException when query is wrong
     */
    void listOfAllRequestsToClientById(Long clientId) throws SQLException;

    /**
     * Method to count average value of request.
     *
     * @throws SQLException when query is wrong
     */
    void averageValueOfRequest() throws SQLException;

    /**
     * Method to count average value of request to client by id.
     *
     * @param clientId is id to client
     * @throws SQLException when query is wrong
     */
    void averageValueOfRequestToClientById(Long clientId) throws SQLException;
}

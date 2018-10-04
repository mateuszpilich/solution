/**
 * Dao contain set of functionalities for queries to database.
 *
 * @version 1.0
 */
package dao;

import domain.Request;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * The class have a set of functionalities for the DaoRepositoryImpl class.
 */
public interface DaoRepository {
    /**
     * Method to add new request to database.
     *
     * @param request is new request
     * @throws SQLException when query is wrong
     */
    void addNewRequest(Request request) throws SQLException;

    /**
     * Method to count total number of request.
     *
     * @return amount total requests
     * @throws SQLException when query is wrong
     */
    Long totalRequestsNumber() throws SQLException;

    /**
     * Method to count total number of request to client by id.
     *
     * @param clientId is id to client
     * @return amount total requests to client by id
     * @throws SQLException when query is wrong
     */
    Long totalRequestsNumberByClientId(Long clientId) throws SQLException;

    /**
     * Method to count price for total requests.
     *
     * @return amount total price for requests
     * @throws SQLException when query is wrong
     */
    BigDecimal totalRequestsPrice() throws SQLException;

    /**
     * Method to count price for total requests to client by id.
     *
     * @param clientId is id to client
     * @return amount total price for requests to client by id
     * @throws SQLException when query is wrong
     */
    BigDecimal totalRequestsPriceByClientId(Long clientId) throws SQLException;

    /**
     * Method to count the list of all requests.
     *
     * @return list of all requests
     * @throws SQLException when query is wrong
     */
    List<Request> listOfAllRequests() throws SQLException;

    /**
     * Method to count the list of all requests to client by id.
     *
     * @param clientId is id to client
     * @return list of all requests to client by id
     * @throws SQLException when query is wrong
     */
    List<Request> listOfAllRequestsToClientById(Long clientId) throws SQLException;

    /**
     * Method to count average value of request.
     *
     * @return average value of request
     * @throws SQLException when query is wrong
     */
    BigDecimal averageValueOfRequest() throws SQLException;

    /**
     * Method to count average value of request to client by id.
     *
     * @param clientId is id to client
     * @return average value of request to client by id
     * @throws SQLException when query is wrong
     */
    BigDecimal averageValueOfRequestToClientById(Long clientId) throws SQLException;
}

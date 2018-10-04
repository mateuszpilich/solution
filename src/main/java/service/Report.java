package service;

import java.sql.SQLException;

/**
 * The class have a set of functionalities for the ReportImpl class.
 */
public interface Report {
    void totalRequestsNumber() throws SQLException;

    void totalRequestsNumberToClientById(Long clientId) throws SQLException;

    void totalRequestsPrice() throws SQLException;

    void totalRequestsPriceToClientById(Long clientId) throws SQLException;

    void listOfAllRequests() throws SQLException;

    void listOfAllRequestsToClientById(Long clientId) throws SQLException;

    void averageValueOfRequest() throws SQLException;

    void averageValueOfRequestToClientById(Long clientId) throws SQLException;
}

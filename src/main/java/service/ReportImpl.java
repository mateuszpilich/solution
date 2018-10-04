package service;

import dao.DaoRepository;
import domain.Request;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * The class helps to generate reports.
 */
public class ReportImpl {

    private DaoRepository daoRepository = new DaoRepository();
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * The method counts the total number of requests.
     *
     * @throws SQLException
     */
    public void totalRequestsNumber() throws SQLException {
        LOGGER.info("Number of total requests: " + daoRepository.totalRequestsNumber());
    }

    /**
     * The method counts the total number of requests for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalRequestsNumberToClientById(Long clientId) throws SQLException {
        LOGGER.info("Number of total requests to client for id: " + clientId + " is: " + daoRepository.totalRequestsNumberByClient(clientId));
    }

    /**
     * The method counts the total amount of requests.
     *
     * @throws SQLException
     */
    public void totalRequestsPrice() throws SQLException {
        LOGGER.info("Price of total requests: " + daoRepository.totalRequestsPrice());
    }

    /**
     * The method counts the total amount of requests for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalRequestsPriceToClientById(Long clientId) throws SQLException {
        LOGGER.info("Price of total requests to client for id: " + clientId + " is: " + daoRepository.totalRequestsPriceByClient(clientId));
    }

    /**
     * The method shows a list of all requests.
     *
     * @throws SQLException
     */
    public void listOfAllRequests() throws SQLException {
        List<Request> requestsEntities = daoRepository.listOfAllRequests();
        LOGGER.info("List of total requests:");
        requestsEntities.forEach(request ->
                LOGGER.info(request.getId() + ","
                        + request.getClientId() + ","
                        + request.getRequestId() + ","
                        + request.getName() + ","
                        + request.getQuantity() + ","
                        + request.getPrice()));
    }

    /**
     * The method shows a list of all requests for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void listOfAllRequestsToClientById(Long clientId) throws SQLException {
        List<Request> requestsEntities = daoRepository.listOfAllRequestsToClientById(clientId);
        LOGGER.info("List of total requests to client for id: " + clientId + " is:");
        requestsEntities.forEach(request ->
                LOGGER.info(request.getId() + ","
                        + request.getClientId() + ","
                        + request.getRequestId() + ","
                        + request.getName() + ","
                        + request.getQuantity() + ","
                        + request.getPrice()));
    }

    /**
     * The method counts average value of request.
     *
     * @throws SQLException
     */
    public void averageValueOfRequest() throws SQLException {
        LOGGER.info("Average value of request: " + daoRepository.averageValueOfRequest());
    }

    /**
     * The method counts the average value of request for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void averageValueOfRequestToClientById(Long clientId) throws SQLException {
        LOGGER.info("Average value of request to client for id: " + clientId + " is: " + daoRepository.averageValueOfRequestToClientById(clientId));
    }
}

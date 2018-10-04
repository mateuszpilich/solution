package service;

import dao.DaoRepository;
import domain.Request;
import org.apache.log4j.Logger;
import writer.XmlWriter;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * The class helps to generate reports.
 */
public class ReportImpl {
    private DaoRepository daoRepository = new DaoRepository();
    private XmlWriter xmlWriter = new XmlWriter();
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * The method counts the total number of requests.
     *
     * @throws SQLException
     */
    public void totalNumberOfRequests() throws SQLException {
        String amount = daoRepository.totalRequestsNumber();
        LOGGER.info("Number of total requests: " + amount);
        xmlWriter.writeReportsToXmlFile("totalNumberOfRequests",
                new TotalNumberOfRequests(Long.parseLong(daoRepository.totalRequestsNumber())));
    }

    /**
     * The method counts the total number of requests for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalRequestsNumberToClientById(Long clientId) throws SQLException {
        String amount = daoRepository.totalRequestsNumberByClient(clientId);
        LOGGER.info("Number of total requests to client for id: " + clientId + " is: " + amount);
        xmlWriter.writeReportsToXmlFile("totalRequestsNumberToClientById",
                new TotalRequestsNumberToClientById(clientId, Long.parseLong(amount)));
    }

    /**
     * The method counts the total amount of requests.
     *
     * @throws SQLException
     */
    public void totalRequestsPrice() throws SQLException {
        BigDecimal price = daoRepository.totalRequestsPrice();
        LOGGER.info("Price of total requests: " + price);
        xmlWriter.writeReportsToXmlFile("totalRequestsPrice", new TotalRequestsPrice(price));
    }

    /**
     * The method counts the total amount of requests for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalRequestsPriceToClientById(Long clientId) throws SQLException {
        BigDecimal price = daoRepository.totalRequestsPriceByClient(clientId);
        LOGGER.info("Price of total requests to client for id: " + clientId + " is: " + price);
        xmlWriter.writeReportsToXmlFile("totalRequestsPriceToClientById", new TotalRequestsPriceToClientById(clientId
                , price));
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
        xmlWriter.writeReportsToXmlFile("listOfAllRequests", new ListOfAllRequests(requestsEntities));
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
        xmlWriter.writeReportsToXmlFile("listOfAllRequestsToClientById", new ListOfAllRequestsToClientById(clientId,
                requestsEntities));
    }

    /**
     * The method counts average value of request.
     *
     * @throws SQLException
     */
    public void averageValueOfRequest() throws SQLException {
        BigDecimal value = daoRepository.averageValueOfRequest();
        LOGGER.info("Average value of request: " + value);
        xmlWriter.writeReportsToXmlFile("averageValueOfRequest", new AverageValueOfRequest(value));
    }

    /**
     * The method counts the average value of request for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void averageValueOfRequestToClientById(Long clientId) throws SQLException {
        BigDecimal value = daoRepository.averageValueOfRequestToClientById(clientId);
        LOGGER.info("Average value of request to client for id: " + clientId + " is: " + value);
        xmlWriter.writeReportsToXmlFile("averageValueOfRequestToClientById",
                new AverageValueOfRequestToClientById(clientId, value));
    }
}

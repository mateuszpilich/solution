/**
 * Dao contain set of functionalities for queries to database.
 */
package dao;

import domain.Request;
import service.ReportImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The class helps send queries to database.
 */
public class DaoRepositoryImpl implements DaoRepository {
    /**
     * This is connection with database.
     */
    private Connection connection;

    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(ReportImpl.class);

    public DaoRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * New statement.
     */
    private Statement statement;

    /**
     * Method to add new request to database.
     *
     * @param request is new request
     * @throws SQLException when query is wrong
     */
    public final void addNewRequest(final Request request) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("insert into REQUEST (clientId,requestId,"
                + "name,quantity,price) values('"
                + request.getClientId() + "',"
                + request.getRequestId() + ",'"
                + request.getName() + "',"
                + request.getQuantity() + ","
                + request.getPrice() + ")");
    }

    /**
     * Method to count total number of requests.
     *
     * @return amount total requests
     * @throws SQLException when query is wrong
     */
    public final Long totalRequestsNumber() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT COUNT(id) FROM REQUEST;");
        Long amount = Long.valueOf(0);
        try {
            if (resultSet.next()) {
                amount = resultSet.getLong(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests in database!");
        }
        return amount;
    }

    /**
     * Method to count total number of requests to client by id.
     *
     * @param clientId is id to client
     * @return amount total requests to client by id
     * @throws SQLException when query is wrong
     */
    public final Long totalRequestsNumberByClientId(final Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT COUNT(id) FROM REQUEST WHERE clientId = "
                        + String.valueOf(clientId) + ";");
        Long amount = null;
        try {
            if (resultSet.next()) {
                amount = resultSet.getLong(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in " +
                    "database!");
        }
        return amount;
    }

    /**
     * Method to count price for total requests.
     *
     * @return amount total price for requests
     * @throws SQLException when query is wrong
     */
    public final BigDecimal totalRequestsPrice() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT SUM(price) FROM REQUEST;");
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests in database!");
        }
        return price.setScale(2, BigDecimal.ROUND_CEILING);
    }

    /**
     * Method to count price for total requests to client by id.
     *
     * @param clientId is id to client
     * @return amount total price for requests to client by id
     * @throws SQLException when query is wrong
     */
    public final BigDecimal totalRequestsPriceByClientId(final Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT SUM(price) FROM REQUEST WHERE clientId = "
                        + String.valueOf(clientId) + ";");
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in " +
                    "database!");
        }
        return price.setScale(2, BigDecimal.ROUND_CEILING);
    }

    /**
     * Method to count the list of all requests.
     *
     * @return list of all requests
     * @throws SQLException when query is wrong
     */
    public final List<Request> listOfAllRequests() throws SQLException {
        List<Request> listOfAllRequests = new ArrayList<Request>();
        ResultSet resultSet = executeQuery("SELECT * FROM REQUEST");
        while (resultSet.next()) {
            listOfAllRequests.add(prepareRequest(resultSet));
        }
        return listOfAllRequests;
    }

    /**
     * Method to count the list of all requests to client by id.
     *
     * @param clientId is id to client
     * @return list of all requests to client by id
     * @throws SQLException when query is wrong
     */
    public final List<Request> listOfAllRequestsToClientById(final Long clientId) throws SQLException {
        List<Request> listOfAllRequestsToClient = new ArrayList<Request>();
        ResultSet resultSet = executeQuery("SELECT * FROM REQUEST WHERE "
                + "clientId = " + String.valueOf(clientId) + ";");
        while (resultSet.next()) {
            listOfAllRequestsToClient.add(prepareRequest(resultSet));
        }
        return listOfAllRequestsToClient;
    }

    /**
     * Method to count average value of request.
     *
     * @return average value of request
     * @throws SQLException when query is wrong
     */
    public final BigDecimal averageValueOfRequest() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT AVG(price) FROM REQUEST");
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests in database!");
        }
        return price.setScale(2, BigDecimal.ROUND_CEILING);
    }

    /**
     * Method to count average value of request to client by id.
     *
     * @param clientId is id to client
     * @return average value of request to client by id
     * @throws SQLException when query is wrong
     */
    public final BigDecimal averageValueOfRequestToClientById(final Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT AVG(price) FROM REQUEST WHERE clientId ="
                        + String.valueOf(clientId) + ";");
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in " +
                    "database!");
        }
        return price.setScale(2, BigDecimal.ROUND_CEILING);
    }

    /**
     * Method to execute query to database.
     *
     * @param query is query to database
     * @return result set from database
     * @throws SQLException when query is wrong
     */
    protected ResultSet executeQuery(final String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Method to prepare new request.
     *
     * @param resultSet is result set from database
     * @return new request
     * @throws SQLException when query is wrong
     */
    protected Request prepareRequest(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String clientIdRs = resultSet.getString("clientId");
        Long requestId = resultSet.getLong("requestId");
        String name = resultSet.getString("name");
        Integer quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new Request(id, clientIdRs, requestId, name, quantity, price);
    }
}

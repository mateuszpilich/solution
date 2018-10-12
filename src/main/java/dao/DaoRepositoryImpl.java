package dao;

import domain.Request;
import service.ReportImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    /**
     * This is logger.
     */
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(ReportImpl.class);

    /**
     * This is query for count all requests.
     */
    private static final String SELECT_COUNT_ID = "SELECT COUNT(id) FROM "
            + "request;";

    /**
     * This is query for count all requests to client by id.
     */
    private static final String SELECT_COUNT_BY_CLIENT_ID = "SELECT COUNT(id)"
            + " FROM request WHERE client_id = ?";

    /**
     * This is query for sum of price for all requests.
     */
    private static final String SELECT_SUM_PRICE = "SELECT SUM(price) FROM "
            + "request;";

    /**
     * This is query for sum of price for all requests by client id.
     */
    private static final String SELECT_SUM_PRICE_BY_CLIENT_ID = "SELECT SUM"
            + "(price) FROM request WHERE client_id = ?";

    /**
     * This is query for select all requests.
     */
    private static final String SELECT_ALL = "SELECT * FROM request";

    /**
     * This is query for select all requests by client id.
     */
    private static final String SELECT_ALL_BY_CLIENT_ID = "SELECT * FROM "
            + "request WHERE client_id = ?";

    /**
     * This is query for select average price for all requests.
     */
    private static final String SELECT_AVG_PRICE = "SELECT AVG(price) FROM "
            + "request";

    /**
     * This is query for select average price for all requests by client id.
     */
    private static final String SELECT_AVG_PRICE_BY_CLIENT_ID = "SELECT AVG"
            + "(price) FROM request WHERE client_id = ?";

    /**
     * This is constructor DaoRepositoryImpl.
     *
     * @param con for connect to database
     */
    public DaoRepositoryImpl(final Connection con) {
        this.connection = con;
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
        statement.executeUpdate("insert into request (client_id,request_id,"
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
    public final Long totalRequestsNumber() {
        ResultSet resultSet = null;
        Long amount = null;
        try {
            resultSet = executeQuery(SELECT_COUNT_ID);
            if (resultSet != null && resultSet.next()) {
                amount = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.fatal("Error while executing query!");
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
    public final Long totalRequestsNumberByClientId(final Long clientId) throws
            SQLException {
        PreparedStatement stmt =
                connection.prepareStatement(SELECT_COUNT_BY_CLIENT_ID);
        stmt.setLong(1, clientId);
        ResultSet resultSet = stmt.executeQuery();
        Long amount = null;
        try {
            if (resultSet.next()) {
                amount = resultSet.getLong(1);
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in "
                    + "database!");
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
        ResultSet resultSet = null;
        BigDecimal price = null;
        try {
            resultSet = executeQuery(SELECT_SUM_PRICE);
            if (resultSet != null && resultSet.next()) {
                price = resultSet.getBigDecimal(1);
                if (price == null) {
                    price = BigDecimal.ZERO;
                }
            }
        } catch (SQLException e) {
            LOGGER.fatal("Error while executing query!");
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
    public final BigDecimal totalRequestsPriceByClientId(
            final Long clientId) throws SQLException {
        PreparedStatement stmt =
                connection.prepareStatement(SELECT_SUM_PRICE_BY_CLIENT_ID);
        stmt.setLong(1, clientId);
        ResultSet resultSet = stmt.executeQuery();
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
                if (price == null) {
                    price = BigDecimal.ZERO;
                }
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in "
                    + "database!");
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
        ResultSet resultSet = null;
        try {
            resultSet = executeQuery(SELECT_ALL);
            if (resultSet != null) {
                while (resultSet.next()) {
                    listOfAllRequests.add(prepareRequest(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.fatal("Error while executing query!");
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
    public final List<Request> listOfAllRequestsToClientById(
            final Long clientId) throws SQLException {
        List<Request> listOfAllRequestsToClient = new ArrayList<Request>();
        PreparedStatement stmt =
                connection.prepareStatement(SELECT_ALL_BY_CLIENT_ID);
        stmt.setLong(1, clientId);
        ResultSet resultSet = stmt.executeQuery();
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
        ResultSet resultSet = null;
        BigDecimal price = null;
        try {
            resultSet = executeQuery(SELECT_AVG_PRICE);
            if (resultSet != null && resultSet.next()) {
                price = resultSet.getBigDecimal(1);
                if (price == null) {
                    price = BigDecimal.ZERO;
                }
            }
        } catch (SQLException e) {
            LOGGER.fatal("Error while executing query!");
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
    public final BigDecimal averageValueOfRequestToClientById(
            final Long clientId) throws SQLException {
        PreparedStatement stmt =
                connection.prepareStatement(SELECT_AVG_PRICE_BY_CLIENT_ID);
        stmt.setLong(1, clientId);
        ResultSet resultSet = stmt.executeQuery();
        BigDecimal price = null;
        try {
            if (resultSet.next()) {
                price = resultSet.getBigDecimal(1);
                if (price == null) {
                    price = BigDecimal.ZERO;
                }
            }
        } catch (NullPointerException e) {
            LOGGER.info("No requests for client id: " + clientId + " in "
                    + "database!");
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
    protected final ResultSet executeQuery(final String query) throws
            SQLException {
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
    protected final Request prepareRequest(final ResultSet resultSet) throws
            SQLException {
        Long id = resultSet.getLong("id");
        String clientIdRs = resultSet.getString("client_id");
        Long requestId = resultSet.getLong("request_id");
        String name = resultSet.getString("name");
        Integer quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new Request(id, clientIdRs, requestId, name, quantity, price);
    }
}

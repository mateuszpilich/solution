package dao;

import domain.Request;
import settings.H2JdbcConnection;

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
public class DaoRepository {
    private Connection connection = new H2JdbcConnection().getConnection();
    private Statement statement;

    public void addNewRequest(Request request) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("insert into REQUEST (clientId,requestId,name,quantity,price) values('"
                + request.getClientId() + "',"
                + request.getRequestId() + ",'"
                + request.getName() + "',"
                + request.getQuantity() + ","
                + request.getPrice() + ")");
    }

    public String totalRequestsNumber() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT COUNT(id) FROM REQUEST;");
        String amount = String.valueOf(0);
        if (resultSet.next()) {
            amount = resultSet.getString(1);
        }
        return amount;
    }

    public String totalRequestsNumberByClient(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT COUNT(id) FROM REQUEST WHERE clientId = " + String.valueOf(clientId) + ";");
        String amount = String.valueOf(0);
        if (resultSet.next()) {
            amount = resultSet.getString(1);
        }
        return amount;
    }

    public BigDecimal totalRequestsPrice() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT SUM(price) FROM REQUEST;");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal totalRequestsPriceByClient(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT SUM(price) FROM REQUEST WHERE clientId = " + String.valueOf(clientId) + ";");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public List<Request> listOfAllRequests() throws SQLException {
        List<Request> listOfAllRequests = new ArrayList<Request>();
        ResultSet resultSet = executeQuery("SELECT * FROM REQUEST");
        while (resultSet.next()) {
            listOfAllRequests.add(prepareRequest(resultSet));
        }
        return listOfAllRequests;
    }

    public List<Request> listOfAllRequestsToClientById(Long clientId) throws SQLException {
        List<Request> listOfAllRequestsToClient = new ArrayList<Request>();
        ResultSet resultSet = executeQuery("SELECT * FROM REQUEST WHERE clientId = " + String.valueOf(clientId) +
                ";");
        while (resultSet.next()) {
            listOfAllRequestsToClient.add(prepareRequest(resultSet));
        }
        return listOfAllRequestsToClient;
    }

    public BigDecimal averageValueOfRequest() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT AVG(price) FROM REQUEST");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal averageValueOfRequestToClientById(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT AVG(price) FROM REQUEST WHERE clientId = " + String.valueOf(clientId) + ";");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    private ResultSet executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    private Request prepareRequest(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String clientIdRs = resultSet.getString("clientId");
        Long requestId = resultSet.getLong("requestId");
        String name = resultSet.getString("name");
        Integer quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new Request(id, clientIdRs, requestId, name, quantity, price);
    }
}

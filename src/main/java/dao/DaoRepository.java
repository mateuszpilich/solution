package dao;

import settings.H2JdbcConnection;
import domain.OrderEntity;

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

    public void addNewOrder(OrderEntity orderEntity) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("insert into \"ORDER\"(clientId,requestId,name,quantity,price) values('"
                + orderEntity.getClientId() + "',"
                + orderEntity.getRequestId() + ",'"
                + orderEntity.getName() + "',"
                + orderEntity.getQuantity() + ","
                + orderEntity.getPrice() + ")");
    }

    public String totalOrdersNumber() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT COUNT(id) FROM \"ORDER\";");
        String amount = String.valueOf(0);
        if (resultSet.next()) {
            amount = resultSet.getString(1);
        }
        return amount;
    }

    public String totalOrdersNumberByClient(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT COUNT(id) FROM \"ORDER\" WHERE clientId = " + String.valueOf(clientId) + ";");
        String amount = String.valueOf(0);
        if (resultSet.next()) {
            amount = resultSet.getString(1);
        }
        return amount;
    }

    public BigDecimal totalOrdersPrice() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT SUM(price) FROM \"ORDER\";");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal totalOrdersPriceByClient(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT SUM(price) FROM \"ORDER\" WHERE clientId = " + String.valueOf(clientId) + ";");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public List<OrderEntity> listOfAllOrders() throws SQLException {
        List<OrderEntity> listOfAllOrders = new ArrayList<OrderEntity>();
        ResultSet resultSet = executeQuery("SELECT * FROM \"ORDER\"");
        while (resultSet.next()) {
            listOfAllOrders.add(prepareOrder(resultSet));
        }
        return listOfAllOrders;
    }

    public List<OrderEntity> listOfAllOrdersToClientById(Long clientId) throws SQLException {
        List<OrderEntity> listOfAllOrdersToClient = new ArrayList<OrderEntity>();
        ResultSet resultSet = executeQuery("SELECT * FROM \"ORDER\" WHERE clientId = " + String.valueOf(clientId) +
                ";");
        while (resultSet.next()) {
            listOfAllOrdersToClient.add(prepareOrder(resultSet));
        }
        return listOfAllOrdersToClient;
    }

    public BigDecimal averageValueOfOrder() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT AVG(price) FROM \"ORDER\"");
        String price = String.valueOf(0);
        if (resultSet.next()) {
            price = resultSet.getString(1);
        }
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal averageValueOfOrderToClientById(Long clientId) throws SQLException {
        ResultSet resultSet =
                executeQuery("SELECT AVG(price) FROM \"ORDER\" WHERE clientId = " + String.valueOf(clientId) + ";");
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

    private OrderEntity prepareOrder(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String clientIdRs = resultSet.getString("clientId");
        Long requestId = resultSet.getLong("requestId");
        String name = resultSet.getString("name");
        Integer quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new OrderEntity(id, clientIdRs, requestId, name, quantity, price);
    }
}

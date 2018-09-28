package dao;

import db_settings.H2JdbcConnection;
import domain.OrderEntity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoRepository {

    private Connection connection = new H2JdbcConnection().getConnection();
    private Statement statement;

    public DaoRepository() {
    }

    public Long totalOrdersNumber() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT COUNT(id) FROM order;");
        return resultSet.getLong("COUNT(id)");
    }

    public Long totalOrdersNumberByClient(Long clientId) throws SQLException {
        ResultSet resultSet = executeQuery("SELECT COUNT(id) FROM order WHERE " + String.valueOf(clientId) + ";");
        return resultSet.getLong("COUNT(id)");
    }

    public BigDecimal totalOrdersPrice() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT SUM(price) FROM order;");
        return resultSet.getBigDecimal("SUM(price)");
    }

    public BigDecimal totalOrdersPriceByClient(Long clientId) throws SQLException {
        ResultSet resultSet = executeQuery("SELECT SUM(price) FROM order WHERE " + String.valueOf(clientId) + ";");
        return resultSet.getBigDecimal("SUM(price)");
    }

    public List<OrderEntity> listOfAllOrders() throws SQLException {
        List<OrderEntity> listOfAllOrders = new ArrayList<OrderEntity>();
        ResultSet resultSet = executeQuery("SELECT * FROM order");
        while (resultSet.next()) {
            listOfAllOrders.add(prepareOrder(resultSet));
        }
        return listOfAllOrders;
    }

    public List<OrderEntity> listOfAllOrdersToClientById(Long clientId) throws SQLException {
        List<OrderEntity> listOfAllOrdersToClient = new ArrayList<OrderEntity>();
        ResultSet resultSet = executeQuery("SELECT * FROM order WHERE " + String.valueOf(clientId) + ";");
        while (resultSet.next()) {
            listOfAllOrdersToClient.add(prepareOrder(resultSet));
        }
        return listOfAllOrdersToClient;
    }

    public BigDecimal averageValueOfOrder() throws SQLException {
        ResultSet resultSet = executeQuery("SELECT AVG(price) FROM order");
        return resultSet.getBigDecimal("AVG(price)");
    }

    public BigDecimal averageValueOfOrderToClientById(Long clientId) throws SQLException {
        ResultSet resultSet = executeQuery("SELECT AVG(price) FROM order WHERE " + String.valueOf(clientId) + ";");
        return resultSet.getBigDecimal("AVG(price)");
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
        OrderEntity orderEntity = new OrderEntity(id, clientIdRs, requestId, name, quantity, price);
        return orderEntity;
    }
}
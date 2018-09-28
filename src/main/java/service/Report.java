package service;

import dao.DaoRepository;
import domain.OrderEntity;

import java.sql.SQLException;
import java.util.List;

public class Report {

    private DaoRepository daoRepository = new DaoRepository();

    public Report() {
    }

    public void totalOrdersNumber() throws SQLException {
        System.out.println("Number of total orders: " + daoRepository.totalOrdersNumber());
    }

    public void totalOrdersNumberToClientById(Long clientId) throws SQLException {
        System.out.println("Number of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersNumberByClient(clientId));
    }

    public void totalOrdersPrice() throws SQLException {
        System.out.println("Price of total orders: " + daoRepository.totalOrdersPrice());
    }

    public void totalOrdersPriceToClientById(Long clientId) throws SQLException {
        System.out.println("Price of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersPriceByClient(clientId));
    }

    public void listOfAllOrders() throws SQLException {
        List<OrderEntity> orderEntities = daoRepository.listOfAllOrders();
        System.out.println("List of total orders:");
        orderEntities.forEach(System.out::println);
    }

    public void listOfAllOrdersToClientById(Long clientId) throws SQLException {
        List<OrderEntity> orderEntities = daoRepository.listOfAllOrdersToClientById(clientId);
        System.out.println("List of total orders to client for id: " + clientId + " is:");
        orderEntities.forEach(System.out::println);
    }

    public void averageValueOfOrder() throws SQLException {
        System.out.println("Average value of order: " + daoRepository.averageValueOfOrder());
    }

    public void averageValueOfOrderToClientById(Long clientId) throws SQLException {
        System.out.println("Average value of order to client for id: " + clientId + " is: " + daoRepository.averageValueOfOrderToClientById(clientId));
    }
}
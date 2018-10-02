package service;

import dao.DaoRepository;
import domain.OrderEntity;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * The class helps to generate reports.
 */
public class Report {

    private DaoRepository daoRepository = new DaoRepository();
    private static Logger logger = Logger.getLogger(Report.class);

    public void totalOrdersNumber() throws SQLException {
        logger.debug("Number of total orders: " + daoRepository.totalOrdersNumber());
    }

    public void totalOrdersNumberToClientById(Long clientId) throws SQLException {
        logger.debug("Number of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersNumberByClient(clientId));
    }

    public void totalOrdersPrice() throws SQLException {
        logger.debug("Price of total orders: " + daoRepository.totalOrdersPrice());
    }

    public void totalOrdersPriceToClientById(Long clientId) throws SQLException {
        logger.debug("Price of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersPriceByClient(clientId));
    }

    public void listOfAllOrders() throws SQLException {
        List<OrderEntity> orderEntities = daoRepository.listOfAllOrders();
        logger.debug("List of total orders:");
        orderEntities.forEach(order ->
                logger.debug(order.getId() + ","
                        + order.getClientId() + ","
                        + order.getRequestId() + ","
                        + order.getName() + ","
                        + order.getQuantity() + ","
                        + order.getPrice()));
    }

    public void listOfAllOrdersToClientById(Long clientId) throws SQLException {
        List<OrderEntity> orderEntities = daoRepository.listOfAllOrdersToClientById(clientId);
        logger.debug("List of total orders to client for id: " + clientId + " is:");
        orderEntities.forEach(order ->
                logger.debug(order.getId() + ","
                        + order.getClientId() + ","
                        + order.getRequestId() + ","
                        + order.getName() + ","
                        + order.getQuantity() + ","
                        + order.getPrice()));
    }

    public void averageValueOfOrder() throws SQLException {
        logger.debug("Average value of order: " + daoRepository.averageValueOfOrder());
    }

    public void averageValueOfOrderToClientById(Long clientId) throws SQLException {
        logger.debug("Average value of order to client for id: " + clientId + " is: " + daoRepository.averageValueOfOrderToClientById(clientId));
    }
}

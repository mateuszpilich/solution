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

    /**
     * The method counts the total number of orders.
     *
     * @throws SQLException
     */
    public void totalOrdersNumber() throws SQLException {
        logger.debug("Number of total orders: " + daoRepository.totalOrdersNumber());
    }

    /**
     * The method counts the total number of orders for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalOrdersNumberToClientById(Long clientId) throws SQLException {
        logger.debug("Number of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersNumberByClient(clientId));
    }

    /**
     * The method counts the total amount of orders.
     *
     * @throws SQLException
     */
    public void totalOrdersPrice() throws SQLException {
        logger.debug("Price of total orders: " + daoRepository.totalOrdersPrice());
    }

    /**
     * The method counts the total amount of orders for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void totalOrdersPriceToClientById(Long clientId) throws SQLException {
        logger.debug("Price of total orders to client for id: " + clientId + " is: " + daoRepository.totalOrdersPriceByClient(clientId));
    }

    /**
     * The method shows a list of all orders.
     *
     * @throws SQLException
     */
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

    /**
     * The method shows a list of all orders for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
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

    /**
     * The method counts average value of order.
     *
     * @throws SQLException
     */
    public void averageValueOfOrder() throws SQLException {
        logger.debug("Average value of order: " + daoRepository.averageValueOfOrder());
    }

    /**
     * The method counts the average value of order for the customer with the indicated id.
     *
     * @param clientId
     * @throws SQLException
     */
    public void averageValueOfOrderToClientById(Long clientId) throws SQLException {
        logger.debug("Average value of order to client for id: " + clientId + " is: " + daoRepository.averageValueOfOrderToClientById(clientId));
    }
}

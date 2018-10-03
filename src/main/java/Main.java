import dao.DaoRepository;
import domain.OrderEntity;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import parser.Parser;
import parser.ParserImpl;
import service.Report;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the program.
 */
public class Main {
    private final static Parser parser = new ParserImpl();
    private final static String filePathCsv = "C://orders.csv";
    private final static String filePathXml = "C://orders.xml";
    private final static String[] filesPaths = {"C://orders.csv", "C://orders.xml"};
    private static Logger logger = Logger.getLogger(Report.class);

    public static void main(String[] args) {
        DaoRepository daoRepository = new DaoRepository();
        List<OrderEntity> newOrdersEntities = new ArrayList<OrderEntity>();
        try {
            newOrdersEntities = parser.readDataFromFile(filesPaths, true);
        } catch (UnsupportedFileExtensionException e) {
            logger.error(e.getMessage());
        }

        newOrdersEntities.forEach(newOrderEntity -> {
            try {
                daoRepository.addNewOrder(newOrderEntity);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        });

        Report report = new Report();
        try {
            report.totalOrdersNumber();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.totalOrdersNumberToClientById(1L);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.totalOrdersPrice();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.totalOrdersPriceToClientById(1L);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.listOfAllOrders();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.listOfAllOrdersToClientById(1L);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.averageValueOfOrder();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        try {
            report.averageValueOfOrderToClientById(1L);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}

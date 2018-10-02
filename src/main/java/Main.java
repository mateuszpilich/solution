import dao.DaoRepository;
import domain.OrderEntity;
import parser.IParser;
import parser.Parser;
import service.Report;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String filePathCsv = "C://orders.csv";
    private final static String filePathXml = "C://orders.xml";
    private final static IParser parser = new Parser();

    public static void main(String[] args) throws SQLException {
        DaoRepository daoRepository = new DaoRepository();
        List<OrderEntity> newOrdersEntity = new ArrayList<OrderEntity>();
        newOrdersEntity = parser.readDataFromFile(filePathCsv, true);

        newOrdersEntity.forEach(newOrderEntity -> {
            try {
                daoRepository.addNewOrder(newOrderEntity);
            } catch (SQLException e) {
            }
        });

        Report report = new Report();
        report.totalOrdersNumber();
        report.totalOrdersNumberToClientById(1L);
        report.totalOrdersPrice();
        report.totalOrdersPriceToClientById(1L);
        report.listOfAllOrders();
        report.listOfAllOrdersToClientById(1L);
        report.averageValueOfOrder();
        report.averageValueOfOrderToClientById(1L);
    }
}

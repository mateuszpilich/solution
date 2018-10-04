import dao.DaoRepository;
import domain.Request;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import parser.Parser;
import parser.ParserImpl;
import service.Report;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The main class of the program.
 */
public class Main {
    private static final Parser PARSER = new ParserImpl();
    private static final List<String> filesPaths = Arrays.asList("C://requests.csv", "C://requests.xml");
    private static final Logger LOGGER = Logger.getLogger(Report.class);

    public static void main(String[] args) {
        //List<String> filesPaths = Arrays.asList(args);
        DaoRepository daoRepository = new DaoRepository();
        List<Request> newRequestsEntities = new ArrayList<Request>();
        try {
            newRequestsEntities = PARSER.readDataFromFile(filesPaths, true);
        } catch (UnsupportedFileExtensionException e) {
            LOGGER.error(e.getMessage());
        }

        newRequestsEntities.forEach(newRequestEntity -> {
            try {
                daoRepository.addNewRequest(newRequestEntity);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        });

        Report report = new Report();
        try {
            report.totalRequestsNumber();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.totalRequestsNumberToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.totalRequestsPrice();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.totalRequestsPriceToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.listOfAllRequests();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.listOfAllRequestsToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.averageValueOfRequest();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            report.averageValueOfRequestToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

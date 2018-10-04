package main;

import dao.DaoRepository;
import dao.DaoRepositoryImpl;
import domain.Request;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import parser.Parser;
import parser.ParserImpl;
import service.ReportImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The main class of the program.
 */
public class Main {
    private static final Parser PARSER = new ParserImpl();
    private static final DaoRepository DAO_REPOSITORY = new DaoRepositoryImpl();
    private static final List<String> FILES_PATHS = Arrays.asList("C://requests.csv", "C://requests.xml"); //sprawdzic wczytywanie z xml z bledem
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);
    private static List<Request> newRequestsEntities = new ArrayList<Request>();

    public static void main(String[] args) {
        //List<String> filesPaths = Arrays.asList(args);
        try {
            newRequestsEntities = PARSER.readDataFromFiles(FILES_PATHS, true);
        } catch (UnsupportedFileExtensionException e) {
            LOGGER.error(e.getMessage());
        }

        newRequestsEntities.forEach(newRequestEntity -> {
            try {
                DAO_REPOSITORY.addNewRequest(newRequestEntity);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        });

        ReportImpl reportImpl = new ReportImpl();
        try {
            reportImpl.totalNumberOfRequests();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.totalRequestsNumberToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.totalRequestsPrice();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.totalRequestsPriceToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.listOfAllRequests();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.listOfAllRequestsToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.averageValueOfRequest();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            reportImpl.averageValueOfRequestToClientById(1L);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

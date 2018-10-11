package main;

import dao.DaoRepository;
import dao.DaoRepositoryImpl;
import domain.Request;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import parser.Parser;
import parser.ParserImpl;
import service.ReportImpl;
import settings.H2JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The main class of the program.
 */
public final class Main {
    /**
     * This is constructor.
     */
    private Main() {
    }

    /**
     * This is parser.
     */
    private static final Parser PARSER = new ParserImpl();

    /**
     * This is dao repository.
     */
    private static final DaoRepository DAO_REPOSITORY =
            new DaoRepositoryImpl(new H2JdbcConnection().getConnection());

    /**
     * This is logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * This is list of new requests.
     */
    private static List<Request> newRequestsEntities = new ArrayList<Request>();

    /**
     * This is main method of program.
     *
     * @param args are files paths
     */
    public static void main(final String[] args) {
        List<String> filesPaths = Arrays.asList(args);
        try {
            newRequestsEntities = PARSER.readDataFromFiles(filesPaths, true);
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

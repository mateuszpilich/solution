package parser;

import domain.OrderEntity;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import service.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * The class helps read data from xml and csv files.
 */
public class ParserImpl implements Parser {

    private XmlParser xmlParser;
    private CsvParser csvParser;
    private static Logger logger = Logger.getLogger(Report.class);

    public ParserImpl() {
        this.xmlParser = new XmlParser();
        this.csvParser = new CsvParser();
    }

    /**
     * Method to parse contents of files given by paths.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate orders are to be removed, otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     * @throws UnsupportedFileExtensionException when path is not present
     */
    @Override
    public List<OrderEntity> readDataFromFile(String filePath, boolean removeDuplicates) throws UnsupportedFileExtensionException {
        List<OrderEntity> ordersEntities = new ArrayList<>();
        if (filePath != null) {
            if (filePath.toLowerCase().endsWith(".xml")) {
                ordersEntities = xmlParser.readOrders(filePath, removeDuplicates);
            } else if (filePath.toLowerCase().endsWith(".csv")) {
                ordersEntities = csvParser.readOrders(filePath, removeDuplicates);
            }
        } else {
            logger.error("The file with the given extension is not supported.");
            throw new UnsupportedFileExtensionException("The file with the given extension is not supported.");
        }
        return ordersEntities;
    }

    /**
     * Method to parse contents of files given by paths.
     *
     * @param filesPaths       are paths to files
     * @param removeDuplicates true if duplicate orders are to be removed, otherwise false
     * @return list with objects extracted from files, otherwise throws exceptions
     * @throws UnsupportedFileExtensionException when path is not present
     */
    @Override
    public List<OrderEntity> readDataFromFile(String[] filesPaths, boolean removeDuplicates) throws UnsupportedFileExtensionException {
        List<OrderEntity> ordersEntities = new ArrayList<>();
        List<OrderEntity> allOrdersEntities = new ArrayList<>();
        for (int i = 0; i < filesPaths.length; i++) {
            if (filesPaths[i] != null) {
                if (filesPaths[i].toLowerCase().endsWith(".xml")) {
                    ordersEntities = xmlParser.readOrders(filesPaths[i], removeDuplicates);
                } else if (filesPaths[i].toLowerCase().endsWith(".csv")) {
                    ordersEntities = csvParser.readOrders(filesPaths[i], removeDuplicates);
                }
            } else {
                logger.error("The file with the given extension is not supported.");
                throw new UnsupportedFileExtensionException("The file with the given extension is not supported.");
            }
            allOrdersEntities.addAll(ordersEntities);
        }
        return allOrdersEntities;
    }
}

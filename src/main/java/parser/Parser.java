package parser;

import domain.OrderEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The class helps read data from xml and csv files.
 */
public class Parser implements IParser {

    private XmlParser xmlParser;
    private CsvParser csvParser;

    public Parser() {
        this.xmlParser = new XmlParser();
        this.csvParser = new CsvParser();
    }

    /**
     * Method to parse content of file given by path.
     *
     * @param filePath is path to file
     * @return list with objects extracted from file, otherwise throws exception
     * @throws IllegalStateException when path is not present
     */
    @Override
    public List<OrderEntity> readDataFromFile(String filePath, boolean removeDuplicates) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        if (filePath != null) {
            if (filePath.toLowerCase().endsWith(".xml")) {
                orderEntities = xmlParser.readOrders(filePath, removeDuplicates);
            } else if (filePath.toLowerCase().endsWith(".csv")) {
                orderEntities = csvParser.readOrders(filePath, removeDuplicates);
            }
        } else {
            throw new IllegalStateException("Something went wrong."); // TODO: improve it
        }
        return orderEntities;
    }
}

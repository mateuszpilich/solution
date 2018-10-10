package parser;

import domain.Request;
import exceptions.UnsupportedFileExtensionException;
import org.apache.log4j.Logger;
import service.ReportImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class helps read data from xml and csv files.
 */
public class ParserImpl implements Parser {

    /**
     * This is xml parser.
     */
    private XmlParser xmlParser;

    /**
     * This is csv parser.
     */
    private CsvParser csvParser;

    /**
     * This is logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * This is constructor ParserImpl.
     */
    public ParserImpl() {
        this.xmlParser = new XmlParser();
        this.csvParser = new CsvParser();
    }

    /**
     * Method to parse contents of files given by paths.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate requests are to be removed,
     *                         otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     * @throws UnsupportedFileExtensionException when path is not present
     */
    @Override
    public final List<Request> readDataFromFiles(final String filePath,
                                                 final boolean removeDuplicates)
            throws UnsupportedFileExtensionException {
        List<Request> requestsEntities = new ArrayList<>();
        if (filePath != null) {
            if (filePath.toLowerCase().endsWith(".xml")) {
                requestsEntities = xmlParser.readRequests(filePath,
                        removeDuplicates);
            } else if (filePath.toLowerCase().endsWith(".csv")) {
                requestsEntities = csvParser.readRequests(filePath,
                        removeDuplicates);
            }
        } else {
            LOGGER.error("The file with the given extension is not supported.");
            throw new UnsupportedFileExtensionException("The file with the "
                    + "given extension is not supported.");
        }
        return requestsEntities;
    }

    /**
     * Method to parse contents of files given by paths.
     *
     * @param filesPaths       are paths to files
     * @param removeDuplicates true if duplicate requests are to be removed,
     *                         otherwise false
     * @return list with objects extracted from files, otherwise throws
     * exceptions
     * @throws UnsupportedFileExtensionException when path is not present
     */
    @Override
    public final List<Request> readDataFromFiles(final List<String> filesPaths,
                                                 final boolean removeDuplicates)
            throws UnsupportedFileExtensionException {
        List<Request> requestsEntities = new ArrayList<>();
        List<Request> allRequestsEntities = new ArrayList<>();
        requestsEntities.addAll(
                filesPaths.stream()
                        .filter(p -> p != null
                                && (p.endsWith(".xml") || p.endsWith(".csv")))
                        .map(p -> prepareRequests(p, removeDuplicates))
                        .flatMap(List::stream).collect(Collectors.toList())
        );
        allRequestsEntities.addAll(requestsEntities);
        return allRequestsEntities;
    }

    /**
     * This metod helps prepare requests.
     *
     * @param p                is path to file
     * @param removeDuplicates true if duplicate requests are to be removed,
     *                         otherwise false
     * @return list with objects extracted from files
     */
    private List<Request> prepareRequests(final String p,
                                          final boolean removeDuplicates) {
        List<Request> requests = new ArrayList<>();
        if (p.endsWith("xml")) {
            requests.addAll(xmlParser.readRequests(p, removeDuplicates));
        } else {
            requests.addAll(csvParser.readRequests(p, removeDuplicates));
        }
        return requests;
    }
}

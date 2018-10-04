/**
 * Parser contain tools for parse data files to POJO.
 *
 * @version 1.0
 */
package parser;

import domain.Request;
import exceptions.WrongInputDataException;
import org.apache.log4j.Logger;
import service.ReportImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * The class helps read data from files csv.
 */
public class CsvParser {
    /**
     * New request.
     */
    private Request request;

    /**
     * This is number of index for client id.
     */
    private static final int INDEX_FOR_CLIENT_ID = 0;

    /**
     * This is number of index for request id.
     */
    private static final int INDEX_FOR_REQUEST_ID = 1;

    /**
     * This is number of index for name.
     */
    private static final int INDEX_FOR_NAME = 2;

    /**
     * This is number of index for quantity.
     */
    private static final int INDEX_FOR_QUANTITY = 3;

    /**
     * This is number of index for price.
     */
    private static final int INDEX_FOR_PRICE = 4;

    /**
     * This is the list of requests.
     */
    private List<Request> requestsEntities = new ArrayList<Request>();

    /**
     * This is the set of requests.
     */
    private Set<Request> requestsEntitiesWithoutDuplicates =
            new HashSet<Request>();

    /**
     * This is logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * Method to parse content of file given by path.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate requests are to be removed,
     *                         otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     */
    public final List<Request> readRequests(final String filePath,
                                            final boolean removeDuplicates) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath),
                StandardCharsets.UTF_8)) {
            stream.forEach(request -> {
                try {
                    requestsEntities.add(createRequest(request));
                } catch (NumberFormatException e) {
                    LOGGER.error(e.getMessage());
                } catch (WrongInputDataException e) {
                    LOGGER.error(e.getMessage());
                }
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        if (removeDuplicates) {
            requestsEntitiesWithoutDuplicates =
                    new HashSet<Request>(requestsEntities);
            requestsEntities.clear();
            requestsEntities.addAll(requestsEntitiesWithoutDuplicates);
        }
        return requestsEntities;
    }

    /**
     * The method creates a new request from the data from the array.
     *
     * @param requestFromFile data of new request
     * @return new request entity
     * @throws WrongInputDataException incorrect request data
     */
    private Request createRequest(final String requestFromFile) throws WrongInputDataException {
        String[] request = requestFromFile.split(",");
        Request requestEntity;
        try {
            Long id = null;
            String clientId = request[INDEX_FOR_CLIENT_ID];
            Long requestId = Long.parseLong(request[INDEX_FOR_REQUEST_ID]);
            String name = request[INDEX_FOR_NAME];
            Integer quantity = Integer.parseInt(request[INDEX_FOR_QUANTITY]);
            BigDecimal price =
                    BigDecimal.valueOf(Double.parseDouble(request[INDEX_FOR_PRICE]));
            requestEntity = new Request(id, clientId, requestId, name,
                    quantity, price);
        } catch (Exception e) {
            LOGGER.error("Incorrect request data!");
            throw new WrongInputDataException("Incorrect request data!");
        }
        return requestEntity;
    }
}

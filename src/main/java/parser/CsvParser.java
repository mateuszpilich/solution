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
    private Request request;
    private List<Request> requestsEntities = new ArrayList<Request>();
    private Set<Request> requestsEntitiesWithoutDuplicates = new HashSet<Request>();
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * Method to parse content of file given by path.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate requests are to be removed, otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     */
    public List<Request> readRequests(String filePath, boolean removeDuplicates) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
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
            requestsEntitiesWithoutDuplicates = new HashSet<Request>(requestsEntities);
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
    private Request createRequest(String requestFromFile) throws WrongInputDataException {
        String[] request = requestFromFile.split(",");
        Request requestEntity;
        try {
            Long id = null;
            String clientId = request[0];
            Long requestId = Long.parseLong(request[1]);
            String name = request[2];
            Integer quantity = Integer.parseInt(request[3]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request[4]));
            requestEntity = new Request(id, clientId, requestId, name, quantity, price);
        } catch (Exception e) {
            LOGGER.error("Incorrect request data!");
            throw new WrongInputDataException("Incorrect request data!");
        }
        return requestEntity;
    }
}

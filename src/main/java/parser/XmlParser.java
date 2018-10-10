package parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.Request;
import domain.Requests;
import org.apache.log4j.Logger;
import service.ReportImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The class helps read data from xml files.
 */
public class XmlParser {

    /**
     * This is list of requests.
     */
    private List<Request> requestsEntities = new ArrayList<>();

    /**
     * This is list of requests without duplicates.
     */
    private Set<Request> requestsEntitiesWithoutDuplicates = new HashSet<>();

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
        try {
            File file = new File(filePath);
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
            Requests requests = xmlMapper.readValue(xml, Requests.class);
            requestsEntities.addAll(requests.getRequestsEntities());
        } catch (JsonMappingException | JsonParseException e) {
            LOGGER.error("Incorrect request data!");
        } catch (IOException e) {
            LOGGER.error("Input data are incorrect!");
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
     * The method reads the data line by line from the file.
     *
     * @param inputStream next byte of data from the input stream
     * @return all bytes of data
     * @throws IOException when data on input or output are incorrect
     */
    private static String inputStreamToString(final InputStream inputStream)
            throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(inputStream));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}

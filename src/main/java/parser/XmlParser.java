package parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.OrderEntity;
import domain.OrdersEntities;

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
 * The class helps read data from files xml.
 */
public class XmlParser {
    private List<OrderEntity> ordersEntities = new ArrayList<>();
    private Set<OrderEntity> ordersEntitiesWithoutDuplicates = new HashSet<>();

    /**
     * Method to parse content of file given by path.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate orders are to be removed, otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     */
    public List<OrderEntity> readOrders(String filePath, boolean removeDuplicates) {
        try {
            File file = new File(filePath);
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
            OrdersEntities orders = xmlMapper.readValue(xml, OrdersEntities.class);
            ordersEntities.addAll(orders.getOrdersEntities());
        } catch (Exception e) {
        }
        if (removeDuplicates) {
            ordersEntitiesWithoutDuplicates = new HashSet<OrderEntity>(ordersEntities);
            ordersEntities.clear();
            ordersEntities.addAll(ordersEntitiesWithoutDuplicates);
        }
        return ordersEntities;
    }

    /**
     * The method reads the data line by line from the file.
     *
     * @param inputStream next byte of data from the input stream
     * @return all bytes of data
     * @throws IOException
     */
    private static String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}

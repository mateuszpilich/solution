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
 * Parser xml is for read data from files xml.
 */
public class ParserXML {

    public List<OrderEntity> readOders(String filePath, boolean removeDuplicates) {
        Set<OrderEntity> ordersEntityWithoutDuplicates = new HashSet<OrderEntity>();
        List<OrderEntity> ordersEntities = new ArrayList<OrderEntity>();

        try {
            File file = new File(filePath);
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
            OrdersEntities orders = xmlMapper.readValue(xml, OrdersEntities.class);
            ordersEntities.addAll(orders.getOrdersEntities());
        } catch (Exception e) {
        }
        if (removeDuplicates) {
            ordersEntityWithoutDuplicates = new HashSet<OrderEntity>(ordersEntities);
            ordersEntities.clear();
            ordersEntities.addAll(ordersEntityWithoutDuplicates);
        }
        return ordersEntities;
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}

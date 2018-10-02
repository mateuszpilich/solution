package parser;

import domain.OrderEntity;
import exceptions.WrongInputDataException;

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
     * Method to parse content of file given by path.
     *
     * @param filePath         is path to file
     * @param removeDuplicates true if duplicate orders are to be removed, otherwise false
     * @return list with objects extracted from file, otherwise throws exception
     */
    public List<OrderEntity> readOrders(String filePath, boolean removeDuplicates) {
        Set<OrderEntity> ordersEntityWithoutDuplicates = new HashSet<OrderEntity>();
        List<OrderEntity> orderEntities = new ArrayList<OrderEntity>();
        OrderEntity orderEntity;

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(order -> {
                try {
                    orderEntities.add(createOrder(order));
                } catch (NumberFormatException e) {
                } catch (WrongInputDataException e) {
                }
            });
        } catch (IOException e) {
        }

        if (removeDuplicates) {
            ordersEntityWithoutDuplicates = new HashSet<OrderEntity>(orderEntities);
            orderEntities.clear();
            orderEntities.addAll(ordersEntityWithoutDuplicates);
        }
        return orderEntities;
    }

    /**
     * The method creates a new order from the data from the array.
     *
     * @param orderFromFile data of new order
     * @return new order entity
     * @throws WrongInputDataException incorrect order data
     */
    private OrderEntity createOrder(String orderFromFile) throws WrongInputDataException {
        String[] order = orderFromFile.split(",");
        OrderEntity orderEntity;
        try {
            Long id = null;
            String clientId = order[0];
            Long requestId = Long.parseLong(order[1]);
            String name = order[2];
            Integer quantity = Integer.parseInt(order[3]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(order[4]));
            orderEntity = new OrderEntity(id, clientId, requestId, name, quantity, price);
        } catch (Exception e) {
            throw new WrongInputDataException("Incorrect order data!");
        }
        return orderEntity;
    }
}

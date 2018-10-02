package parser;

import domain.OrderEntity;

import java.util.List;

public interface IParser {
    List<OrderEntity> readDataFromFile(String filePath, boolean removeDuplicates);
}

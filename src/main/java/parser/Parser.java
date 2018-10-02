package parser;

import domain.OrderEntity;
import exceptions.UnsupportedFileExtensionException;

import java.util.List;

/**
 * The class have a set of functionalities for the ParserImpl class.
 */
public interface Parser {
    List<OrderEntity> readDataFromFile(String filePath, boolean removeDuplicates) throws UnsupportedFileExtensionException;
    List<OrderEntity> readDataFromFile(String[] filesPaths, boolean removeDuplicates) throws UnsupportedFileExtensionException;
}

package parser;

import domain.Request;
import exceptions.UnsupportedFileExtensionException;

import java.util.List;

/**
 * The class have a set of functionalities for the ParserImpl class.
 */
public interface Parser {
    List<Request> readDataFromFile(String filePath, boolean removeDuplicates) throws UnsupportedFileExtensionException;

    List<Request> readDataFromFile(List<String> filesPaths, boolean removeDuplicates) throws UnsupportedFileExtensionException;
}

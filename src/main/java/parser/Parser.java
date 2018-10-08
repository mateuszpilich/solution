package parser;

import domain.Request;
import exceptions.UnsupportedFileExtensionException;

import java.util.List;

/**
 * This interface have a set of functionalities for the Parser.
 */
public interface Parser {
    List<Request> readDataFromFiles(String filePath,
                                    boolean removeDuplicates) throws UnsupportedFileExtensionException;

    List<Request> readDataFromFiles(List<String> filesPaths,
                                    boolean removeDuplicates) throws UnsupportedFileExtensionException;
}

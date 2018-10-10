package parser;

import domain.Request;
import exceptions.UnsupportedFileExtensionException;

import java.util.List;

/**
 * This interface have a set of functionalities for the Parser.
 */
public interface Parser {
    /**
     * Metod to read data from file.
     *
     * @param filePath         is path to file
     * @param removeDuplicates is true when want remove duplicates if not false
     * @return is list of requests
     * @throws UnsupportedFileExtensionException when file extension is
     *                                           unsupported
     */
    List<Request> readDataFromFiles(String filePath, boolean removeDuplicates)
            throws UnsupportedFileExtensionException;

    /**
     * Metod to read data from files.
     *
     * @param filesPaths       are paths to files
     * @param removeDuplicates is true when want remove duplicates if not false
     * @return is list of requests
     * @throws UnsupportedFileExtensionException when file extension is
     *                                           unsupported
     */
    List<Request> readDataFromFiles(List<String> filesPaths,
                                    boolean removeDuplicates)
            throws UnsupportedFileExtensionException;
}

package writer;

/**
 * This interface have a set of functionalities for the WriterImpl class.
 */
public interface Writer {
    /**
     * Method to write reports to files.
     *
     * @param xmlFileName is name of xml file for report
     * @param reportClass is type of report class
     */
    void writeReportsToFile(String xmlFileName, Object reportClass);
}

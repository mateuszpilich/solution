package writer;

/**
 * The class helps write reports to xml file.
 */
public class WriterImpl implements Writer {
    /**
     * This is xml writer.
     */
    private XmlWriter xmlWriter;

    /**
     * This is constructor for xml writer.
     */
    public WriterImpl() {
        this.xmlWriter = new XmlWriter();
    }

    @Override
    public final void writeReportsToFile(final String xmlFileName,
                                         final Object reportClass) {
        xmlWriter.writeReportsToXmlFile(xmlFileName, reportClass);
    }
}

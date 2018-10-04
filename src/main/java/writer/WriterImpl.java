package writer;

/**
 * The class helps write reports to xml file.
 */
public class WriterImpl implements Writer {
    private XmlWriter xmlWriter;

    public WriterImpl() {
        this.xmlWriter = new XmlWriter();
    }

    @Override
    public void writeReportsToFile(String xmlFileName, Object reportClass) {
        xmlWriter.writeReportsToXmlFile(xmlFileName, reportClass);
    }
}

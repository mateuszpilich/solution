package writer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import service.ReportImpl;

import java.io.File;
import java.io.IOException;

/**
 * The class helps save reports to file xml.
 */
public class XmlWriter {
    /**
     * This is xmp mapper.
     */
    private XmlMapper xmlMapper;

    /**
     * This is logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    /**
     * This is constructor for xml writer.
     */
    public XmlWriter() {
        this.xmlMapper = new XmlMapper();
    }

    /**
     * Method to write reports to xml file.
     *
     * @param xmlFileName is name of xml file for report
     * @param reportClass is type of report class
     */
    public final void writeReportsToXmlFile(final String xmlFileName,
                                            final Object reportClass) {
        try {
            xmlMapper.writeValue(new File("report_" + xmlFileName + ".xml"),
                    reportClass);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

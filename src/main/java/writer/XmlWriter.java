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
    private XmlMapper xmlMapper;
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    public XmlWriter() {
        this.xmlMapper = new XmlMapper();
    }

    public void writeReportsToXmlFile(String xmlFileName, Object reportClass) {
        try {
            xmlMapper.writeValue(new File("report_" + xmlFileName + ".xml"), reportClass);
            File file = new File(xmlFileName);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

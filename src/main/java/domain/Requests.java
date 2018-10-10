package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.List;

/**
 * The class helps save list of request to xml reports.
 */
public class Requests implements Serializable {

    /**
     * This is list of reuests.
     */
    @JacksonXmlProperty(localName = "request")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Request> requestsEntities;

    /**
     * This is getter for list of requests.
     *
     * @return is list of requests
     */
    public final List<Request> getRequestsEntities() {
        return requestsEntities;
    }

    /**
     * This is setter for list of requests.
     *
     * @param rReqEntities is list of requests
     */
    public final void setRequestsEntities(final List<Request> rReqEntities) {
        this.requestsEntities = rReqEntities;
    }
}

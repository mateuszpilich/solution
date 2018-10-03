package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.List;

public class Requests implements Serializable {

    @JacksonXmlProperty(localName = "request")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Request> requestsEntities;

    public List<Request> getRequestsEntities() {
        return requestsEntities;
    }

    public void setRequestsEntities(List<Request> requestsEntities) {
        this.requestsEntities = requestsEntities;
    }
}

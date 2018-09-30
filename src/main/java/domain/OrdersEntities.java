package domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.List;

public class OrdersEntities implements Serializable {

    @JacksonXmlProperty(localName = "request")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OrderEntity> ordersEntities;

    public List<OrderEntity> getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(List<OrderEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }
}

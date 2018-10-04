package service;

import domain.Request;

import java.util.List;

public class ListOfAllRequestsToClientById {
    private Long clientId;
    private List<Request> listOfAllRequest;

    public ListOfAllRequestsToClientById(Long clientId, List<Request> listOfAllRequest) {
        this.clientId = clientId;
        this.listOfAllRequest = listOfAllRequest;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Request> getListOfAllRequest() {
        return listOfAllRequest;
    }

    public void setListOfAllRequest(List<Request> listOfAllRequest) {
        this.listOfAllRequest = listOfAllRequest;
    }
}

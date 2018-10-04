package service;

import domain.Request;

import java.util.List;

public class ListOfAllRequests {
    private List<Request> listOfAllRequests;

    public ListOfAllRequests(List<Request> listOfAllRequests) {
        this.listOfAllRequests = listOfAllRequests;
    }

    public List<Request> getListOfAllRequests() {
        return listOfAllRequests;
    }

    public void setListOfAllRequests(List<Request> listOfAllRequests) {
        this.listOfAllRequests = listOfAllRequests;
    }
}

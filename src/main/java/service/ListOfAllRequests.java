package service;

import domain.Request;

import java.util.List;

/**
 * The class helps represents reports in xml file for list of all requests.
 */
public class ListOfAllRequests {

    /**
     * This is list of all requests.
     */
    private List<Request> listOfAllRequests;

    /**
     * This is constructor for list of all requests.
     *
     * @param rListOfAllRequests is list of all requests
     */
    public ListOfAllRequests(final List<Request> rListOfAllRequests) {
        this.listOfAllRequests = rListOfAllRequests;
    }

    /**
     * This is getter for list of all requests.
     *
     * @return is list of all requests
     */
    public final List<Request> getListOfAllRequests() {
        return listOfAllRequests;
    }

    /**
     * This is setter for list of all requests.
     *
     * @param rListOfAllRequests is list of all requests
     */
    public final void setListOfAllRequests(
            final List<Request> rListOfAllRequests) {
        this.listOfAllRequests = rListOfAllRequests;
    }
}

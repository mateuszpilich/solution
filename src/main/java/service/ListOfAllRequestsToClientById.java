package service;

import domain.Request;

import java.util.List;

/**
 * The class helps represents reports in xml file for list of all requests to
 * client by id.
 */
public class ListOfAllRequestsToClientById {
    /**
     * This is list of all requests to client by id.
     */
    private Long clientId;

    /**
     * This is list of all requests.
     */
    private List<Request> listOfAllRequest;

    /**
     * This is constructor for list of all requests to client by id.
     *
     * @param rClientId         is client id
     * @param rListOfAllRequest is list of all requests to client by id
     */
    public ListOfAllRequestsToClientById(
            final Long rClientId, final List<Request> rListOfAllRequest) {
        this.clientId = rClientId;
        this.listOfAllRequest = rListOfAllRequest;
    }

    /**
     * This is getter for client id.
     *
     * @return is client id
     */
    public final Long getClientId() {
        return clientId;
    }

    /**
     * This is setter for client id.
     *
     * @param rClientId is client id
     */
    public final void setClientId(final Long rClientId) {
        this.clientId = rClientId;
    }

    /**
     * This is getter for list of all requests to client by id.
     *
     * @return is list of all requests to client by id
     */
    public final List<Request> getListOfAllRequest() {
        return listOfAllRequest;
    }

    /**
     * This is setter for list of all requests to client by id.
     *
     * @param rListOfAllRequest is list of all requests to client by id
     */
    public final void setListOfAllRequest(
            final List<Request> rListOfAllRequest) {
        this.listOfAllRequest = rListOfAllRequest;
    }
}

package service;

public class TotalRequestsNumberToClientById {
    private Long clientId;
    private Long amount;

    public TotalRequestsNumberToClientById(Long clientId, Long amount) {
        this.clientId = clientId;
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

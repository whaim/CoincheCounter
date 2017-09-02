package com.whaim.coinchecounter.model;

public enum Status {
    none(""),
    win("win"),
    loose("loose"),
    coinche("coinche"),
    contreCoinche("contreCoinche");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Status giveOppositeStatus() {
        if (status.equals(none.getStatus())) {
            return none;
        } else if (status.equals(win.getStatus())) {
            return loose;
        }
        return win;
    }
}

package com.whaim.coinchecounter.model;

import java.util.ArrayList;
import java.util.List;

public enum Contract {
    none("", 0),
    c80("80", 80),
    c90("90", 90),
    c100("100", 100),
    c110("110", 110),
    c120("120", 120),
    c130("130", 130),
    c140("140", 140),
    c150("150", 150),
    capot("capot", 162),
    generale("générale", 162);

    private String name;
    private int goal;

    Contract(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    public static List<String> getNameContracts(){
        List<String> response = new ArrayList<>();
        for (Contract contract : Contract.values()) {
            response.add(contract.name);
        }
        return response;
    }

    public static Contract getContractFromName(String name) {
        Contract response = null;
        for (Contract contract : Contract.values()) {
            if(name.equals(contract.name)) {
                response = contract;
            }
        }
        return response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}

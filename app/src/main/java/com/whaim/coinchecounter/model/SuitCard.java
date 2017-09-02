package com.whaim.coinchecounter.model;

public enum SuitCard {
    none ("none"),
    heart("heart"),
    spade("spade"),
    diamond("diamond"),
    club("club");

    private String suit;

    SuitCard(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}

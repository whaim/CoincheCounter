package com.whaim.coinchecounter.model;

import com.whaim.coinchecounter.ui.activity.ScoreActivity;

public class ScoreLineTeam {

    private int id;
    private int score;
    private int scoreSum;
    private Contract contract;
    private SuitCard suit;
    private Status status;

    public ScoreLineTeam(int score, Contract contract, SuitCard suit, Status status) {
        this.score = score;
        this.contract = contract;
        this.suit = suit;
        this.status = status;
        this.id = ScoreActivity.getLineCounter();
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Contract getContract() {
        return contract;
    }

    public int getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(int scoreSum) {
        this.scoreSum = scoreSum;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public SuitCard getSuit() {
        return suit;
    }

    public void setSuit(SuitCard suit) {
        this.suit = suit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

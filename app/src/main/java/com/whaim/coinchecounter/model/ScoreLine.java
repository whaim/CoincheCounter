package com.whaim.coinchecounter.model;

public class ScoreLine {

    private ScoreLineTeam scoreLineTeam1;
    private ScoreLineTeam scoreLineTeam2;

    public ScoreLine(ScoreLineTeam scoreLineTeam1, ScoreLineTeam scoreLineTeam2) {
        this.scoreLineTeam1 = scoreLineTeam1;
        this.scoreLineTeam2 = scoreLineTeam2;
    }

    public ScoreLineTeam getScoreLineTeam1() {
        return scoreLineTeam1;
    }

    public void setScoreLineTeam1(ScoreLineTeam scoreLineTeam1) {
        this.scoreLineTeam1 = scoreLineTeam1;
    }

    public ScoreLineTeam getScoreLineTeam2() {
        return scoreLineTeam2;
    }

    public void setScoreLineTeam2(ScoreLineTeam scoreLineTeam2) {
        this.scoreLineTeam2 = scoreLineTeam2;
    }
}

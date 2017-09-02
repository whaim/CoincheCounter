package com.whaim.coinchecounter;

import com.whaim.coinchecounter.model.ScoreLine;

import java.util.ArrayList;
import java.util.List;

public class CoincheCounterApplication {

    private static CoincheCounterApplication INSTANCE = new CoincheCounterApplication();

    private List<ScoreLine> scoreLineApp;
    private int lineCounter;

    private CoincheCounterApplication() {}

    public static CoincheCounterApplication getInstance() {
        return INSTANCE;
    }

    public List<ScoreLine> getScoreLineApp() {
        if (this.scoreLineApp == null) {
            this.scoreLineApp = new ArrayList<>();
        }
        return this.scoreLineApp;
    }

    public int getLineCounter() {
        return getScoreLineApp().size();
    }
}

package com.whaim.coinchecounter.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.whaim.coinchecounter.R;
import com.whaim.coinchecounter.model.Contract;
import com.whaim.coinchecounter.model.ScoreLine;
import com.whaim.coinchecounter.model.ScoreLineTeam;
import com.whaim.coinchecounter.model.Status;
import com.whaim.coinchecounter.model.SuitCard;
import com.whaim.coinchecounter.ui.adapter.ScoreLineAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private static List<ScoreLine> scoreLine = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scoreLine.add(new ScoreLine(new ScoreLineTeam(80, Contract.c80, SuitCard.club, Status.win), (new ScoreLineTeam(90, Contract.c100, SuitCard.heart, Status.loose))));
        scoreLine.add(new ScoreLine(new ScoreLineTeam(80, Contract.c80, SuitCard.club, Status.win), (new ScoreLineTeam(90, Contract.c100, SuitCard.heart, Status.loose))));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcTeam1);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ScoreActivity.this);

        recyclerView.setLayoutManager(mLayoutManager);


        final ScoreLineAdapter scoreLineAdapter = new ScoreLineAdapter(scoreLine, ScoreActivity.this);
        recyclerView.setAdapter(scoreLineAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewScoreLine(scoreLineAdapter);
            }
        });

        scoreLineAdapter.notifyDataSetChanged();
    }

    private void addNewScoreLine(ScoreLineAdapter scoreLineAdapter) {
        scoreLine.add(new ScoreLine(new ScoreLineTeam(0, Contract.none, SuitCard.none, Status.none), (new ScoreLineTeam(0, Contract.none, SuitCard.none, Status.none))));
        scoreLineAdapter.notifyItemInserted(scoreLine.size() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int getLineCounter() {
        return scoreLine.size();
    }


}

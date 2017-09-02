package com.whaim.coinchecounter.ui.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whaim.coinchecounter.R;
import com.whaim.coinchecounter.model.ScoreLine;
import com.whaim.coinchecounter.model.SuitCard;
import com.whaim.coinchecounter.ui.activity.ScoreActivity;
import com.whaim.coinchecounter.ui.dialog.EditDialog;
import com.whaim.coinchecounter.ui.listener.OnEditClickListener;

import java.util.List;

public class ScoreLineAdapter extends RecyclerView.Adapter<ScoreLineAdapter.ScoreLineHolder>{

    private List<ScoreLine> scoreLineList;
    private Context context;

    public ScoreLineAdapter(List<ScoreLine> scoreLineList, Context context){
        super();
        this.context = context;
        setHasStableIds(true);
        this.scoreLineList = scoreLineList;
    }

    @Override
    public ScoreLineAdapter.ScoreLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_line, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ScoreLineHolder(view);
    }

    @Override
    public void onBindViewHolder(ScoreLineAdapter.ScoreLineHolder holder, int position) {
        ScoreLine scoreLine = scoreLineList.get(position);
        holder.scoreSumTeam1.setText(String.valueOf(scoreLine.getScoreLineTeam1().getScoreSum()));
        holder.contractTeam1.setText(scoreLine.getScoreLineTeam1().getContract().getName());

        switch (scoreLine.getScoreLineTeam1().getSuit()) {
            case club:
                holder.suitCardTeam1.setImageResource(R.drawable.club);
                break;
            case diamond:
                holder.suitCardTeam1.setImageResource(R.drawable.diamond);
                break;
            case heart:
                holder.suitCardTeam1.setImageResource(R.drawable.heart);
                break;
            case spade:
                holder.suitCardTeam1.setImageResource(R.drawable.spade);
                break;
        }

        switch (scoreLine.getScoreLineTeam1().getStatus()) {
            case win:
                holder.statusTeam1.setImageResource(R.drawable.suit_card);
                break;
            case loose:
                holder.statusTeam1.setImageResource(R.drawable.suit_card);
                break;
            case coinche:
                holder.statusTeam1.setImageResource(R.drawable.suit_card);
                break;
            case contreCoinche:
                holder.statusTeam1.setImageResource(R.drawable.suit_card);
                break;
        }

        holder.scoreSumTeam2.setText(String.valueOf(scoreLine.getScoreLineTeam2().getScoreSum()));
        holder.contractTeam2.setText(scoreLine.getScoreLineTeam2().getContract().getName());

        switch (scoreLine.getScoreLineTeam2().getSuit()) {
            case club:
                holder.suitCardTeam2.setImageResource(R.drawable.club);
                break;
            case diamond:
                holder.suitCardTeam2.setImageResource(R.drawable.diamond);
                break;
            case heart:
                holder.suitCardTeam2.setImageResource(R.drawable.heart);
                break;
            case spade:
                holder.suitCardTeam2.setImageResource(R.drawable.spade);
                break;
        }

        switch (scoreLine.getScoreLineTeam2().getStatus()) {
            case win:
                holder.statusTeam2.setImageResource(R.drawable.suit_card);
                break;
            case loose:
                holder.statusTeam2.setImageResource(R.drawable.suit_card);
                break;
            case coinche:
                holder.statusTeam2.setImageResource(R.drawable.suit_card);
                break;
            case contreCoinche:
                holder.statusTeam2.setImageResource(R.drawable.suit_card);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ScoreActivity.getLineCounter();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ScoreLineHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView scoreSumTeam1;
        private TextView contractTeam1;
        private ImageView suitCardTeam1;
        private ImageView statusTeam1;

        private TextView scoreSumTeam2;
        private TextView contractTeam2;
        private ImageView suitCardTeam2;
        private ImageView statusTeam2;

        public ScoreLineHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            scoreSumTeam1 = (TextView) v.findViewById(R.id.scoreSumTeam1);
            contractTeam1 = (TextView) v.findViewById(R.id.contractTeam1);
            suitCardTeam1 = (ImageView) v.findViewById(R.id.suitCardTeam1);
            statusTeam1 = (ImageView) v.findViewById(R.id.statusTeam1);
            scoreSumTeam2 = (TextView) v.findViewById(R.id.scoreSumTeam2);
            contractTeam2 = (TextView) v.findViewById(R.id.contractTeam2);
            suitCardTeam2 = (ImageView) v.findViewById(R.id.suitCardTeam2);
            statusTeam2 = (ImageView) v.findViewById(R.id.statusTeam2);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
            EditDialog editDialog = EditDialog.newInstance(context, new OnEditClickListener() {
                @Override
                public void onEditClick(ScoreLine scoreLine) {
                    switch (scoreLine) {
                        case club:
                            suitCardTeam1.setImageResource(R.drawable.club);
                            break;
                        case diamond:
                            suitCardTeam1.setImageResource(R.drawable.diamond);
                            break;
                        case heart:
                            suitCardTeam1.setImageResource(R.drawable.heart);
                            break;
                        case spade:
                            suitCardTeam1.setImageResource(R.drawable.spade);
                            break;
                    }
                    scoreLineList.get(getAdapterPosition()).getScoreLineTeam1().setSuit(scoreLine);
                }
            });
            editDialog.show(fm.beginTransaction(), "EditDialog");
        }
    }
}

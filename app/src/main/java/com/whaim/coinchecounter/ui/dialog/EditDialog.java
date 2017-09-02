package com.whaim.coinchecounter.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.whaim.coinchecounter.R;
import com.whaim.coinchecounter.model.Contract;
import com.whaim.coinchecounter.model.ScoreLine;
import com.whaim.coinchecounter.model.ScoreLineTeam;
import com.whaim.coinchecounter.model.Status;
import com.whaim.coinchecounter.model.SuitCard;
import com.whaim.coinchecounter.ui.listener.OnEditClickListener;

public class EditDialog extends DialogFragment {

    private ImageButton rBSpade;
    private ImageButton rBClub;
    private ImageButton rBDiamond;
    private ImageButton rBHeart;
    private SuitCard suitCard;

    private RadioGroup radioGroupTeam, radio_group_status;
    private RadioButton radioButtonTeam, radio_button_status;

    private Spinner spinner;
    private Contract contract;

    private EditText result;

    private Button cancelButton;
    private Button okButton;

    private OnEditClickListener listener;
    private Context context;

    public static EditDialog newInstance(Context context, OnEditClickListener listener) {
        EditDialog frag = new EditDialog();
        frag.listener = listener;
        frag.context = context;
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Edit selected row");
        builder.setView(getContentView());
        Dialog dialog = builder.create();
        return dialog;
    }

    private View getContentView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.edit_dialog, null, false);

        radioGroupTeam = (RadioGroup) v.findViewById(R.id.radioGroupTeam);

        spinner = (Spinner) v.findViewById(R.id.spinner);

        radio_group_status = (RadioGroup) v.findViewById(R.id.radio_group_status);

        result = (EditText) v.findViewById(R.id.result);

        rBSpade = (ImageButton) v.findViewById(R.id.imageButtonSpade);
        rBClub = (ImageButton) v.findViewById(R.id.imageButtonClub);
        rBDiamond = (ImageButton) v.findViewById(R.id.imageButtonDiamond);
        rBHeart = (ImageButton) v.findViewById(R.id.imageButtonHeart);

        cancelButton = (Button) v.findViewById(R.id.cancel_button);
        okButton = (Button) v.findViewById(R.id.ok_button);

        initView();

        return v;
    }


    private void initView () {

        int selectedIdTeam = radioGroupTeam.getCheckedRadioButtonId();
        radioButtonTeam = (RadioButton) radioGroupTeam.findViewById(selectedIdTeam);

        int selectedIdStatus = radio_group_status.getCheckedRadioButtonId();
        radio_button_status = (RadioButton) radio_group_status.findViewById(selectedIdStatus);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, Contract.getNameContracts());
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                contract = Contract.getContractFromName(Contract.getNameContracts().get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rBHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rBHeart.setBackgroundResource(R.color.greyIron);
                rBSpade.setBackgroundResource(R.color.white);
                rBDiamond.setBackgroundResource(R.color.white);
                rBClub.setBackgroundResource(R.color.white);
                suitCard = SuitCard.heart;
            }
        });
        rBSpade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rBHeart.setBackgroundResource(R.color.white);
                rBSpade.setBackgroundResource(R.color.greyIron);
                rBDiamond.setBackgroundResource(R.color.white);
                rBClub.setBackgroundResource(R.color.white);
                suitCard = SuitCard.spade;
            }
        });
        rBDiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rBHeart.setBackgroundResource(R.color.white);
                rBSpade.setBackgroundResource(R.color.white);
                rBDiamond.setBackgroundResource(R.color.greyIron);
                rBClub.setBackgroundResource(R.color.white);
                suitCard = SuitCard.diamond;
            }
        });
        rBClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rBHeart.setBackgroundResource(R.color.white);
                rBSpade.setBackgroundResource(R.color.white);
                rBDiamond.setBackgroundResource(R.color.white);
                rBClub.setBackgroundResource(R.color.greyIron);
                suitCard = SuitCard.club;
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultGame = result.getText().toString() == "" ? 0 : Integer.valueOf(result.getText().toString());
                Status status = giveStatus(radio_button_status.getId());

                ScoreLineTeam team1 = new ScoreLineTeam(resultGame, contract, suitCard, status);
                ScoreLineTeam team2 = new ScoreLineTeam(0, Contract.none, SuitCard.none, status.giveOppositeStatus());

                ScoreLine scoreLine = null;
                if (radioButtonTeam.getId() == R.id.radioButtonTeam1) {
                    scoreLine = new ScoreLine(team1, team2);
                } else {
                    scoreLine = new ScoreLine(team2, team1);
                }
                listener.onEditClick(scoreLine);
                dismiss();
            }
        });
    }

    private Status giveStatus(int id) {
        switch (id) {
            case R.id.radio_button_win:
                return Status.win;
            case R.id.radio_button_loose:
                return Status.loose;
            default:
                return Status.none;
        }
    }

}

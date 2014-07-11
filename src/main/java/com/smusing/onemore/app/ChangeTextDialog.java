package com.smusing.onemore.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


public class ChangeTextDialog extends DialogFragment {

    static ChangeTextDialog newInstance(int num){
        ChangeTextDialog f=new ChangeTextDialog();

        Bundle args=new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){


        final int mNum=getArguments().getInt("num");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v=inflater.inflate(R.layout.change_thing_dialog, null);

        builder.setView(v)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText) v.findViewById(R.id.subject);
                        String subject = et.getText().toString();
                        Intent i=new Intent(getActivity(), TextChanger.class);
                        Bundle bundle = new Bundle();

                        //bundle.putString("subject", subject);



                        switch (mNum) {
                            case 1:


                                break;

                            case 2:
                                int n2=1;
                                bundle.putInt("n", n2);
                                i.putExtras(bundle);
                                startActivity(i);

                                ((TextChanger)getActivity()).doPositiveClick();

                                break;
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        return builder.create();
    }
}

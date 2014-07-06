package com.smusing.onemore.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();



        builder.setView(inflater.inflate(R.layout.change_thing_dialog, null))
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText)getView().findViewById(R.id.subject);
                        String subject=et.getText().toString();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup contianer, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.change_thing_dialog, contianer, false);

        EditText et=(EditText)view.findViewById(R.id.subject);


        return view;
    }
}

package com.smusing.onemore.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class OneMoreDialogue extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage("Are you sure?")
                .setPositiveButton("Ok", null)
                .setNegativeButton("No way", null).create();
    }
}


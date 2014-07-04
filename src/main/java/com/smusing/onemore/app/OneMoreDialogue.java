package com.smusing.onemore.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class OneMoreDialogue extends DialogFragment {

    public final String DEBUG_TAG="ChapterFragment";
    public final String DEBUG_PAGE="PageFragment";

    static OneMoreDialogue newInstance(int num){
        OneMoreDialogue f=new OneMoreDialogue();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final int mNum=getArguments().getInt("num");


        return new AlertDialog.Builder(getActivity())
                .setMessage("Are you sure you want to reset the count?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(DEBUG_TAG, "which is: "+which);
                        Log.d(DEBUG_PAGE, "which is: "+which);
                        switch (mNum){
                            case 1:
                                ((ChapterFragment)getParentFragment()).doPositiveClick();
                                break;

                            case 2:
                                ((PageFragment)getParentFragment()).doPositiveClick();
                                break;

                        }
                    }
                })
                .setNegativeButton("No way!", null).create();
    }
}

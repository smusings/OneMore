package com.smusing.onemore.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by etyulmenkov on 7/10/14.
 */
public class TextChanger extends FragmentActivity {

    public void doPositiveClick(){
        Bundle b=getIntent().getExtras();
        int n=b.getInt("n");
    }
}

package com.smusing.onemore.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class About extends Activity {

    //setup
    String about;
    TextView aboutv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        //sets the text
        aboutv = (TextView) findViewById(R.id.abouttv);
        about = ("OneMore is an android mobile application developed by smusings." +
                "\nIf you have any questions or recomendations feel to email smusings at: " +
                "\n sleeplessmusings@gmail.com");

        aboutv.setText(about);
    }
}

package com.smusing.onemore.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends SetupActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns values to al fragments
        f1=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        f2=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        f3=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment3);
        f4=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment4);
        f5=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment5);
        f6=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment6);

        //set background color for each fragment
        f1.getView().setBackgroundColor(getResources().getColor(R.color.CadetBlue));
        f2.getView().setBackgroundColor(getResources().getColor(R.color.SeaGreen));
        f3.getView().setBackgroundColor(getResources().getColor(R.color.ModerateBlue));
        f4.getView().setBackgroundColor(getResources().getColor(R.color.ForestGreen));
        f5.getView().setBackgroundColor(getResources().getColor(R.color.SteelBlue));
        f6.getView().setBackgroundColor(getResources().getColor(R.color.Green));


        //assigns clicklistener to all fragments so they know how to react.
        f1.getView().setOnClickListener(myOneClickListener);
        f2.getView().setOnClickListener(myTwoClickListener);
        f3.getView().setOnClickListener(myThreeClickListener);
        f4.getView().setOnClickListener(myFourClickListener);
        f5.getView().setOnClickListener(myFiveClickListener);
        f6.getView().setOnClickListener(mySixClickListener);
    }

    //sets up menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //sets up the menu options.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reset) {
            return true;
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
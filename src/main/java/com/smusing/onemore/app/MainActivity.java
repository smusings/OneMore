package com.smusing.onemore.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends SetupActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identify the layouts
        l1=(LinearLayout)findViewById(R.id.ll1);
        l2=(LinearLayout)findViewById(R.id.ll2);

        //assigns values to all fragments
        f1=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        f2=(FragmentTwo)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        f3=(FragmentThree)getSupportFragmentManager().findFragmentById(R.id.fragment3);
        f4=(FragmentFour)getSupportFragmentManager().findFragmentById(R.id.fragment4);
        f5=(FragmentFive)getSupportFragmentManager().findFragmentById(R.id.fragment5);
        f6=(FragmentSix)getSupportFragmentManager().findFragmentById(R.id.fragment6);

        //set background color for each fragment
        f1.getView().setBackgroundColor(getResources().getColor(R.color.CadetBlue));
        f2.getView().setBackgroundColor(getResources().getColor(R.color.SeaGreen));
        f3.getView().setBackgroundColor(getResources().getColor(R.color.ModerateBlue));
        f4.getView().setBackgroundColor(getResources().getColor(R.color.ForestGreen));
        f5.getView().setBackgroundColor(getResources().getColor(R.color.SteelBlue));
        f6.getView().setBackgroundColor(getResources().getColor(R.color.Green));


        //assigns longclicklistener to all fragments so they know how to react.
        //the particular listeners are all from the SetupActivity which we extend
        f1.getView().setOnLongClickListener(myOneClickListener);
        f2.getView().setOnLongClickListener(myTwoClickListener);
        f3.getView().setOnLongClickListener(myThreeClickListener);
        f4.getView().setOnLongClickListener(myFourClickListener);
        f5.getView().setOnLongClickListener(myFiveClickListener);
        f6.getView().setOnLongClickListener(mySixClickListener);

        //sets a clicklistener to all fragments to add one to the count
        //without inflating the whole fragment
        f1.getView().setOnClickListener(onClickAdd1);
        f2.getView().setOnClickListener(onClickAdd2);
        f3.getView().setOnClickListener(onClickAdd3);
        f4.getView().setOnClickListener(onClickAdd4);
        f5.getView().setOnClickListener(onClickAdd5);
        f6.getView().setOnClickListener(onClickAdd6);
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
            //access a method in the fragment that resets the count to 0
            f1.resetCount();
            f2.resetCount();
            f3.resetCount();
            f4.resetCount();
            f5.resetCount();
            f6.resetCount();
            return true;
        }
        if (id == R.id.action_about) {
            //opens up a new activity that will take us to the about page
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
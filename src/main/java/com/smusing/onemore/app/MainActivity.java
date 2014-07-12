package com.smusing.onemore.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity{

    FragmentManager fm=getSupportFragmentManager();
    FragmentOne f1;
    FragmentTwo f2;
    FragmentThree f3;
    FragmentFour f4;
    FragmentFive f5;
    FragmentSix f6;

    private boolean singleViewExpand=false;

    private View.OnClickListener myOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                hideAllViews();
                fm.beginTransaction()
                        .show()
                        .commit();
                v.setVisibility(View.VISIBLE);
                singleViewExpand=true;
            }
        }
    };

    private void showAllViews(){
        fm.beginTransaction()
                .show(f1)
                .show(f2)
                .show(f3)
                .show(f4)
                .show(f5)
                .show(f6)
                .commit();
    }

    private void hideAllViews(){
        fm.beginTransaction()
                .hide(f1)
                .hide(f2)
                .hide(f3)
                .hide(f4)
                .hide(f5)
                .hide(f6)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        f2=(FragmentTwo)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        f3=(FragmentThree)getSupportFragmentManager().findFragmentById(R.id.fragment3);
        f4=(FragmentFour)getSupportFragmentManager().findFragmentById(R.id.fragment4);
        f5=(FragmentFive)getSupportFragmentManager().findFragmentById(R.id.fragment5);
        f6=(FragmentSix)getSupportFragmentManager().findFragmentById(R.id.fragment6);

        f1.getView().setOnClickListener(myOnClickListener);
        f2.getView().setOnClickListener(myOnClickListener);
        f3.getView().setOnClickListener(myOnClickListener);
        f4.getView().setOnClickListener(myOnClickListener);
        f5.getView().setOnClickListener(myOnClickListener);
        f6.getView().setOnClickListener(myOnClickListener);
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
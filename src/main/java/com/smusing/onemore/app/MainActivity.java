package com.smusing.onemore.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity{

    //setup for activity
    FragmentManager fm=getSupportFragmentManager();
    FragmentOne f1;
    FragmentOne f2;
    FragmentOne f3;
    FragmentOne f4;
    FragmentOne f5;
    FragmentOne f6;

    private boolean singleViewExpand=false;

    //onclick listener to hide and show fragments.
    private View.OnClickListener myOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer fragment=(Integer) v.getTag();
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hideAllViews();
                fm.beginTransaction()
                        //.show(frag)
                        .commit();
                v.setVisibility(View.VISIBLE);
                singleViewExpand=true;
            }
        }
    };

    //defines a method to hide all views
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

    //defines a method to hide all views
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


        f1.getView().setTag(1);

        //assigns clicklistener to all fragments so they know how to react.
        f1.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer fragment=(Integer) v.getTag();

                if(singleViewExpand){
                    showAllViews();
                    singleViewExpand=false;
                }else{
                    hideAllViews();
                    fm.beginTransaction()
                            .show(f1)
                            .commit();
                    v.setVisibility(View.VISIBLE);
                    singleViewExpand=true;
                }
            }
        });
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
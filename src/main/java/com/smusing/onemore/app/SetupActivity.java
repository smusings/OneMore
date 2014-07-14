package com.smusing.onemore.app;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * Created by etyulmenkov on 7/14/14.
 */
public class SetupActivity extends FragmentActivity{
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
    public View.OnClickListener myOneClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .show(f1)
                        .hide(f2)
                        .hide(f3)
                        .hide(f4)
                        .hide(f5)
                        .hide(f6)
                        .commit();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myTwoClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .hide(f1)
                        .show(f2)
                        .hide(f3)
                        .hide(f4)
                        .hide(f5)
                        .hide(f6)
                        .commit();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myThreeClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .hide(f1)
                        .hide(f2)
                        .show(f3)
                        .hide(f4)
                        .hide(f5)
                        .hide(f6)
                        .commit();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myFourClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .hide(f1)
                        .hide(f2)
                        .hide(f3)
                        .show(f4)
                        .hide(f5)
                        .hide(f6)
                        .commit();
                singleViewExpand=true;
            }
        }
    };
    public View.OnClickListener myFiveClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .hide(f1)
                        .hide(f2)
                        .hide(f3)
                        .hide(f4)
                        .show(f5)
                        .hide(f6)
                        .commit();
                singleViewExpand=true;
            }
        }
    };
    public View.OnClickListener mySixClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                singleViewExpand=false;
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                fm.beginTransaction()
                        .hide(f1)
                        .hide(f2)
                        .hide(f3)
                        .hide(f4)
                        .hide(f5)
                        .show(f6)
                        .commit();
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
}

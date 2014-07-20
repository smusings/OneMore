package com.smusing.onemore.app;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

public class SetupActivity extends FragmentActivity{
    //setup for activity
    FragmentManager fm=getSupportFragmentManager();
    FragmentOne f1;
    FragmentOne f2;
    FragmentOne f3;
    FragmentOne f4;
    FragmentOne f5;
    FragmentOne f6;
    LinearLayout l1;
    LinearLayout l2;

    private boolean singleViewExpand=false;

    //onclick listener to hide and show fragments.
    public View.OnClickListener myOneClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f1=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f1.hideButtons();
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
                l2.setVisibility(View.GONE);
                f1.showButtons();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myTwoClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f2=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment2);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f2.hideButtons();
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
                l1.setVisibility(View.GONE);
                f2.showButtons();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myThreeClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f3=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment3);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f3.hideButtons();
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
                l2.setVisibility(View.GONE);
                f3.showButtons();
                singleViewExpand=true;
            }
        }
    };

    public View.OnClickListener myFourClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f4=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment4);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f4.hideButtons();
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
                l1.setVisibility(View.GONE);
                f4.showButtons();
                singleViewExpand=true;
            }
        }
    };
    public View.OnClickListener myFiveClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f5=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment5);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f5.hideButtons();
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
                l2.setVisibility(View.GONE);
                f5.showButtons();
                singleViewExpand=true;
            }
        }
    };
    public View.OnClickListener mySixClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            f6=(FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment6);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f6.hideButtons();
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
                l1.setVisibility(View.GONE);
                f6.showButtons();
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
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
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

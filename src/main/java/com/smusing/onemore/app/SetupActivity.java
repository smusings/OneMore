package com.smusing.onemore.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

public class SetupActivity extends FragmentActivity{

    //setup for activity
    FragmentManager fm = getSupportFragmentManager();
    public FragmentOne f1;
    public FragmentTwo f2;
    public FragmentThree f3;
    public FragmentFour f4;
    public FragmentFive f5;
    public FragmentSix f6;
    public LinearLayout l1;
    public LinearLayout l2;

    //boolean to set up views hidden or not
    private boolean singleViewExpand = false;

    public void hide(Fragment fragment){
        fm.beginTransaction()
                .hide(f1)
                .hide(f2)
                .hide(f3)
                .hide(f4)
                .hide(f5)
                .hide(f6)
                .show(fragment)
                .commit();
        singleViewExpand = true;
    }

    //onlongclick listener to hide and show fragments.
    public View.OnLongClickListener myOneClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f1 = (FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f1.hideButtons();
                singleViewExpand = false;
            } else {
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
               hide(f1);
                l2.setVisibility(View.GONE);
                f1.showButtons();
            }
            return true;
        }
    };

    public View.OnLongClickListener myTwoClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f2 = (FragmentTwo)getSupportFragmentManager().findFragmentById(R.id.fragment2);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f2.hideButtons();
            }else{
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hide(f2);
                l1.setVisibility(View.GONE);
                f2.showButtons();
            }
            return true;
        }
    };

    public View.OnLongClickListener myThreeClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f3 = (FragmentThree)getSupportFragmentManager().findFragmentById(R.id.fragment3);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f3.hideButtons();
                singleViewExpand = false;
            } else {
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hide(f3);
                l2.setVisibility(View.GONE);
                f3.showButtons();
            }
            return true;
        }
    };

    public View.OnLongClickListener myFourClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f4 = (FragmentFour)getSupportFragmentManager().findFragmentById(R.id.fragment4);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f4.hideButtons();
                singleViewExpand = false;
            } else {
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hide(f4);
                l1.setVisibility(View.GONE);
                f4.showButtons();
            }
            return true;
        }
    };
    public View.OnLongClickListener myFiveClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f5 = (FragmentFive)getSupportFragmentManager().findFragmentById(R.id.fragment5);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f5.hideButtons();
                singleViewExpand = false;
            } else {
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hide(f5);
                l2.setVisibility(View.GONE);
                f5.showButtons();
            }
            return true;
        }
    };
    public View.OnLongClickListener mySixClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            f6 = (FragmentSix)getSupportFragmentManager().findFragmentById(R.id.fragment6);
            // if a view is fullscreen, on click shows all views instead
            if(singleViewExpand){
                showAllViews();
                f6.hideButtons();
                singleViewExpand = false;
            } else {
                //if a view is not fullscreen, hides all views then expands the one you clicked on.
                hide(f6);
                l1.setVisibility(View.GONE);
                f6.showButtons();
            }
            return true;
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

    //onclicklisteners to add one one
    public View.OnClickListener onClickAdd1 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            f1.addOne();
        }
    };

    public View.OnClickListener onClickAdd2 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            f2.addOne();
        }
    };

    public View.OnClickListener onClickAdd3 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            f3.addOne();
        }
    };

    public View.OnClickListener onClickAdd4 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            f4.addOne();
        }
    };

    public View.OnClickListener onClickAdd5 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            f5.addOne();
        }
    };

    public View.OnClickListener onClickAdd6 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            f6.addOne();
        }
    };

}

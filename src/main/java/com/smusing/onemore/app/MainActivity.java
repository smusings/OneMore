package com.smusing.onemore.app;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;


public class MainActivity extends FragmentActivity
implements ChapterFragment.OmChapterListener{

    FragmentTransaction ft=getFragmentManager().beginTransaction();

    @Override
    public void omchapter(Number n) {

        //going to use bundles to send data to fragment and work on the edittext there, should work?!

        int nz=Integer.valueOf(n.intValue());
        if (nz == 1){

        } else if (nz == -1) {

        }
    }


    //identify the elemts we are using
    private ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
            aa.clear();
            return true;
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }


}
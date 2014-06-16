package com.smusing.onemore.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity
        implements OneMoreChapter.OmChapterListener{

    TextView episodetv;
    TextView gametv;
    TextView leveltv;
    TextView chaptertv;

    LinearLayout episode;
    LinearLayout game;
    LinearLayout level;


    final Number initial=0;

    FragmentTransaction ft=getFragmentManager().beginTransaction();
    OneMoreChapter omc=(OneMoreChapter)getSupportFragmentManager().
            findFragmentById(R.id.chapter_count);


    public void omchapter(Number n){
        chaptertv=(TextView)findViewById(R.id.chapter_count);
        String c_count=chaptertv.getText().toString();
        int nz=Integer.valueOf(n.intValue());

        if (nz == 1){
            int countz=Integer.valueOf(c_count);
            int nu_count=countz+nz;
            String text=Integer.toString(nu_count);
            chaptertv.setText(text);
            omc.doSomething(text);

        } else if (nz == -1){
            int countz=Integer.valueOf(c_count);
            int nu_count=countz+nz;
            String st=Integer.toString(nu_count);
            chaptertv.setText(st);
            //omc.changText(st);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Fragment newfragment=new Fragment();
        ft.replace(R.id.fragment_count, newfragment);
        ft.addToBackStack(null);

        //define our Layouts so you can click on the layout as a whole.
        episode=(LinearLayout) findViewById(R.id.episode);
        game=(LinearLayout) findViewById(R.id.game);
        level=(LinearLayout) findViewById(R.id.level);

        chaptertv=(TextView)findViewById(R.id.chapter_count);

        //define our TextViews
        episodetv=(TextView) findViewById(R.id.episodeCount);
        gametv=(TextView) findViewById(R.id.gameCount);
        leveltv=(TextView) findViewById(R.id.levelCount);
        chaptertv=(TextView)findViewById(R.id.chapter_count);

        //Set the numbers to 0 so we can do maths
        episodetv.setText(initial.toString());
        gametv.setText(initial.toString());
        leveltv.setText(initial.toString());
        chaptertv.setText(initial.toString());
        //omc.changeText(initial.toString());
        //when a layout is clicked we add +1 to the textview associated with it.
        episode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String skr = episodetv.getText().toString();
                int sk = Integer.valueOf(skr);
                int count = sk + 1;
                episodetv.setText(Integer.toString(count));
            }
        });

        game.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String skr=gametv.getText().toString();
                int sk=Integer.valueOf(skr);
                int count=sk+1;
                gametv.setText(Integer.toString(count));
            }
        });

        level.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String skr=leveltv.getText().toString();
                int sk=Integer.valueOf(skr);
                int count=sk+1;
                leveltv.setText(Integer.toString(count));
            }
        });

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
            episodetv.setText(initial.toString());
            gametv.setText(initial.toString());
            leveltv.setText(initial.toString());
            chaptertv.setText(initial.toString());
            omc.doSomething(initial.toString());
            return true;
        }
        if (id==R.id.action_about){
            Intent intent=new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
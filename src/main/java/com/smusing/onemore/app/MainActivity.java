package com.smusing.onemore.app;

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
    LinearLayout chapter;

    final Number initial=0;

    public void omchapter(Number n){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define our Layouts so you can click on the layout as a whole.
        episode=(LinearLayout) findViewById(R.id.episode);
        game=(LinearLayout) findViewById(R.id.game);
        level=(LinearLayout) findViewById(R.id.level);
        chapter=(LinearLayout) findViewById(R.id.chapters);

        //define our TextViews
        episodetv=(TextView) findViewById(R.id.episodeCount);
        gametv=(TextView) findViewById(R.id.gameCount);
        leveltv=(TextView) findViewById(R.id.levelCount);

        //Set the numbers to 0 so we can do maths
        episodetv.setText(initial.toString());
        gametv.setText(initial.toString());
        leveltv.setText(initial.toString());
        chaptertv.setText(initial.toString());

        //when a layout is clicked we add +1 to the textview associated with it.
        episode.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String skr=episodetv.getText().toString();
                int sk=Integer.valueOf(skr);
                int count=sk+1;
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
            return true;
        }
        if (id==R.id.action_about){
            Intent intent=new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

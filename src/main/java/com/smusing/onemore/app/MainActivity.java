package com.smusing.onemore.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView episodetv;
    TextView gametv;
    TextView leveltv;
    TextView chaptertv;

    LinearLayout episode;
    LinearLayout game;
    LinearLayout level;
    LinearLayout chapter;

    final Number initial=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        episode=(LinearLayout) findViewById(R.id.episode);
        game=(LinearLayout) findViewById(R.id.game);
        level=(LinearLayout) findViewById(R.id.level);
        chapter=(LinearLayout) findViewById(R.id.chapters);

        episodetv=(TextView) findViewById(R.id.episodeCount);
        gametv=(TextView) findViewById(R.id.gameCount);
        leveltv=(TextView) findViewById(R.id.levelCount);
        chaptertv=(TextView) findViewById(R.id.chapterCount);

        episodetv.setText(initial.toString());
        gametv.setText(initial.toString());
        leveltv.setText(initial.toString());
        chaptertv.setText(initial.toString());

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

        chapter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String skr=chaptertv.getText().toString();
                int sk=Integer.valueOf(skr);
                int count=sk+1;
                chaptertv.setText(Integer.toString(count));
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

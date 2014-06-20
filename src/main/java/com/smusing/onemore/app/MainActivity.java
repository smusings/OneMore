package com.smusing.onemore.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    //identify the elemts we are using
    private ArrayAdapter aa;
    private ArrayList<String> list =new ArrayList<String>();
    private ListView lv;
    private EditText et;
    private Button eom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.OneMoreList);
        et=(EditText)findViewById(R.id.edit_om);
        eom=(Button)findViewById(R.id.add_button);


        eom.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String s=et.getText().toString();
                String skree="One More "+s;
                aa.add(skree);
                aa.notifyDataSetChanged();
            }
        });

        class MySimpleArrayAdapter extends ArrayAdapter<String> {
            private final Context context;

            public MySimpleArrayAdapter(Context context, ArrayList<String> list) {
                super(context, R.layout.one_more_list, list);
                this.context = context;
            }

            private int[] colors=new int[]{R.color.Goldenrod, R.color.Crimson, R.color.ForestGreen};


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) context.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.one_more_list, parent, false);

                TextView tvtext = (TextView) view.findViewById(R.id.layout_text);
                TextView tvcount = (TextView) view.findViewById(R.id.layout_count);

                int colorPos=position % colors.length;
                view.setBackgroundResource(colors[colorPos]);

                final String[] listarray=new String[list.size()];
                list.toArray(listarray);
                tvtext.setText(listarray[position]);
                Number n=0;
                String ns=n.toString();
                tvcount.setText(ns);
                return view;
            }
        }



        aa = new MySimpleArrayAdapter(MainActivity.this, list);



        lv.setAdapter(aa);

    }


/*
    private void addOneMore(View view){
        String s=et.getText().toString();
        String onemore=("One MOre "+s);
        aa.add(onemore);
        aa.notifyDataSetChanged();
    }
    */



    @Override
    protected void onResume(){
        super.onResume();
        et.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
            }
        }, 100);
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
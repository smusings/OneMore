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
    private ArrayList<String> list;
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
        list=new ArrayList<String>();

       eom.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String s=et.getText().toString();
                list.add("One More "+s);
                aa.notifyDataSetChanged();
            }
        });


        final String[] listArray=new String[list.size()];
        list.toArray(listArray);




        class MySimpleArrayAdapter extends ArrayAdapter<String> {
            private final Context context;

            public MySimpleArrayAdapter(Context context, String[] values) {
                super(context, R.layout.one_more_list, values);
                this.context = context;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) context.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.one_more_list, parent, false);
                TextView tvtext = (TextView) view.findViewById(R.id.layout_text);
                TextView tvcount = (TextView) view.findViewById(R.id.layout_count);
                tvtext.setText(listArray[position]);
                tvcount.setText(0);
                return view;
            }
        }

        aa = new MySimpleArrayAdapter(this, listArray);

        lv.setAdapter(aa);

/*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj=listArray[position];
                int x=Integer.getInteger(obj.toString());


            }
        });
*/
    }
    /*

    private void addOneMore(View view){
        String s=et.getText().toString();
        list.add("One More "+s);
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
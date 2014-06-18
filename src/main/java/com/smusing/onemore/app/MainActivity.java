package com.smusing.onemore.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayAdapter aa;
    private ArrayList<String> list;
    private ListView lv;
    private Button ba;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = (ListView) findViewById(R.id.OneMoreList);
        ba=(Button)findViewById(R.id.add_button);
        et=(EditText)findViewById(R.id.edit_om);

        list=new ArrayList<String>();
        final String[] listArray=new String[list.size()];
        list.toArray(listArray);

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);


        lv.setAdapter(aa);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj=listArray[position];
                int x=Integer.getInteger(obj.toString());


            }
        });

        Context context;

        InputMethodManager inputManager =
                (InputMethodManager) context.
                        getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
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

    public void addOneMore(View view){
        et=(EditText)findViewById(R.id.edit_om);
        String s=et.getText().toString();
        String message=("One More "+s);
        aa.add(message);
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
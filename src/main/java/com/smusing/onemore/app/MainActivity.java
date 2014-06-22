package com.smusing.onemore.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
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
    private ArrayList<Number> amount=new ArrayList<Number>();
    private ListView lv;
    private EditText et;
    private Button eom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to the elements we are using
        lv = (ListView) findViewById(R.id.OneMoreList);
        et=(EditText)findViewById(R.id.edit_om);
        eom=(Button)findViewById(R.id.add_button);



        //onclick listener for the button to create a new OneMore
        eom.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String s = et.getText().toString();
                String skree = "One More " + s;
                Number n = 0;

                aa.add(skree);
                //notification of the data being sent, wipes the text, and closes the keyboard.
                aa.notifyDataSetChanged();
                et.setText("");
                hideSoftKeyboard();
            }
        });


        //defines the adapter we are using and sets it.
        aa = new OneMoreArrayAdapter(MainActivity.this, list);
        lv.setAdapter(aa);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView tv2=(TextView)view.findViewById(R.id.layout_count);
                String value=tv2.getText().toString();
                int n=Integer.valueOf(value);
                int nz=n+1;
                String skr=Integer.toString(nz);
                tv2.setText(skr);
            }
        });

        //onSwipe Gesture i need
        final GestureDetector gesture=new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        float sensitvity = 50;
                        //right to left
                        if ((e1.getX() - e2.getX()) > sensitvity) {
                            //something else
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                           //delete button
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }

                });
    }

    //in place to make sure data isn't cleared on orientation change
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

    //command to close keyboard
    private void hideSoftKeyboard(){
        if(getCurrentFocus()!=null && getCurrentFocus() instanceof EditText){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
        }
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
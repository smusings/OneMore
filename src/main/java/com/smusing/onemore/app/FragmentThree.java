package com.smusing.onemore.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FragmentThree extends Fragment {

    public static final String PREF_COUNT3="MyPrefsCount3";

    //everything we need
    EditText frag_text;
    TextView frag_count;
    Button add1;
    Button sub1;
    Button reset;
    LinearLayout buttonl;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        frag_text = (EditText) getView().findViewById(R.id.fragment_text);
        frag_count = (TextView) getView().findViewById(R.id.fragment_count);
        //gets the string from sharedpreferences and puts it back
        SharedPreferences pref=getActivity().getSharedPreferences(PREF_COUNT3, 0);
        String count1=pref.getString("count", "0");
        String id=pref.getString("article", "");
        frag_count.setText(count1);
        frag_text.setText(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflates the xml layout
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //setup to use
        frag_text = (EditText) view.findViewById(R.id.fragment_text);
        frag_count = (TextView) view.findViewById(R.id.fragment_count);
        add1=(Button)view.findViewById(R.id.btn_plus_one);
        sub1=(Button)view.findViewById(R.id.btn_minus_one);
        reset=(Button)view.findViewById(R.id.btn_reset);
        buttonl=(LinearLayout)view.findViewById(R.id.button_layout);

        //automatically hides buttons
        buttonl.setVisibility(View.GONE);


        //+1
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = 1;
                //get the text from the textview, make it a string
                //convert the string to an int
                //add two ints together
                //convert int back to string and set it to the textview
                String value = frag_count.getText().toString();
                int intvalue = Integer.parseInt(value);
                int amount = intvalue + a1;
                frag_count.setText(Integer.toString(amount));
            }
        });
        //-1
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = -1;
                String value = frag_count.getText().toString();
                int intvalue = Integer.parseInt(value);
                int amount = intvalue + a1;
                frag_count.setText(Integer.toString(amount));
            }
        });
        //0
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag_count.setText("0");
            }
        });


        return view;
    }

    //method to add one to the textview
    //here so activities can access it
    public void addOne(){
        frag_count = (TextView) getView().findViewById(R.id.fragment_count);
        int a1 = 1;
        String value = frag_count.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + a1;
        frag_count.setText(Integer.toString(amount));
    }


    //method for activities to access
    //shows buttons if full screen
    public void showButtons(){
        buttonl=(LinearLayout)getView().findViewById(R.id.button_layout);
        buttonl.setVisibility(View.VISIBLE);
    }

    //method for activities to access
    //hides buttons if full screen
    public void hideButtons(){
        buttonl=(LinearLayout)getView().findViewById(R.id.button_layout);
        buttonl.setVisibility(View.GONE);
    }

    //method for activities to access
    //resets the count to 0 on the activity
    public void resetCount(){
        frag_count = (TextView) getView().findViewById(R.id.fragment_count);
        frag_text = (EditText) getView().findViewById(R.id.fragment_text);
        frag_text.setText("");
        frag_count.setText("0");
    }

    @Override
    public void onPause(){
        super.onPause();
        //Get the textview so we can get the text from it
        frag_text = (EditText) getView().findViewById(R.id.fragment_text);
        frag_count = (TextView) getView().findViewById(R.id.fragment_count);

        //make the SharedPReference and set it up
        //we also make an editor, add our variable to it and commit
        SharedPreferences pref=getActivity().getSharedPreferences(PREF_COUNT3, 0);
        SharedPreferences.Editor edt=pref.edit();
        edt.putString("count", frag_count.getText().toString());
        edt.putString("article", frag_text.getText().toString());

        //commit the edits
        edt.commit();
    }
}
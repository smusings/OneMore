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


public class FragmentTwo extends Fragment {

    public static final String PREF_COUNT_2 = "MyPrefsCount4";


    //everything we need
    public EditText itemLabel_et;
    public TextView itemCount_tv;
    public Button add1;
    public Button sub1;
    public Button reset;
    LinearLayout button_layout;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //gets the string from sharedpreferences and puts it back
        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT_2, 0);
        String count1 = pref.getString("count", "0");
        String id = pref.getString("article", "");
        itemLabel_et.setText(count1);
        itemCount_tv.setText(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //inflates the xml layout
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //setup to useitem
        itemLabel_et = (EditText) view.findViewById(R.id.item_label_text);
        itemCount_tv = (TextView) view.findViewById(R.id.item_count_text);
        add1 = (Button)view.findViewById(R.id.plus_one_button);
        sub1 = (Button)view.findViewById(R.id.minus_one_button);
        reset = (Button)view.findViewById(R.id.reset_button);
        button_layout = (LinearLayout)view.findViewById(R.id.button_layout);

        //automatically hides buttons
        button_layout.setVisibility(View.GONE);
        //+1
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOne();
            }
        });
        //-1
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intvalue = Integer.parseInt(itemCount_tv.getText().toString());
                int amount = intvalue - 1;
                itemCount_tv.setText(Integer.toString(amount));
            }
        });
        //0
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCount_tv.setText("0");
            }
        });

        return view;
    }

    //get the text from the textview, make it a string
    //convert the string to an int
    //add two ints together
    //convert int back to string and set it to the textview
    public void addOne(){
        int intvalue = Integer.parseInt(itemCount_tv.getText().toString());
        int amount = intvalue + 1;
        itemCount_tv.setText(Integer.toString(amount));
    }

    //method for activities to access
    //shows buttons if full screen
    public void showButtons(){
        button_layout.setVisibility(View.VISIBLE);
    }

    //method for activities to access
    //hides buttons if full screen
    public void hideButtons(){
        button_layout.setVisibility(View.GONE);
    }

    //method for activities to access
    //resets the count to 0 on the activity
    public void resetCount(){
        itemLabel_et.setText("");
        itemCount_tv.setText("0");
    }

    @Override
    public void onPause(){
        super.onPause();
        //make the SharedPReference and set it up
        //we also make an editor, add our variable to it and commit
        SharedPreferences pref = getActivity().getSharedPreferences(PREF_COUNT_2, 0);
        SharedPreferences.Editor edt = pref.edit();
        edt.putString("count", itemCount_tv.getText().toString());
        edt.putString("article", itemLabel_et.getText().toString());

        //commit the edits
        edt.commit();
    }
}
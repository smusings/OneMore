package com.smusing.onemore.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentOne extends Fragment{

    //everything we need
    Number nul;
    EditText frag_text;
    TextView frag_count;
    Button add1;
    Button sub1;
    Button reset;
    LinearLayout buttonl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
        //inflates the xml layout
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //gives the the 0 we need
        nul = 0;

        //setup to use
        frag_text = (EditText) view.findViewById(R.id.fragment_text);
        frag_count = (TextView) view.findViewById(R.id.fragment_count);
        add1=(Button)view.findViewById(R.id.btn_plus_one);
        sub1=(Button)view.findViewById(R.id.btn_minus_one);
        reset=(Button)view.findViewById(R.id.btn_reset);
        buttonl=(LinearLayout)view.findViewById(R.id.button_layout);

        //automatically hides buttons
        buttonl.setVisibility(View.GONE);

        //sets our initial count to 0
        frag_count.setText(nul.toString());

        //+1
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = 1;
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

                frag_count.setText(nul.toString());
            }
        });

        return view;
    }

    //method for activities to access
    public void showButtons(){
        buttonl=(LinearLayout)getView().findViewById(R.id.button_layout);
        buttonl.setVisibility(View.VISIBLE);
    }

    //method for activities to access
    public void hideButtons(){
        buttonl=(LinearLayout)getView().findViewById(R.id.button_layout);
        buttonl.setVisibility(View.GONE);
    }

    //method for activities to access
    public void resetCount(){
        nul = 0;
        frag_count = (TextView) getView().findViewById(R.id.fragment_count);
        frag_count.setText(nul.toString());
    }
}
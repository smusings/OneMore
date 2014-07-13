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

    //in case i want to do it differently
    Number nul;
    String ini;
    EditText frag_text;
    TextView frag_count;
    LinearLayout frag_layout;
    Button add1;
    Button sub1;
    Button reset;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        nul = 0;
        ini = nul.toString();



        //setup to use

        frag_text = (EditText) view.findViewById(R.id.fragment_text);
        frag_count = (TextView) view.findViewById(R.id.fragment_count);
        frag_layout=(LinearLayout)view.findViewById(R.id.fragment_layout);
        frag_count.setText(ini);

        frag_text.setEnabled(false);



        return view;
    }

    public String getBundleString(Bundle b){
        String value=b.getString("subject");
        return value;
    }

    public void doPositiveClick(){

        final TextView chaptercount = (TextView) getView().findViewById(R.id.fragment_count);
        Number n=0;
        chaptercount.setText(n.toString());
    }
}
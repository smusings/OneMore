package com.smusing.onemore.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/*
        frag_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                frag_text.setEnabled(true);
                return true;
            }
        });

        frag_text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.KEYCODE_ENTER){
                    frag_text.setEnabled(false);
                }
                return false;
            }
        });
        */




/*

        //onSwipe Gesture i need
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        float sensitvity = 50;
                        //right to left
                        if ((e1.getX() - e2.getX()) > sensitvity) {
                            int nn = -1;
                            String value = frag_count.getText().toString();
                            int intvalue = Integer.parseInt(value);
                            int amount = intvalue + nn;
                            frag_count.setText(Integer.toString(amount));
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                            OneMoreDialogue newF=OneMoreDialogue.newInstance(1);
                            newF.show(getChildFragmentManager(), "fragmentDialog");
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                    @Override
                    public boolean onSingleTapUp(MotionEvent e){
                        Number n = 1;
                        int nn = 1;
                        String value = frag_count.getText().toString();
                        int intvalue = Integer.parseInt(value);
                        int amount = intvalue + nn;
                        frag_count.setText(Integer.toString(amount));

                        return true;
                    }
                }
        );
        frag_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        */

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
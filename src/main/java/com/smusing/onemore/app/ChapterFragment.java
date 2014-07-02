package com.smusing.onemore.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChapterFragment extends Fragment{

    //in case i want to do it differently
    private static final String DEBUG_TAG = "Gestures";
    Number nul;
    String ini;
    Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chapter_fragment, container, false);

        nul = 0;
        ini = nul.toString();



        //setup to use

        final TextView chaptertext = (TextView) view.findViewById(R.id.chapter_text);
        final TextView chaptercount = (TextView) view.findViewById(R.id.chapter_count);
        chaptercount.setText(ini);





        //i want to use this eventualy hold and delete things

        chaptertext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });



        //onSwipe Gesture i need
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        float sensitvity = 50;
                        //right to left
                        if ((e1.getX() - e2.getX()) > sensitvity) {
                            Number n = -1;
                            int nn = -1;
                            String value = chaptercount.getText().toString();
                            int intvalue = Integer.parseInt(value);
                            int amount = intvalue + nn;
                            chaptercount.setText(Integer.toString(amount));
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                            new OneMoreDialogue().show(getChildFragmentManager(), "fragmentDialog");
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                    @Override
                public boolean onSingleTapUp(MotionEvent e){
                        Number n = 1;
                        int nn = 1;
                        String value = chaptercount.getText().toString();
                        int intvalue = Integer.parseInt(value);
                        int amount = intvalue + nn;
                        chaptercount.setText(Integer.toString(amount));

                        return true;

                    }
                }
        );

        chaptertext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        return view;
    }

    private void doPositiveClick(){

    }



}
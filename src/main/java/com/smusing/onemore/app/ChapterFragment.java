package com.smusing.onemore.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChapterFragment extends Fragment {

    //in case i want to do it differently
    private static final String DEBUG_TAG = "Gestures";
    TextView chaptertext;
    Number nul;
    String ini;
    private GestureDetectorCompat mDetector;
    private OmChapterListener omChapterListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chapter_fragment, container, false);

        nul = 0;
        ini = nul.toString();

        //setup to use
        chaptertext = (TextView) view.findViewById(R.id.chapter_text);
        TextView chaptercount = (TextView) view.findViewById(R.id.fragment_count);
        chaptertext.setText(R.string.chapters);
        chaptercount.setText(ini);




        //onSwipe Gesture i need
        final GestureDetector gesture=new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        float sensitvity = 50;
                        //right to left
                        if ((e1.getX() - e2.getX()) > sensitvity) {
                            Number n=-1;
                            omChapterListener.omchapter(n);
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                            Number n=1;
                            omChapterListener.omchapter(n);
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });


        //i want to use this eventualy hold and delete things
        chaptertext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        chaptertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number n = 1;
                omChapterListener.omchapter(n);
            }
        });





        //this SHOULD send what I need across
        chaptertext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return gesture.onTouchEvent(event);
            }
        });

        return view;
    }

    public void doSomething(String s) {
        TextView chaptercount = (TextView) getView().findViewById(R.id.fragment_count);
        chaptercount.setText(s);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            omChapterListener = (OmChapterListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement OnNewRollListener");
        }
    }

    //the listener that sends it along
    //the listener locks for a new String/Number message to send to an activity
    public interface OmChapterListener {
        public void omchapter(Number n);
    }

}
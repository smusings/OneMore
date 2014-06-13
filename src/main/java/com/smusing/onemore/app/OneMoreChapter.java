package com.smusing.onemore.app;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OneMoreChapter extends Fragment{

    //in case i want to do it differently
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.onemore_fragment, container, false);

        //setup to use
        TextView chaptertext=(TextView)view.findViewById(R.id.chapter_text);
        TextView chaptercount=(TextView)view.findViewById(R.id.chapter_count);
        LinearLayout chapterlayout=(LinearLayout)view.findViewById(R.id.chapter_all);
        chaptertext.setText(R.string.chapters);

        //onSwipe Gesture i need
        final GestureDetector gesture=new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        float sensitvity = 50;
                        //right to left
                        if ((e1.getX() - e2.getX()) > sensitvity) {
                            Number n=1;
                            omChapterListener.omchapter(n);
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                            Number n=-1;
                            omChapterListener.omchapter(n);
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        //i want to use this eventualy hold and delete things
        chapterlayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //possible onlongclick delete the button or listview maybe
                return false;
            }
        });

        //this SHOULD send what I need across
        chapterlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return gesture.onTouchEvent(event);
            }
        });

        return view;
    }

    public void changeText(String text){
        TextView t = (TextView) this.getView().findViewById(R.id.chapter_count);
        t.setText(text);
    }
    public CharSequence gettext( ){
        TextView t = (TextView) this.getView().findViewById(R.id.chapter_count);
        return t.getText();
    }

    //the listener that sends it along
    //the listener locks for a new String/Number message to send to an activity
    public interface OmChapterListener{
        public void omchapter(Number n);
    }

    private OmChapterListener omChapterListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            omChapterListener=(OmChapterListener)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+
                    " must implement OnNewRollListener");
        }
    }

}
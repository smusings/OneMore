package com.smusing.onemore.app;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;

public class OMGestureDetector extends GestureDetector.SimpleOnGestureListener {
    private ListView lv;


    public OMGestureDetector(ListView lv) {
        this.lv = lv;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        float sensitvity = 50;
        //right to left
        if ((e1.getX() - e2.getX()) > sensitvity) {
            int pos = lv.pointToPosition((int) e1.getX(), (int) e2.getY());
        }
        //left to right
        else if ((e2.getX() - e1.getX()) > sensitvity) {
            int pos = lv.pointToPosition((int) e1.getX(), (int) e2.getY());
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
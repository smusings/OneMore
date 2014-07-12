package com.smusing.onemore.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentTwo extends Fragment{

    Number nul;
    String ini;
    TextView frag_text;
    TextView frag_count;
    LinearLayout frag_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        nul = 0;
        ini = nul.toString();



        //setup to use

        final TextView frag_text = (TextView) view.findViewById(R.id.page_text);
        final TextView frag_count = (TextView) view.findViewById(R.id.page_count);
        final LinearLayout frag_layout=(LinearLayout)view.findViewById(R.id.page_layout);
        frag_count.setText(ini);


        frag_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ChangeTextDialog newF=ChangeTextDialog.newInstance(2);
                newF.show(getChildFragmentManager(), "fragmentDialog");
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
                            String value = frag_count.getText().toString();
                            int intvalue = Integer.parseInt(value);
                            int amount = intvalue + nn;
                            frag_count.setText(Integer.toString(amount));
                        }
                        //left to right
                        else if ((e2.getX() - e1.getX()) > sensitvity) {
                            OneMoreDialogue newF=OneMoreDialogue.newInstance(2);
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

        return view;
    }

    public void doPositiveClick(){

        final TextView pagecount = (TextView) getView().findViewById(R.id.page_count);
        Number n=0;
        pagecount.setText(n.toString());
    }

    public void onResume(Bundle savedInstanceState){
        final TextView pagetext = (TextView) getView().findViewById(R.id.page_text);
        Bundle b=getArguments();
        String s=b.getString("subject");
        String t="default";
        if (b != null){
            pagetext.setText(s);
        }else{
            pagetext.setText(t);
        }
    }



    public void skree(){
        final TextView pagetext = (TextView) getView().findViewById(R.id.page_text);


        Bundle b=getArguments();
        String s=b.getString("subject");
        String t="default";
        if (b != null && !b.containsKey("subject")){
            pagetext.setText(s);
        }else{
            pagetext.setText(t);
        }
    }

}
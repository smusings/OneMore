package com.smusing.onemore.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OneMoreChapter extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onemore_fragment, container, false);

        TextView chaptertext=(TextView)view.findViewById(R.id.onemore_text);
        TextView chaptercount=(TextView)view.findViewById(R.id.onemore_count);

        chaptertext.setText(R.string.chapters);

    return view;
    }
}

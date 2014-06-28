package com.smusing.onemore.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class OneMoreArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private ArrayList<String> list;
    private ArrayList<String> amount;
    private int[] colors = new int[]{R.color.Goldenrod, R.color.Crimson, R.color.ForestGreen};

    public OneMoreArrayAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.one_more_list, list);
        this.context = context;
        this.list = list;
        this.amount=amount;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.one_more_list, parent, false);

        TextView tvtext = (TextView) view.findViewById(R.id.layout_text);
        TextView tvcount = (TextView) view.findViewById(R.id.layout_count);

        int colorPos = position % colors.length;
        view.setBackgroundResource(colors[colorPos]);

        final String[] listarray = new String[list.size()];
        list.toArray(listarray);
        final String[] amountarray = new String[amount.size()];
        amount.toArray(amountarray);

        tvtext.setText(listarray[position]);
        Number n = 0;
        String ns = n.toString();
        tvcount.setText(amountarray[position]);
        return view;
    }
}
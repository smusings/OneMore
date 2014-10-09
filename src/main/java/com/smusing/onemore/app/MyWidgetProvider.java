package com.smusing.onemore.app;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

public class MyWidgetProvider extends AppWidgetProvider{


    public static final String PREF_COUNT_1 = "MyPrefsCount1";
    public static final String PREF_COUNT_2 = "MyPrefsCount2";
    public static final String PREF_COUNT_3 = "MyPrefsCount3";
    public static final String PREF_COUNT_4 = "MyPrefsCount4";
    public static final String PREF_COUNT_5 = "MyPrefsCount5";
    public static final String PREF_COUNT_6 = "MyPrefsCount6";


    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){

        //get the shared Preference from each Fragment
        SharedPreferences pref1 = context.getSharedPreferences(PREF_COUNT_1, 0);
        SharedPreferences pref2 = context.getSharedPreferences(PREF_COUNT_2, 0);
        SharedPreferences pref3 = context.getSharedPreferences(PREF_COUNT_3, 0);
        SharedPreferences pref4 = context.getSharedPreferences(PREF_COUNT_4, 0);
        SharedPreferences pref5 = context.getSharedPreferences(PREF_COUNT_5, 0);
        SharedPreferences pref6 = context.getSharedPreferences(PREF_COUNT_6, 0);


        final int N = appWidgetIds.length;

        //perform this procedure for each App Widget that  belongs to this provider
        for (int i = 0; i<N; i++){
            int appWidgetId = appWidgetIds[i];

            //set up intent to onclick open App
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            //set up the views so we can interact with the layout
            RemoteViews views =
                    new RemoteViews(context.getPackageName(), R.layout.appwidget_provider_layout);
            views.setOnClickPendingIntent(R.id.widget_layout, pendingIntent);

            //get the strings from each fragment
            String count1 = pref1.getString("count", "0");
            String id1 = pref1.getString("article", "");

            String count2 = pref2.getString("count", "0");
            String id2 = pref2.getString("article", "");

            String count3 = pref3.getString("count", "0");
            String id3 = pref3.getString("article", "");

            String count4 = pref4.getString("count", "0");
            String id4 = pref4.getString("article", "");

            String count5 = pref5.getString("count", "0");
            String id5 = pref5.getString("article", "");

            String count6 = pref6.getString("count", "0");
            String id6 = pref6.getString("article", "");


            //set the strings to the appropriate textview
            views.setTextViewText(R.id.id1, id1);
            views.setTextViewText(R.id.count1, count1);

            views.setTextViewText(R.id.id2, id2);
            views.setTextViewText(R.id.count2, count2);

            views.setTextViewText(R.id.id3, id3);
            views.setTextViewText(R.id.count3, count3);

            views.setTextViewText(R.id.id4, id4);
            views.setTextViewText(R.id.count4, count4);

            views.setTextViewText(R.id.id5, id5);
            views.setTextViewText(R.id.count5, count5);

            views.setTextViewText(R.id.id6, id6);
            views.setTextViewText(R.id.count6, count6);

            //tell the AppWidgetManager to perform an updateon the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}

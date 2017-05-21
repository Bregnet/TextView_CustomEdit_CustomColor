package com.editText.CustomColor;

import android.content.*;
import android.os.*;
import android.preference.*;
import android.util.*;
import android.widget.*;


public class Text2 extends TextView
{


    private Runnable mTicker;
    private Handler mHandler;
    private String Text2;
	private int ColorText2;

    public Text2(final Context c, AttributeSet attrs){
        super(c, attrs);

        mHandler = new Handler();
        mTicker = new Runnable() {
			public void run() {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);

				// ini untuk membuat key EditText
                Text2 = prefs.getString("Text2","Ikeh");
				//ini untuk membuat key Color nnya
				ColorText2 = prefs.getInt("Color_Text2",0xfff00000);

				//ini untuk mengeset Text dan Color
				Text2.this.setText(Text2);
				Text2.this.setTextColor(ColorText2);


				invalidate();
                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - now % 1000);
                mHandler.postAtTime(mTicker, next);



			}
		};
		mTicker.run();
	}
}

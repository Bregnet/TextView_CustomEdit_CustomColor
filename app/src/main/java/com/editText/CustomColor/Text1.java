package com.editText.CustomColor;

import android.content.*;
import android.os.*;
import android.preference.*;
import android.util.*;
import android.widget.*;


public class Text1 extends TextView
{


    private Runnable mTicker;
    private Handler mHandler;
    private String Text1;
	private int ColorText1;

    public Text1(final Context c, AttributeSet attrs){
        super(c, attrs);

        mHandler = new Handler();
        mTicker = new Runnable() {
			public void run() {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
				
				// ini untuk membuat key EditText
                Text1 = prefs.getString("Text1","Ikeh");
				//ini untuk membuat key Color nnya
				ColorText1 = prefs.getInt("Color_Text1",0xfff00000);
				
				//ini untuk mengeset Text dan Color
				Text1.this.setText(Text1);
				Text1.this.setTextColor(ColorText1);
				
				
				invalidate();
                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - now % 1000);
                mHandler.postAtTime(mTicker, next);



			}
		};
		mTicker.run();
	}
}

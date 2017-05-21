package com.editText.CustomColor;
import android.preference.*;
import android.os.*;

public class Pengaturan extends PreferenceActivity
{
		@Override
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
		//Ini untuk memanggil Preference nya yg ada di folder xml
        addPreferencesFromResource(setResource("pengaturan","xml"));
    }
    public int setResource(String Nama, String Tipe)
    {
        return getBaseContext().getResources().getIdentifier(Nama, Tipe, getBaseContext().getPackageName());
    }
}

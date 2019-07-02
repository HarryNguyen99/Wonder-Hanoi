package com.example.baihoc1.ontap1appkorea.Util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class UtilDocJson {

    public static String loadPlace(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Place.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadPromotion(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Promotion.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadContact(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Contact.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}



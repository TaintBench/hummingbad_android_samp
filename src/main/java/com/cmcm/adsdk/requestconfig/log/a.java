package com.cmcm.adsdk.requestconfig.log;

import android.util.Log;

/* compiled from: Logger */
public final class a {
    public static boolean a = false;

    public static void a(String str) {
        if (a) {
            Log.e("CMAD", str);
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }
}

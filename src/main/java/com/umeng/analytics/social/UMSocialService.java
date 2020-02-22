package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public abstract class UMSocialService {

    private static class a extends AsyncTask<Void, Void, d> {
        String a;
        String b;
        b c;
        UMPlatformData[] d;

        public a(String[] strArr, b bVar, UMPlatformData[] uMPlatformDataArr) {
            this.a = strArr[0];
            this.b = strArr[1];
            this.c = bVar;
            this.d = uMPlatformDataArr;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.c != null) {
                this.c.a();
            }
        }

        /* access modifiers changed from: protected|varargs */
        /* renamed from: a */
        public d doInBackground(Void... voidArr) {
            String a;
            if (TextUtils.isEmpty(this.b)) {
                a = c.a(this.a);
            } else {
                a = c.a(this.a, this.b);
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                int optInt = jSONObject.optInt("st");
                d dVar = new d(optInt == 0 ? e.t : optInt);
                String optString = jSONObject.optString("msg");
                if (!TextUtils.isEmpty(optString)) {
                    dVar.a(optString);
                }
                optString = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString)) {
                    return dVar;
                }
                dVar.b(optString);
                return dVar;
            } catch (Exception e) {
                return new d(-99, e);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(d dVar) {
            if (this.c != null) {
                this.c.a(dVar, this.d);
            }
        }
    }

    public interface b {
        void a();

        void a(d dVar, UMPlatformData... uMPlatformDataArr);
    }

    private static void a(Context context, b bVar, String str, UMPlatformData... uMPlatformDataArr) {
        int i = 0;
        if (uMPlatformDataArr != null) {
            try {
                int length = uMPlatformDataArr.length;
                while (i < length) {
                    if (uMPlatformDataArr[i].isValid()) {
                        i++;
                    } else {
                        throw new a("parameter is not valid.");
                    }
                }
            } catch (a e) {
                Log.e(com.umeng.analytics.a.e, "unable send event.", e);
                return;
            } catch (Exception e2) {
                Log.e(com.umeng.analytics.a.e, "", e2);
                return;
            }
        }
        new a(f.a(context, str, uMPlatformDataArr), bVar, uMPlatformDataArr).execute(new Void[0]);
    }

    public static void share(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        a(context, null, str, uMPlatformDataArr);
    }

    public static void share(Context context, UMPlatformData... uMPlatformDataArr) {
        a(context, null, null, uMPlatformDataArr);
    }
}

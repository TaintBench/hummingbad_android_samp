package u.aly;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: StatTracer */
public class w {
    private static final String h = "successful_request";
    private static final String i = "failed_requests ";
    private static final String j = "last_request_spent_ms";
    private static final String k = "last_request_time";
    private static final String l = "first_activate_time";
    public int a;
    public int b;
    public long c;
    private final int d = 3600000;
    private int e;
    private long f = 0;
    private long g = 0;
    private Context m;

    public w(Context context) {
        b(context);
    }

    private void b(Context context) {
        this.m = context.getApplicationContext();
        SharedPreferences a = u.a(context);
        this.a = a.getInt(h, 0);
        this.b = a.getInt(i, 0);
        this.e = a.getInt(j, 0);
        this.c = a.getLong(k, 0);
    }

    public int a() {
        return this.e > 3600000 ? 3600000 : this.e;
    }

    public boolean b() {
        return this.c == 0;
    }

    public void c() {
        this.a++;
        this.c = this.f;
    }

    public void d() {
        this.b++;
    }

    public void e() {
        this.f = System.currentTimeMillis();
    }

    public void f() {
        this.e = (int) (System.currentTimeMillis() - this.f);
    }

    public void g() {
        u.a(this.m).edit().putInt(h, this.a).putInt(i, this.b).putInt(j, this.e).putLong(k, this.c).commit();
    }

    public void h() {
        u.a(this.m).edit().putLong(l, System.currentTimeMillis()).commit();
    }

    public boolean i() {
        if (this.g == 0) {
            this.g = u.a(this.m).getLong(l, 0);
        }
        return this.g == 0;
    }

    public long j() {
        return i() ? System.currentTimeMillis() : this.g;
    }

    public static J a(Context context) {
        SharedPreferences a = u.a(context);
        J j = new J();
        j.c(a.getInt(i, 0));
        j.d(a.getInt(j, 0));
        j.a(a.getInt(h, 0));
        return j;
    }
}

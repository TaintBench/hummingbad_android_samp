package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
public class a implements Comparable<a> {
    public long a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j = this.b - aVar.b;
        if (j > 0) {
            return 1;
        }
        if (j < 0) {
            return -1;
        }
        return 0;
    }
}

package com.duapps.ad.entity;

import com.duapps.ad.base.d;
import com.duapps.ad.base.f;
import com.duapps.ad.base.w;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.net.URL;

/* compiled from: NativeAdDLWrapper */
final class i implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void run() {
        try {
            int statusCode = w.a(new URL(this.a), null, true).getStatusLine().getStatusCode();
            if (statusCode != CtaButton.WIDTH_DIPS) {
                f.c(h.a, "Impression to " + this.b.e.k + " failed!");
            } else if (statusCode == CtaButton.WIDTH_DIPS) {
                f.c(h.a, "Impression to " + this.b.e.k + " success!");
            }
            d.a(this.b.b, this.b.e, statusCode);
        } catch (Exception e) {
            f.c(h.a, "Impression to " + this.b.e.k + " exception!");
        }
    }
}

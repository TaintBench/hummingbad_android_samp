package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

public final class AdUrlAdapter extends AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    public String getAdUnitId(Bundle serverParameters) {
        return "adurl";
    }

    /* access modifiers changed from: protected */
    public Bundle zza(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }
}

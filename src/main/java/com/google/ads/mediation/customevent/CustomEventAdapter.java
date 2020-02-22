package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzaY;
    CustomEventBanner zzaZ;
    CustomEventInterstitial zzba;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzbb;
        private final MediationBannerListener zzbc;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzbb = customEventAdapter;
            this.zzbc = mediationBannerListener;
        }

        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbc.onClick(this.zzbb);
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbc.onDismissScreen(this.zzbb);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbc.onFailedToReceiveAd(this.zzbb, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbc.onLeaveApplication(this.zzbb);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbc.onPresentScreen(this.zzbb);
        }

        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onReceivedAd.");
            this.zzbb.zza(view);
            this.zzbc.onReceivedAd(this.zzbb);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzbb;
        private final MediationInterstitialListener zzbd;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzbb = customEventAdapter;
            this.zzbd = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onDismissScreen.");
            this.zzbd.onDismissScreen(this.zzbb);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            this.zzbd.onFailedToReceiveAd(this.zzbb, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onLeaveApplication.");
            this.zzbd.onLeaveApplication(this.zzbb);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onPresentScreen.");
            this.zzbd.onPresentScreen(this.zzbb);
        }

        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onReceivedAd.");
            this.zzbd.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* access modifiers changed from: private */
    public void zza(View view) {
        this.zzaY = view;
    }

    private static <T> T zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    public void destroy() {
        if (this.zzaZ != null) {
            this.zzaZ.destroy();
        }
        if (this.zzba != null) {
            this.zzba.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzaY;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzaZ = (CustomEventBanner) zzj(serverParameters.className);
        if (this.zzaZ == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzaZ.requestBannerAd(new zza(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzba = (CustomEventInterstitial) zzj(serverParameters.className);
        if (this.zzba == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzba.requestInterstitialAd(zza(listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzba.showInterstitial();
    }

    /* access modifiers changed from: 0000 */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}

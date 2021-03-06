package com.cmcm.adsdk.nativead;

import android.content.Context;
import android.text.TextUtils;
import com.cmcm.adsdk.CMAdManager;
import com.cmcm.adsdk.Const;
import com.cmcm.adsdk.adapter.BaseNativeAdapter.NativeAdapterListener;
import com.cmcm.adsdk.adapter.d;
import com.cmcm.adsdk.requestconfig.log.a;
import com.cmcm.baseapi.ads.INativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MopubNativeAdLoader extends e implements NativeAdapterListener {
    private static final String TAG = "MopubNativeLoader";
    private INativeAd mCacheAd;
    private long mLoadStartTime;
    private String mMopubUniId;

    public MopubNativeAdLoader(Context context, String posId, String mopubUniId, String adTypeName) {
        super(context, posId, adTypeName);
        this.mMopubUniId = mopubUniId;
    }

    public void loadAd() {
        a.a(TAG, "loadAd mopub");
        if (!(this.mCacheAd == null || this.mCacheAd.hasExpired())) {
            this.mNativeAdListener.adLoaded(getAdTypeName());
        }
        if (TextUtils.isEmpty(this.mMopubUniId)) {
            this.mNativeAdListener.adFailedToLoad(getAdTypeName(), "ssp adtype configured incorrectly");
        }
        new d().a(this.mContext, this, getLoadExtras(this.mMopubUniId));
        this.mLoadStartTime = System.currentTimeMillis();
        doLoadReport();
    }

    private Map<String, Object> getLoadExtras(String placementId) {
        HashMap hashMap = new HashMap();
        hashMap.put(CMNativeAd.KEY_PLACEMENT_ID, placementId);
        hashMap.put(CMNativeAd.KEY_JUHE_POSID, this.mPositionId);
        hashMap.put(CMNativeAd.KEY_REPORT_RES, Integer.valueOf(3003));
        hashMap.put(CMNativeAd.KEY_REPORT_PKGNAME, String.format("%s.%s", new Object[]{"com.mopub.ad", getAdTypeName()}));
        long adTypeCacheTime = CMAdManager.getAdTypeCacheTime(Const.KEY_MP);
        String str = CMNativeAd.KEY_CACHE_TIME;
        if (adTypeCacheTime == 0) {
            adTypeCacheTime = 3600000;
        }
        hashMap.put(str, Long.valueOf(adTypeCacheTime));
        return hashMap;
    }

    public INativeAd getAd() {
        if (this.mCacheAd == null || this.mCacheAd.hasExpired()) {
            return null;
        }
        INativeAd iNativeAd = this.mCacheAd;
        this.mCacheAd = null;
        return iNativeAd;
    }

    public List<INativeAd> getAdList(int num) {
        INativeAd ad = getAd();
        if (ad == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ad);
        return arrayList;
    }

    public void onNativeAdLoaded(INativeAd nativeAd) {
        this.mCacheAd = nativeAd;
        this.mNativeAdListener.adLoaded(getAdTypeName());
        doLoadSuccessReport(System.currentTimeMillis() - this.mLoadStartTime);
    }

    public void onNativeAdFailed(String eorroInfo) {
        this.mNativeAdListener.adFailedToLoad(getAdTypeName(), eorroInfo);
        doLoadFailReport(System.currentTimeMillis() - this.mLoadStartTime, eorroInfo);
    }

    public void onNativeAdClick(INativeAd nativeAd) {
        this.mNativeAdListener.adClicked(nativeAd);
    }

    public void onNativeAdLoaded(List<INativeAd> list) {
        doLoadSuccessReport(System.currentTimeMillis() - this.mLoadStartTime);
    }

    public void loadAds(int num) {
        loadAd();
    }
}

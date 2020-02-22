package com.mb.bdapp.down.callback;

import com.mb.bdapp.down.DownloadException;
import java.io.File;

public abstract class RequestCallBack {
    private static final int DEFAULT_RATE = 1000;
    private static final int MIN_RATE = 200;
    private int rate;
    private String requestUrl;
    protected Object userTag;

    public abstract void onFailure(DownloadException downloadException, String str);

    public abstract void onSuccess(File file);

    public RequestCallBack() {
        this.rate = 1000;
    }

    public RequestCallBack(int rate) {
        this.rate = rate;
    }

    public RequestCallBack(Object userTag) {
        this.rate = 1000;
        this.userTag = userTag;
    }

    public RequestCallBack(int rate, Object userTag) {
        this.rate = rate;
        this.userTag = userTag;
    }

    public final int getRate() {
        if (this.rate < 200) {
            return 200;
        }
        return this.rate;
    }

    public final void setRate(int rate) {
        this.rate = rate;
    }

    public Object getUserTag() {
        return this.userTag;
    }

    public void setUserTag(Object userTag) {
        this.userTag = userTag;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void onStart() {
    }

    public void onCancelled() {
    }

    public void onLoading(long total, long current) {
    }
}

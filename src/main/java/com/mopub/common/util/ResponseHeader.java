package com.mopub.common.util;

public enum ResponseHeader {
    AD_TIMEOUT("X-AdTimeout"),
    AD_TYPE("X-Adtype"),
    CLICK_TRACKING_URL("X-Clickthrough"),
    CUSTOM_EVENT_DATA("X-Custom-Event-Class-Data"),
    CUSTOM_EVENT_NAME("X-Custom-Event-Class-Name"),
    CUSTOM_EVENT_HTML_DATA("X-Custom-Event-Html-Data"),
    DSP_CREATIVE_ID("X-DspCreativeid"),
    FAIL_URL("X-Failurl"),
    FULL_AD_TYPE("X-Fulladtype"),
    HEIGHT("X-Height"),
    IMPRESSION_URL("X-Imptracker"),
    REDIRECT_URL("X-Launchpage"),
    NATIVE_PARAMS("X-Nativeparams"),
    NETWORK_TYPE("X-Networktype"),
    ORIENTATION("X-Orientation"),
    REFRESH_TIME("X-Refreshtime"),
    SCROLLABLE("X-Scrollable"),
    WARMUP("X-Warmup"),
    WIDTH("X-Width"),
    LOCATION("Location"),
    USER_AGENT("User-Agent"),
    ACCEPT_LANGUAGE("Accept-Language"),
    PLAY_VISIBLE_PERCENT("X-Play-Visible-Percent"),
    PAUSE_VISIBLE_PERCENT("X-Pause-Visible-Percent"),
    IMPRESSION_MIN_VISIBLE_PERCENT("X-Impression-Min-Visible-Percent"),
    IMPRESSION_VISIBLE_MS("X-Impression-Visible-Ms"),
    MAX_BUFFER_MS("X-Max-Buffer-Ms"),
    CUSTOM_SELECTOR("X-Customselector");
    
    private final String key;

    private ResponseHeader(String key) {
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }
}

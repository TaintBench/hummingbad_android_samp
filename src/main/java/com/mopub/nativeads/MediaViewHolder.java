package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

class MediaViewHolder {
    @VisibleForTesting
    static final MediaViewHolder EMPTY_MEDIA_VIEW_HOLDER = new MediaViewHolder();
    @Nullable
    TextView callToActionView;
    @Nullable
    ImageView iconImageView;
    @Nullable
    View mainView;
    @Nullable
    MediaLayout mediaLayout;
    @Nullable
    ImageView privacyInformationIconImageView;
    @Nullable
    TextView textView;
    @Nullable
    TextView titleView;

    private MediaViewHolder() {
    }

    @NonNull
    static MediaViewHolder fromViewBinder(@NonNull View view, @NonNull MediaViewBinder mediaViewBinder) {
        MediaViewHolder mediaViewHolder = new MediaViewHolder();
        mediaViewHolder.mainView = view;
        try {
            mediaViewHolder.titleView = (TextView) view.findViewById(mediaViewBinder.titleId);
            mediaViewHolder.textView = (TextView) view.findViewById(mediaViewBinder.textId);
            mediaViewHolder.callToActionView = (TextView) view.findViewById(mediaViewBinder.callToActionId);
            mediaViewHolder.mediaLayout = (MediaLayout) view.findViewById(mediaViewBinder.mediaLayoutId);
            mediaViewHolder.iconImageView = (ImageView) view.findViewById(mediaViewBinder.iconImageId);
            mediaViewHolder.privacyInformationIconImageView = (ImageView) view.findViewById(mediaViewBinder.privacyInformationIconImageId);
            return mediaViewHolder;
        } catch (ClassCastException e) {
            MoPubLog.w("Could not cast from id in MediaViewBinder to expected View type", e);
            return EMPTY_MEDIA_VIEW_HOLDER;
        }
    }
}

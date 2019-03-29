package io.zhuliang.appchooser.data;

import java.util.List;

import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

import static io.zhuliang.appchooser.internal.Preconditions.checkNotNull;

/**
 * @author Zhu Liang
 * @version 1.0
 * @since 2017/4/15 下午1:59
 */
public class MediaTypesRepository implements MediaTypesDataSource {

    @NonNull
    private final MediaTypesDataSource mMediaTypesLocalDataSource;

    private List<MediaType> mCachedMediaTypes;

    public MediaTypesRepository(@NonNull MediaTypesDataSource mediaTypesLocalDataSource) {
        mMediaTypesLocalDataSource = checkNotNull(mediaTypesLocalDataSource);
    }

    @Deprecated
    @Override
    public Observable<List<MediaType>> listMediaTypesRx() {
        return mMediaTypesLocalDataSource.listMediaTypesRx()
                .doOnNext(new Action1<List<MediaType>>() {
                    @Override
                    public void call(List<MediaType> mediaTypes) {
                        mCachedMediaTypes = mediaTypes;
                    }
                });
    }

    @Override
    public List<MediaType> listMediaTypes() {
        if (mCachedMediaTypes == null) {
            mCachedMediaTypes = mMediaTypesLocalDataSource.listMediaTypes();
        }
        return mCachedMediaTypes;
    }
}

package io.zhuliang.appchooser;

import android.content.Context;

import androidx.annotation.NonNull;

import io.zhuliang.appchooser.data.ActivityInfosRepository;
import io.zhuliang.appchooser.data.MediaTypesRepository;
import io.zhuliang.appchooser.data.ResolveInfosRepository;
import io.zhuliang.appchooser.data.local.ActivityInfosSharedPreferencesDataSource;
import io.zhuliang.appchooser.data.local.MediaTypesLocalDataSource;

/**
 * @author Zhu Liang
 * @version 1.0
 * @since 2017/4/15 下午2:27
 */

public class Injection {

    public static MediaTypesRepository provideMediaTypesRepository(@NonNull Context context) {
        return new MediaTypesRepository(new MediaTypesLocalDataSource(context));
    }

    public static ActivityInfosRepository provideActivityInfosRepository(@NonNull Context context) {
        return new ActivityInfosRepository(new ActivityInfosSharedPreferencesDataSource(context));
    }

    public static ResolveInfosRepository provideResolveInfosRepository(@NonNull Context context) {
        return new ResolveInfosRepository(context);
    }
}

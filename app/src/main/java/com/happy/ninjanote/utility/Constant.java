package com.happy.ninjanote.utility;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ms2 on 2016/07/22.
 */
public class Constant {
    public static final int INVALID = -1;

    /*group stat*/
    public static final int VT_PHOTO_INFO = 1;

    private Constant() {
    }

    @IntDef({VT_PHOTO_INFO
    })
    @Retention(RetentionPolicy.SOURCE)

    public @interface ShowCaseViewType {
    }
    /*group end*/



    public static Bundle addLayoutId(@NonNull final Bundle bundle, final int layoutId) {
        if (layoutId <= 0) {
            return bundle;
        }
        bundle.putInt(KeyValue.LT_NINJA_TASK_ID, layoutId);
        return bundle;
    }

    public static Bundle addLabel(@NonNull final Bundle bundle, final String label) {
        if (label == null || label.isEmpty()) {
            return bundle;
        }
        bundle.putString(KeyValue.LT_NINJA_LABEL, label);
        return bundle;
    }


}

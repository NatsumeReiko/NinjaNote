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
    public static final int V_T_INFO_001 = VT_PHOTO_INFO + 1;

    private Constant() {
    }

    @IntDef({VT_PHOTO_INFO,
            V_T_INFO_001
    })
    @Retention(RetentionPolicy.SOURCE)

    public @interface ShowCaseViewType {
    }
    /*group end*/

    /*header start*/
    public static final int CL_01 = 1;
    public static final int CL_02 = CL_01 + 1;
    public static final int CL_03 = CL_02 + 1;
    public static final int CL_04 = CL_03 + 1;
    public static final int CL_05 = CL_04 + 1;
    public static final int CL_06 = CL_05 + 1;

    @IntDef({CL_01,
            CL_02,
            CL_03,
            CL_04,
            CL_05,
            CL_06
    })
    @Retention(RetentionPolicy.SOURCE)

    public @interface CLIndex {
    }
    /*header end*/


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

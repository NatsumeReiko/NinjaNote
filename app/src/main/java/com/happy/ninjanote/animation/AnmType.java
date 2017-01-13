package com.happy.ninjanote.animation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.happy.ninjanote.animation.AnmType.ANIM_TP_002;
import static com.happy.ninjanote.animation.AnmType.ANIM_TP_010;
import static com.happy.ninjanote.animation.AnmType.ANIM_TP_011;
import static com.happy.ninjanote.animation.AnmType.ANIM_TP_012;

/**
 * Created by Amy.Wu on 12/22/2016.
 */

public class AnmType {
    // FIXME: animation add data

    /**
     * ANIM_TP_001:
     * ANIM_TP_002:
     * ANIM_TP_003:
     * ANIM_TP_004:
     * ANIM_TP_005:
     * ANIM_TP_006:
     */
    public static final int ANIM_TP_001 = 1;
    public static final int ANIM_TP_002 = ANIM_TP_001 + 1;
    public static final int ANIM_TP_003 = ANIM_TP_002 + 1;
    public static final int ANIM_TP_004 = ANIM_TP_003 + 1;
    public static final int ANIM_TP_005 = ANIM_TP_004 + 1;
    public static final int ANIM_TP_006 = ANIM_TP_005 + 1;
    public static final int ANIM_TP_007 = ANIM_TP_006 + 1;
    public static final int ANIM_TP_008 = ANIM_TP_007 + 1;
    public static final int ANIM_TP_009 = ANIM_TP_008 + 1;
    public static final int ANIM_TP_010 = ANIM_TP_009 + 1;
    public static final int ANIM_TP_011 = ANIM_TP_010 + 1;
    public static final int ANIM_TP_012 = ANIM_TP_011 + 1;
    public static final int ANIM_TP_013 = ANIM_TP_012 + 1;
    public static final int ANIM_TP_014 = ANIM_TP_013 + 1;

    @IntDef({
            ANIM_TP_001,
            ANIM_TP_002,
            ANIM_TP_003,
            ANIM_TP_004,
            ANIM_TP_005,
            ANIM_TP_006,
            ANIM_TP_007,
            ANIM_TP_008,
            ANIM_TP_009,
            ANIM_TP_010,
            ANIM_TP_011,
            ANIM_TP_012,
            ANIM_TP_013,
            ANIM_TP_014
    })

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnmTp {
    }

}

package com.happy.ninjanote.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class NinjaBaseActivity extends AppCompatActivity {
    protected static Context appCtx;
    protected static final String KEY_ONE_ITEM_DETAIL = "key_one_item_detail";
    protected static final String KEY_ONE_ITEM = "one_item";

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCtx = this.getApplication();
    }

    protected static void addParameter(Context appCtx, int data, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ONE_ITEM_DETAIL, data);
        bundle.putBoolean(KEY_ONE_ITEM, true);
        intent.putExtras(bundle);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        appCtx.startActivity(intent);
    }


    @Override
    @TargetApi(19)
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (isFullScreenMode()) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }


    protected boolean isFullScreenMode() {
        return false;
    }

}
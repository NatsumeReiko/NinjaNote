package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

abstract class NinjaBaseActivity extends AppCompatActivity {
    protected static Context appCtx;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCtx = this.getApplication();
    }

}
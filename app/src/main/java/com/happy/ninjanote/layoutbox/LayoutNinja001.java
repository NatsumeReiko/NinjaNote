package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.happy.ninjanote.R;
import com.happy.ninjanote.utility.Constant;
import com.happy.ninjanote.utility.KeyValue;

/**
 * LayoutNinja001
 */
public class LayoutNinja001 extends NinjaBaseActivity {
    private int layoutId = -1;
    private String label = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutId();

        setTitle(label);

        try {
            setContentView(layoutId == -1 ? R.layout.layout_empty_001 : layoutId);
        } catch (Exception e) {
            setContentView(R.layout.layout_empty_001);
            Toast.makeText(appCtx, "No such layout", Toast.LENGTH_LONG)
                    .show();
        }

        if (layoutId == R.layout.layout_005_shine_stuff) {
            shineStuff();
        }
    }

    /*R.layout.layout_005_shine_stuff customize*/
    private void shineStuff() {
        final ImageView img = (ImageView) findViewById(R.id.picture);
        if (img != null) {
            ((AnimationDrawable) img.getBackground()).start();
        }

        final ImageView img01 = (ImageView) findViewById(R.id.picture_01);
        if (img01 != null) {
            ((AnimationDrawable) img01.getBackground()).start();
        }


    }

    public void getLayoutId() {
        Intent intentInfo = getIntent();
        if (intentInfo == null) {
            return;
        }

        final Bundle extras = intentInfo.getExtras();
        if (extras == null) {
            return;
        }

        layoutId = extras.getInt(KeyValue.LT_NINJA_TASK_ID, -1);
        label = extras.getString(KeyValue.LT_NINJA_LABEL, "");

    }


    /**
     * launch activity
     *
     * @param appCtx   app context
     * @param layoutId layout ID
     * @param label    title
     */
    public static void launch(final Context appCtx,
                              final int layoutId,
                              final String label) {

        Intent intent = new Intent(appCtx, LayoutNinja001.class);

        Bundle bundle = new Bundle();
        Constant.addLayoutId(bundle, layoutId);
        Constant.addLabel(bundle, label);

        intent.putExtras(bundle);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        appCtx.startActivity(intent);
    }

}
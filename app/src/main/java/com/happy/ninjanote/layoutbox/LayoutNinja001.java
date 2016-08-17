package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

    /*************/
    private ImageView musicTop, musicBody;
    private View musicView;
    private final Animation musicUp = AnimationUtils.loadAnimation(appCtx, R.anim.up_001);
    private final Animation musicDown = AnimationUtils.loadAnimation(appCtx, R.anim.down_001);
    private int count_007_music = 0;
    private static final int MAX_COUNT_007_MUSIC = 7;
    private static final int[] MUSIC_007_PARTS = {
            R.id.set_001, R.id.set_002, R.id.set_003, R.id.set_004,
            R.id.set_005, R.id.set_006, R.id.set_007};

    /*************/

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

        switch (layoutId) {
            case R.layout.layout_005_shine_stuff: {
                shineStuff();
            }
            break;
            case R.layout.layout_007_music: {
                layout_007_music();
            }
            break;
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

    public void layout_007_music() {
        musicUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                musicTop.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                musicTop.startAnimation(musicDown);
                musicBody.startAnimation(musicDown);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        musicDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                musicTop.setVisibility(View.INVISIBLE);
                musicStart();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // none.
            }
        });

        musicStart();
    }

    private void musicStart() {
        if (count_007_music >= MAX_COUNT_007_MUSIC) {
            count_007_music = 0;
        }

        musicView = findViewById(MUSIC_007_PARTS[count_007_music]);
        count_007_music++;
        cleanMusic();
        musicTop = (ImageView) musicView.findViewById(R.id.top);
        musicBody = (ImageView) musicView.findViewById(R.id.body);

        musicTop.startAnimation(musicUp);
        musicBody.startAnimation(musicUp);
    }

    private void cleanMusic() {
        if (musicTop != null) {
            musicTop.clearAnimation();
        }
        if (musicBody != null) {
            musicBody.clearAnimation();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        cleanMusic();
        if (musicUp != null) {
            musicUp.cancel();
        }
        if (musicDown != null) {
            musicDown.cancel();
        }
    }
}
package com.happy.ninjanote.animation;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.happy.ninjanote.R;
import com.happy.ninjanote.base.NinjaBaseActivity;

public class AnimationActivity001 extends NinjaBaseActivity {
    private AnimationShowFg showFg;
    private ViewPager mViewPager;
    private AnmChoosePagerAdapter animaChoosePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation001);

        animaChoosePagerAdapter =
                new AnmChoosePagerAdapter(
                        getSupportFragmentManager(), showAnmLs);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        assert mViewPager != null;
        mViewPager.setAdapter(animaChoosePagerAdapter);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        showFg = AnimationShowFg.newInstance();
        transaction.replace(R.id.container_001, showFg);
        transaction.commit();
    }


    @Override
    protected boolean isFullScreenMode() {
        return true;
    }


    // FIXME: animation add data
    final ShowAnimationIf showAnmLs = new ShowAnimationIf() {
        @Override
        public void shwoAniam(int type, String info) {
            Toast.makeText(appCtx, "TYPE:" + info, Toast.LENGTH_SHORT).show();
            switch (type) {
                case AnmType.ANIM_TP_002:
                case AnmType.ANIM_TP_001: {
                    showFg.showAniamtion(type);
                }
                break;
            }

        }
    };


}

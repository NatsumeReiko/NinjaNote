package com.happy.ninjanote.animation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Amy.Wu on 12/22/2016.
 */
public class AnmChoosePagerAdapter extends FragmentStatePagerAdapter {
    private AnimationChooseFg animationChooseFg;

    public AnmChoosePagerAdapter(FragmentManager fm, ShowAnimationIf showAnimationIf) {
        super(fm);

        animationChooseFg = AnimationChooseFg.newInstance();
        animationChooseFg.setShowAnmLs(showAnimationIf);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: {
                return animationChooseFg;
            }
            case 1: {
                return AnimationShowFg.newInstance();
            }


            default:
                return animationChooseFg;
//                throw new RuntimeException(appCtx.toString()
//                            + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

}

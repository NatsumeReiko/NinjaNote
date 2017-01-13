package com.happy.ninjanote.animation;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.happy.ninjanote.R;

import static com.happy.ninjanote.animation.AnmType.ANIM_TP_001;
import static com.happy.ninjanote.animation.AnmType.ANIM_TP_002;

public class AnimationShowFg extends Fragment {

    private ImageView targetView;
    private Context appCtx;
    private AnimatorSet animtopOut = null;
    private Animation animation;


    public AnimationShowFg() {
    }

    public static AnimationShowFg newInstance() {
        return new AnimationShowFg();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        appCtx = getActivity().getApplicationContext();

        View view = inflater.inflate(R.layout.fragment_animation_show, container, false);
        targetView = (ImageView) view.findViewById(R.id.plus_one_button);
        view.findViewById(R.id.text_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAnimation();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // FIXME: animation add data
    public synchronized void showAniamtion(@AnmType.AnmTp int type) {
        cleanAnimation();

        int anmType = 0;/*0:anim 1:animator*/
        int anmId = -1;

        switch (type) {
            case ANIM_TP_002:
            case ANIM_TP_001: {
                anmId = R.anim.a001_translate_001;
            }
            break;
        }

        if(anmType == 0){
            animation = AnimationUtils.loadAnimation(appCtx, anmId);
        }else {
            animtopOut = (AnimatorSet) AnimatorInflater
                    .loadAnimator(appCtx, anmId);
        }




        if (animtopOut != null) {
            animtopOut.setTarget(targetView);
            animtopOut.start();
            return;
        }
        if (animation != null) {
            switch (type) {
                case ANIM_TP_002:{
                    animation.setInterpolator(new Interpolator() {
                        @Override
                        public float getInterpolation(float input) {
                            return 0;
                        }
                    });

                }
                break;
                case ANIM_TP_001: {
                }
                break;
            }



            targetView.startAnimation(animation);
            return;
        }


    }

    private synchronized void cleanAnimation() {
        targetView.clearAnimation();

        if (animation != null) {
            animation.cancel();
            animation = null;
        }

        if (animtopOut != null) {
            animtopOut.end();
            animtopOut.cancel();
            animtopOut = null;
        }
    }
}

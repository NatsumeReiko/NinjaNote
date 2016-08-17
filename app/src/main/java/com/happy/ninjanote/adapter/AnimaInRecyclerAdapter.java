package com.happy.ninjanote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.PhotoInfoData;
import com.happy.ninjanote.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class AnimaInRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private List<PhotoInfoData> dataList = new ArrayList<>();
    private final Context appCtx;

    /*listener for recycler views */
    private View.OnClickListener itemClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()) {
                case R.id.set_001: {
                    doAnimation(view);
                }
                break;
            }

        }
    };

    private void doAnimation(final View view) {
        final Animation musicUp = AnimationUtils.loadAnimation(appCtx, R.anim.up_002_higher);
        final Animation musicDown = AnimationUtils.loadAnimation(appCtx, R.anim.down_002_higher);
        final ImageView musicTop = (ImageView) view.findViewById(R.id.top);
        final ImageView musicBody = (ImageView) view.findViewById(R.id.body);

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
                musicTop.clearAnimation();
                musicBody.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // none.
            }
        });

        musicTop.startAnimation(musicUp);
        musicBody.startAnimation(musicUp);

    }

    public AnimaInRecyclerAdapter(final Context appContext) {
        this.appCtx = appContext;
        inflater = LayoutInflater.from(appContext);

        makeDataList();
    }

    private void makeDataList() {
        for (int index = 0; index < 100; index++) {
            final PhotoInfoData data = new PhotoInfoData();
            data.info = " aa " + index + " aa ";
            data.picId = R.drawable.undertale_001;

            dataList.add(data);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constant.VT_PHOTO_INFO: {
                return new AnimInRecyclerViewHolder(inflater
                        .inflate(R.layout.layout_animation_recycler_item_001, parent, false));
            }
            default:
                throw new IllegalArgumentException("No Such type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AnimInRecyclerViewHolder) {
            ((AnimInRecyclerViewHolder) holder).bandData(getData(position), itemClicked);
        }
    }

    private PhotoInfoData getData(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).viewType;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}


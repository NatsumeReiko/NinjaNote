package com.happy.ninjanote.animation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.AnimInRecyclerViewHolder;
import com.happy.ninjanote.base.NinjaBaseAdapter001;
import com.happy.ninjanote.data.InfoData001;
import com.happy.ninjanote.utility.Constant;

import java.util.List;

public class AnmChooseAdapter001 extends NinjaBaseAdapter001<InfoData001> {

    private ShowAnimationIf showAnmLs;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InfoData001 data001 = (InfoData001) v.getTag();
            showAnmLs.shwoAniam(data001.infoInt001_01, data001.infoStr001_01);

        }
    };

    public AnmChooseAdapter001(Context appCtx, List<InfoData001> dataList) {
        super(appCtx, dataList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0: {
                return new AnmChooserViewHolder(inflater
                        .inflate(R.layout.animation_chooser_item_001, parent, false));
            }
            default:
                throw new IllegalArgumentException("No Such type");
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AnmChooserViewHolder) {
            ((AnmChooserViewHolder) holder).bandData(getData(position), onClickListener);
        }

    }

    public void setShowAnmLs(ShowAnimationIf showAnmLs) {
        this.showAnmLs = showAnmLs;
    }
}


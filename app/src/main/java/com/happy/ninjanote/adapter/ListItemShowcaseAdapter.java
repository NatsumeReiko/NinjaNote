package com.happy.ninjanote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.ninjanote.layoutbox.ListItemShowcase;

import java.util.List;

public class ListItemShowcaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Integer> layoutId;
    private final Context appCtx;
    private final int itemCount;
    private final int originalDataSize;

    private final int dataType;
    public static final int ONLY_ONE_TYPE = 1;
    public static final int NOT_ONLY_ONE_TYPE = ONLY_ONE_TYPE + 1;
    public static final int NONE_TYPE = 1 + NOT_ONLY_ONE_TYPE;

    /*listener for recycler views */
    private View.OnClickListener itemClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            ListItemShowcase.launch(appCtx, (int) view.getTag());
        }
    };

    public ListItemShowcaseAdapter(final Context appContext, final List<Integer> layoutId) {
        this.appCtx = appContext;
        inflater = LayoutInflater.from(appContext);
        this.layoutId = layoutId;
        if (layoutId == null || layoutId.size() == 0) {
            originalDataSize = itemCount = 0;
            dataType = NONE_TYPE;
        } else if (layoutId.size() == 1) {
            itemCount = 100;
            originalDataSize = 1;
            dataType = ONLY_ONE_TYPE;
        } else {
            originalDataSize = layoutId.size();
            itemCount = originalDataSize * 5;
            dataType = NOT_ONLY_ONE_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = inflater.inflate(viewType, parent, false);
        if (dataType == NOT_ONLY_ONE_TYPE) {
            itemView.setTag(viewType);
            itemView.setOnClickListener(itemClicked);
        }
        return new DoNothingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*do nothing*/
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataType) {
            case NOT_ONLY_ONE_TYPE:
                return layoutId.get(position % originalDataSize);
            default:
                return layoutId.get(0);
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

}


package com.happy.ninjanote.adapter;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.ninjanote.layoutbox.ListItemShowcase;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class ListItemShowcaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Integer> layoutId;
    private final Context appCtx;
    private final int itemCount;
    private final int originalDataSize;

    private final int dataType;
    private static final int ONLY_ONE_TYPE = 1;
    private static final int NOT_ONLY_ONE_TYPE = ONLY_ONE_TYPE + 1;
    private static final int NONE_TYPE = 1 + NOT_ONLY_ONE_TYPE;

    private final int categoryType;
    public static final int LIST_ITEM = 1;
    public static final int ACTIVITY_HEADER = LIST_ITEM + 1;

    @IntDef({LIST_ITEM,
            ACTIVITY_HEADER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CategoryType {
    }

    /*listener for recycler views */
    private View.OnClickListener itemClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            final int tag = (int) view.getTag();
            switch (categoryType) {
                case LIST_ITEM: {
                    ListItemShowcase.launch(appCtx, tag);
                }
                break;
                case ACTIVITY_HEADER: {
                }
                break;
            }
        }
    };

    public ListItemShowcaseAdapter(final Context appContext,
                                   final List<Integer> layoutId,
                                   @CategoryType final int categoryType) {
        this.appCtx = appContext;
        this.categoryType = categoryType;
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


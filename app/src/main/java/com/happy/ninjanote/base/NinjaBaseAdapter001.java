package com.happy.ninjanote.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.happy.ninjanote.data.InfoData001;

import java.util.ArrayList;
import java.util.List;

public abstract class NinjaBaseAdapter001<T extends InfoData001>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final LayoutInflater inflater;
    protected List<T> dataList = new ArrayList<>();
    private int itemCount = 0;


    public NinjaBaseAdapter001(final Context appContext, List<T> original) {
        inflater = LayoutInflater.from(appContext);

        dataList.addAll(original);
        itemCount = dataList.size();

    }

    protected T getData(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getData(position).viewType;
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

}


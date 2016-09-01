package com.happy.ninjanote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.InfoData001;
import com.happy.ninjanote.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public abstract class InfoAdapter001<T extends InfoData001>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater inflater;
    protected List<T> dataList = new ArrayList<>();
    private final Context appCtx;
    private View.OnClickListener itemClicked;
    private int itemCount = 0;


    public InfoAdapter001(final Context appContext, List<T> original) {
        this.appCtx = appContext;
        inflater = LayoutInflater.from(appContext);

        dataList.addAll(original);
        itemCount = dataList.size();

        itemClicked = makeListener();
    }


    @SuppressWarnings("unchecked")
    protected View.OnClickListener makeListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final T data = (T) view.getTag();
                Toast.makeText(appCtx, "clicked:" + data.infoStr001_01, Toast.LENGTH_SHORT)
                        .show();
            }
        };
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constant.V_T_INFO_001: {
                return new Info001ViewHolder(inflater
                        .inflate(R.layout.layout_009_header_001, parent, false));
            }
            default:
                throw new IllegalArgumentException("No Such type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof Info001ViewHolder) {
            ((Info001ViewHolder) holder).bandData(getData(position), itemClicked);
        }
    }

    private T getData(int position) {
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


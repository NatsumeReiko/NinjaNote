package com.happy.ninjanote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.PhotoInfoData;
import com.happy.ninjanote.layoutbox.LayoutNinja001;
import com.happy.ninjanote.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class PhotoInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private List<PhotoInfoData> dataList = new ArrayList<>();
    private final Context appCtx;

    /*listener for recycler views */
    private View.OnClickListener itemClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            final PhotoInfoData data = (PhotoInfoData) view.getTag();

            switch (view.getId()) {
                case R.id.info_pic: {
                    Toast.makeText(appCtx, "info_pic clicked:" + data.info, Toast.LENGTH_SHORT)
                            .show();
                    LayoutNinja001.launch(appCtx, -1, "no layout");
                }
                break;
            }

        }
    };


    public PhotoInfoAdapter(final Context appContext) {
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
                return new PhotoInfoViewHolder(inflater
                        .inflate(R.layout.layout_showcase_item_001, parent, false));
            }
            default:
                throw new IllegalArgumentException("No Such type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof PhotoInfoViewHolder) {
            ((PhotoInfoViewHolder) holder).bandData(getData(position), itemClicked);
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


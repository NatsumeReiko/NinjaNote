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
                    LayoutNinja001.launch(appCtx, data.layoutId, data.info);
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

        final PhotoInfoData data001 = new PhotoInfoData();
        data001.info = " two progressbar loading ";
        data001.picId = R.drawable.undertale_001;
        data001.layoutId = R.layout.layout_001_loading;
        dataList.add(data001);

        final PhotoInfoData data002 = new PhotoInfoData();
        data002.info = " system message ";
        data002.picId = R.drawable.undertale_001;
        data002.layoutId = R.layout.layout_002_system_msg;
        dataList.add(data002);

        final PhotoInfoData data003 = new PhotoInfoData();
        data003.info = " input ";
        data003.picId = R.drawable.undertale_001;
        data003.layoutId = R.layout.layout_003_input_box;
        dataList.add(data003);

        final PhotoInfoData data004 = new PhotoInfoData();
        data004.info = " show a picture ";
        data004.picId = R.drawable.undertale_001;
        data004.layoutId = R.layout.layout_004_show_pic;
        dataList.add(data004);

        final PhotoInfoData data005 = new PhotoInfoData();
        data005.info = " shine stuff ";
        data005.picId = R.drawable.undertale_001;
        data005.layoutId = R.layout.layout_005_shine_stuff;
        dataList.add(data005);

        final PhotoInfoData data006 = new PhotoInfoData();
        data006.info = " round box ";
        data006.picId = R.drawable.undertale_001;
        data006.layoutId = R.layout.layout_006_funny_input_box;
        dataList.add(data006);

        final PhotoInfoData data007 = new PhotoInfoData();
        data007.info = " music dance";
        data007.picId = R.drawable.undertale_001;
        data007.layoutId = R.layout.layout_007_music;
        dataList.add(data007);

        final PhotoInfoData data009 = new PhotoInfoData();
        data009.info = " upload photo video";
        data009.picId = R.drawable.undertale_001;
        data009.layoutId = R.layout.layout_009_upload;
        dataList.add(data009);

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


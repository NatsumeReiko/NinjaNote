package com.happy.ninjanote.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.base.BaseViewHolder;
import com.happy.ninjanote.data.PhotoInfoData;

public class PhotoInfoViewHolder extends BaseViewHolder<PhotoInfoData> {
    final TextView info;
    final ImageView pic;

    public PhotoInfoViewHolder(View itemView) {
        super(itemView);
        pic = (ImageView) itemView.findViewById(R.id.info_pic);
        info = (TextView) itemView.findViewById(R.id.info_text);
    }

    @Override
    public void bandData(final PhotoInfoData data,
                         final View.OnClickListener clickListener) {
        if (data == null) {
            return;
        }
        pic.setTag(data);
        pic.setImageResource(data.picId);
        if (clickListener != null) {
            pic.setOnClickListener(clickListener);
        }

        info.setText(data.info);
    }

}

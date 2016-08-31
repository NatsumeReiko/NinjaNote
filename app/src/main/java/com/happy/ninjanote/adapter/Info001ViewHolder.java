package com.happy.ninjanote.adapter;

import android.view.View;
import android.widget.TextView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.InfoData001;

public class Info001ViewHolder<T extends InfoData001> extends BaseViewHolder<T> {
    protected final View rootView;
    protected final TextView title;

    public Info001ViewHolder(View itemView) {
        super(itemView);
        rootView = itemView;
        title = (TextView) rootView.findViewById(R.id.header_title_text);
    }

    @Override
    public void bandData(final InfoData001 data,
                         final View.OnClickListener clickListener) {
        if (data.infoInt001_01 != -1) {
            rootView.setBackgroundColor(data.infoInt001_01);
        } else {
            rootView.setBackgroundColor(0xff65e15c);
        }
        if (data.infoInt001_02 != -1) {
            title.setTextColor(data.infoInt001_02);
        } else {
            title.setTextColor(0xffffffff);
        }

        rootView.setTag(data);
        if (clickListener != null) {
            rootView.setOnClickListener(clickListener);
        }

        if (data.infoStr001_01 != null) {
            title.setText(data.infoStr001_01);
        }

    }

}

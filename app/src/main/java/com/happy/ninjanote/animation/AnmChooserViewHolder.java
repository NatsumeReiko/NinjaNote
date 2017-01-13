package com.happy.ninjanote.animation;

import android.view.View;
import android.widget.TextView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.base.BaseViewHolder;
import com.happy.ninjanote.data.InfoData001;
import com.happy.ninjanote.data.PhotoInfoData;

import static com.happy.ninjanote.R.id.body;

public class AnmChooserViewHolder extends BaseViewHolder<InfoData001> {
    final TextView text001;

    public AnmChooserViewHolder(View itemView) {
        super(itemView);
        text001 = (TextView) itemView.findViewById(R.id.text_001);

    }

    @Override
    public void bandData(final InfoData001 data,
                         final View.OnClickListener clickListener) {
        assert data != null;

        text001.setTag(data);
        text001.setText(data.infoStr001_01);

        if (clickListener != null) {
            text001.setOnClickListener(clickListener);
        } else {
            text001.setOnClickListener(null);
        }


    }

}

package com.happy.ninjanote.adapter;

import android.view.View;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.PhotoInfoData;

public class AnimInRecyclerViewHolder extends BaseViewHolder<PhotoInfoData> {
    final View animeView;
    final View top;
    final View body;
//    final CardView cardView;

    public AnimInRecyclerViewHolder(View itemView) {
        super(itemView);
        animeView = itemView.findViewById(R.id.set_001);
        (itemView.findViewById(R.id.card_view)).setClipToOutline(false);

        top = itemView.findViewById(R.id.top);
        body = itemView.findViewById(R.id.body);

    }

    @Override
    public void bandData(final PhotoInfoData data,
                         final View.OnClickListener clickListener) {

        top.setVisibility(View.INVISIBLE);
        top.clearAnimation();
        body.clearAnimation();

        if (data == null) {
            return;
        }
        if (clickListener != null) {
            animeView.setOnClickListener(clickListener);
        }
    }

}

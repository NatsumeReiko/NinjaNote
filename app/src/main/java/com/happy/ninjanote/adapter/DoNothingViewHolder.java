package com.happy.ninjanote.adapter;

import android.view.View;

import com.happy.ninjanote.base.BaseViewHolder;

public class DoNothingViewHolder extends BaseViewHolder<Object> {

    public DoNothingViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void bandData(final Object data,
                         final View.OnClickListener clickListener) {
        /*do nothing*/
    }

}

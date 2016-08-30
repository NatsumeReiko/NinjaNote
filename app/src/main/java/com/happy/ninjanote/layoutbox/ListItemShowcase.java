package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.content.Intent;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.ListItemShowcaseAdapter;

/**
 * ListItemShowcase
 */
public class ListItemShowcase extends ListBaseShowcase {

    @Override
    protected void makeDate() {
        dataList.add(R.layout.layout_008_list_item_000);
        dataList.add(R.layout.layout_008_list_item_001);
        dataList.add(R.layout.layout_008_list_item_002);
        dataList.add(R.layout.layout_008_list_item_003);
        dataList.add(R.layout.layout_008_list_item_004);
        dataList.add(R.layout.layout_008_list_item_005);
    }

    @Override
    protected int categoryType() {
        return ListItemShowcaseAdapter.LIST_ITEM;
    }

    public static void launch(final Context appCtx, final int data) {
        addParameter(appCtx, data, new Intent(appCtx, ListItemShowcase.class));
    }
}
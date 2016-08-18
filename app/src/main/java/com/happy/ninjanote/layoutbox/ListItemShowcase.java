package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.ListItemShowcaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ListItemShowcase
 */
public class ListItemShowcase extends NinjaBaseActivity {

    private RecyclerView mRecyclerView;
    private ListItemShowcaseAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private List<Integer> dataList = new ArrayList<>();
    private boolean oneItem = false;
    private static final String KEY_DATALIST = "datalist";
    private static final String KEY_ONE_ITEM = "one_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_showcase001);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        getIntentDate();

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ListItemShowcaseAdapter(appCtx, dataList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void getIntentDate() {
        final Intent intent = getIntent();
        if (intent == null) {
            makeDate();
            return;
        }
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            makeDate();
            return;
        }

        if (oneItem = extras.getBoolean(KEY_ONE_ITEM, false)) {
            dataList.add(extras.getInt(KEY_DATALIST, -1));
        } else {
            makeDate();
        }
    }

    private void makeDate() {
        dataList.add(R.layout.layout_008_list_item_000);
        dataList.add(R.layout.layout_008_list_item_001);
        dataList.add(R.layout.layout_008_list_item_002);
        dataList.add(R.layout.layout_008_list_item_003);
        dataList.add(R.layout.layout_008_list_item_004);
        dataList.add(R.layout.layout_008_list_item_005);
    }

    public static void launch(final Context appCtx, final Integer data) {
        Intent intent = new Intent(appCtx, ListItemShowcase.class);

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_DATALIST, data);
        bundle.putBoolean(KEY_ONE_ITEM, true);
        intent.putExtras(bundle);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        appCtx.startActivity(intent);

    }
}
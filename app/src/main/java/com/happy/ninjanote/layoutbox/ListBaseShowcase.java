package com.happy.ninjanote.layoutbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.ListItemShowcaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class ListBaseShowcase extends NinjaBaseActivity {

    private RecyclerView mRecyclerView;
    private ListItemShowcaseAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    protected List<Integer> dataList = new ArrayList<>();

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

        mAdapter = new ListItemShowcaseAdapter(appCtx, dataList, categoryType());
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

        if (extras.getBoolean(KEY_ONE_ITEM, false)) {
            dataList.add(extras.getInt(KEY_ONE_ITEM_DETAIL, -1));
        } else {
            makeDate();
        }
    }

    protected abstract void makeDate();

    @ListItemShowcaseAdapter.CategoryType
    protected abstract int categoryType();

}
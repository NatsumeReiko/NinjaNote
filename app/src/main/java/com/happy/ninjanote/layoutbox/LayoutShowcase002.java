package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.InfoAdapter001;

/**
 * LayoutShowcase001
 */
public class LayoutShowcase002 extends NinjaBaseActivity {

    protected RecyclerView mRecyclerView;
    protected RecyclerView.Adapter mAdapter;
    protected LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_showcase001);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        makeAdapter();
        mAdapter = makeAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    protected RecyclerView.Adapter makeAdapter() {
        return new InfoAdapter001(appCtx);
    }
}
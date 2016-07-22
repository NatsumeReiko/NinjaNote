package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.PhotoInfoAdapter;

/**
 * LayoutShowcase001
 */
public class LayoutShowcase001 extends NinjaBaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_showcase001);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PhotoInfoAdapter(appCtx);
        mRecyclerView.setAdapter(mAdapter);
    }
}
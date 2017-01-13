package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.AnimaInRecyclerAdapter;
import com.happy.ninjanote.base.NinjaBaseActivity;

/**
 * AnimationInRecycler
 */
public class AnimationInRecycler extends NinjaBaseActivity {

    private RecyclerView mRecyclerView;
    private AnimaInRecyclerAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_showcase001);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AnimaInRecyclerAdapter(appCtx);
        mRecyclerView.setAdapter(mAdapter);
    }
}
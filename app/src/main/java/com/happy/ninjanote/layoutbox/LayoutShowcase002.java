package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.adapter.InfoAdapter002;
import com.happy.ninjanote.base.NinjaBaseActivity;
import com.happy.ninjanote.data.InfoData001;
import com.happy.ninjanote.utility.Constant;

import java.util.ArrayList;
import java.util.List;

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
        List<InfoData001> dataList = new ArrayList<>();
        for (int index = 0xfffcd000; index < 0xfffcd0ff; ) {
            final InfoData001 data = new InfoData001();
            data.infoStr001_01 = "color:0x" + Integer.toHexString(index);
            data.infoInt001_01 = index;
            data.viewType = Constant.V_T_INFO_001;

            index += 20;
            dataList.add(data);

        }

        return new InfoAdapter002(appCtx, dataList);
    }
}
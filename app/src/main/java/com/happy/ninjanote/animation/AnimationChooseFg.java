package com.happy.ninjanote.animation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.ninjanote.R;
import com.happy.ninjanote.data.InfoData001;

import java.util.ArrayList;
import java.util.List;

import static android.R.anim.accelerate_decelerate_interpolator;
import static android.R.anim.anticipate_interpolator;
import static android.R.anim.bounce_interpolator;
import static android.R.anim.decelerate_interpolator;
import static android.R.anim.overshoot_interpolator;
import static android.R.interpolator.accelerate_decelerate;
import static android.R.interpolator.anticipate;
import static android.R.interpolator.bounce;
import static android.R.interpolator.overshoot;

public class AnimationChooseFg extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private AnmChooseAdapter001 mAdapter;
    private Context appCtx;
    private List<InfoData001> data001List;
    private ShowAnimationIf showAnmLs;


    public AnimationChooseFg() {
    }

    public static AnimationChooseFg newInstance() {
        return new AnimationChooseFg();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        appCtx = getContext().getApplicationContext();
        makeData();

        View view = inflater.inflate(R.layout.activity_layout_showcase001, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new AnmChooseAdapter001(appCtx, data001List);
        mAdapter.setShowAnmLs(showAnmLs);

        mLayoutManager = new GridLayoutManager(appCtx, 2);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setShowAnmLs(ShowAnimationIf showAnmLs) {
        this.showAnmLs = showAnmLs;
    }





    private void makeData() {
        data001List = new ArrayList<>(200);

        // FIXME: animation add data
        data001List.add(makeOneData(AnmType.ANIM_TP_001, "Y accelerate_decelerate"));
        data001List.add(makeOneData(AnmType.ANIM_TP_002, "Y accelerate"));
        data001List.add(makeOneData(AnmType.ANIM_TP_003, "Y anticipate"));
        data001List.add(makeOneData(AnmType.ANIM_TP_004, "Y anticipate_overshoot"));
        data001List.add(makeOneData(AnmType.ANIM_TP_005, "Y bounce"));
        data001List.add(makeOneData(AnmType.ANIM_TP_006, "Y cycle"));
        data001List.add(makeOneData(AnmType.ANIM_TP_007, "Y decelerate"));
        data001List.add(makeOneData(AnmType.ANIM_TP_008, "Y linear"));
        data001List.add(makeOneData(AnmType.ANIM_TP_009, "Y overshoot"));

        for (int i = 100; i < 200; i++) {
            data001List.add(makeOneData(i, "No." + i));
        }
    }

    @NonNull
    private InfoData001 makeOneData(int anmTp, String title) {
        InfoData001 data001 = new InfoData001();
        data001.infoStr001_01 = title;
        data001.infoInt001_01 = anmTp;
        data001.viewType = 0;
        return data001;
    }


}

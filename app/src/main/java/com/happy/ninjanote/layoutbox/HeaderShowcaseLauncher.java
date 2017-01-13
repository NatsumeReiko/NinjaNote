package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.happy.ninjanote.R;
import com.happy.ninjanote.base.NinjaBaseActivity;
import com.happy.ninjanote.utility.Constant;

import yuku.ambilwarna.AmbilWarnaDialog;

public class HeaderShowcaseLauncher extends NinjaBaseActivity
        implements View.OnClickListener {
    private static final String TAG_BG = "bg";
    private static final String TAG_TL = "tl";
    private View bgColorPanel, titleColorPanel, sample;
    private int bgColor, titleColor, colorIndex = Constant.CL_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        setContentView(R.layout.activity_header_showcase_launcher);

        bgColor = 0xff65e15c;
        titleColor = 0xffffffff;

        setView();
    }

    private void setView() {
        sample = findViewById(R.id.sample);

        bgColorPanel = findViewById(R.id.bg_color_panel);
        final TextView bg = (TextView) bgColorPanel.findViewById(R.id.color_title);
        bg.setText(R.string.cl_bg_title);
        bg.setOnClickListener(this);
        bg.setTag(TAG_BG);

        titleColorPanel = findViewById(R.id.title_color_panel);
        final TextView tl = (TextView) titleColorPanel.findViewById(R.id.color_title);
        tl.setText(R.string.cl_title);
        tl.setOnClickListener(this);
        tl.setTag(TAG_TL);

        setClTxBg(bgColorPanel, 1, TAG_BG);

        setClTxBg(titleColorPanel, -1, TAG_TL);

        setColorData(true, bgColor);
        setColorData(false, titleColor);
    }

    private void showColorPicker(final int initialColor, final boolean backgroundSet) {
        AmbilWarnaDialog dialog =
                new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {

                        setColorData(backgroundSet, color);
                    }

                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                    }
                });
        dialog.show();
    }

    private void setColorData(final boolean backgroundSet, final int color) {
        if (backgroundSet) {
            bgColor = color;
            sample.setBackgroundColor(bgColor);
            setClTxData(bgColorPanel, color);
        } else {
            titleColor = color;
            ((TextView) sample.findViewById(R.id.header_title_text)).setTextColor(titleColor);
            setClTxData(titleColorPanel, color);
        }
    }

    public void setClTxData(final View viewPanel, final int color) {
        final String colorCode = Integer.toHexString(color);
        ((TextView) viewPanel.findViewById(R.id.cl_03)).setText(colorCode.substring(2, 4));
        ((TextView) viewPanel.findViewById(R.id.cl_02)).setText(colorCode.substring(4, 6));
        ((TextView) viewPanel.findViewById(R.id.cl_01)).setText(colorCode.substring(6));
    }

    public void setClTxBg(View viewPanel, int highlightBgIndex, String bgTag) {
        setClTxtView(highlightBgIndex == 3, bgTag, viewPanel.findViewById(R.id.cl_03));
        setClTxtView(highlightBgIndex == 2, bgTag, viewPanel.findViewById(R.id.cl_02));
        setClTxtView(highlightBgIndex == 1, bgTag, viewPanel.findViewById(R.id.cl_01));
    }

    private void setClTxtView(final boolean highlight, final String tag, final View clView) {
        clView.setBackgroundResource(highlight ?
                R.drawable.bg_corner_8dp_pink_empty : R.drawable.bg_corner_8dp_gray_empty);
        clView.setTag(tag);
        clView.setOnClickListener(null);
        clView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.generate) {
            ListHeaderShowcase.launch(this.getApplication(),
                    bgColor, titleColor, colorIndex);
            return;
        }


        final boolean backgroundSet = TAG_BG.equals(v.getTag());
        if (v.getId() == R.id.color_title) {
            showColorPicker(backgroundSet ? bgColor : titleColor, backgroundSet);
            return;
        }


        final View target;
        final String tag;

        if (backgroundSet) {
            setClTxBg(titleColorPanel, -1, TAG_TL);
            target = bgColorPanel;
            tag = TAG_BG;
        } else {
            setClTxBg(bgColorPanel, -1, TAG_BG);
            target = titleColorPanel;
            tag = TAG_TL;
        }

        switch (v.getId()) {
            case R.id.cl_01: {
                setClTxBg(target, 1, tag);
                colorIndex = (backgroundSet ? Constant.CL_01 : Constant.CL_04);
            }
            break;
            case R.id.cl_02: {
                setClTxBg(target, 2, tag);
                colorIndex = (backgroundSet ? Constant.CL_02 : Constant.CL_05);
            }
            break;
            case R.id.cl_03: {
                setClTxBg(target, 3, tag);
                colorIndex = (backgroundSet ? Constant.CL_03 : Constant.CL_06);
            }
            break;
        }

    }
}
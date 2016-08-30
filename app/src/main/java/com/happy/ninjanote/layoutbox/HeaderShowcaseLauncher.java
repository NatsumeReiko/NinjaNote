package com.happy.ninjanote.layoutbox;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.happy.ninjanote.R;

import yuku.ambilwarna.AmbilWarnaDialog;

public class HeaderShowcaseLauncher extends NinjaBaseActivity
        implements View.OnClickListener {
    private static final String TAG_BG = "bg";
    private static final String TAG_TL = "tl";
    private View bgColorPanel, titleColorPanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_showcase_launcher);

        setView();
    }

    private void setView() {
        bgColorPanel = findViewById(R.id.bg_color_panel);
        final TextView bg = (TextView) bgColorPanel.findViewById(R.id.color_title);
        bg.setText(R.string.cl_bg_title);
        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                    }

                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                    }
                };
                dialog.show();
            }
        });

        titleColorPanel =

                findViewById(R.id.title_color_panel);

        final TextView tl = (TextView) titleColorPanel.findViewById(R.id.color_title);
        tl.setText(R.string.cl_title);

        setClTxBg(bgColorPanel, 1, TAG_BG);

        setClTxBg(titleColorPanel, -1, TAG_TL);
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
        final boolean backgroundSet = TAG_BG.equals(v.getTag());
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
            }
            break;
            case R.id.cl_02: {
                setClTxBg(target, 2, tag);
            }
            break;
            case R.id.cl_03: {
                setClTxBg(target, 3, tag);
            }
            break;

        }

    }
}
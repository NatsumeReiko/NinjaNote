package com.happy.ninjanote.layoutbox;

import android.content.Context;
import android.content.Intent;

public class ListHeaderShowcase extends LayoutShowcase002 {
    public static void launch(final Context appCtx, final int data) {
        addParameter(appCtx, data, new Intent(appCtx, ListHeaderShowcase.class));
    }

}
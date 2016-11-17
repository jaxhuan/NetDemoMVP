package com.skyzone.netdemomvp.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.skyzone.netdemomvp.R;

/**
 * Created by Skyzone on 11/3/2016.
 */
public class dialog_loading extends Dialog {

    public dialog_loading(Context context) {
        super(context, R.style.dialog_loading);
    }

    public dialog_loading(Context context, int themeResId) {
        super(context, R.style.dialog_loading);
    }

    public dialog_loading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
    }
}

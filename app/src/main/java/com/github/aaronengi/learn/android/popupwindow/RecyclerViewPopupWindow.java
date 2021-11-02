package com.github.aaronengi.learn.android.popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.LinearLayoutManager;

import wang.tyrael.learnandroid.databinding.PopupwindowRecyclerviewBinding;
import wang.tyrael.learnandroid.view.recyclerview.SimpleAdapter;

public class RecyclerViewPopupWindow extends PopupWindow {
    PopupwindowRecyclerviewBinding viewBinding;

    SimpleAdapter adapter = new SimpleAdapter();

    RecyclerViewPopupWindow(Context context) {
        viewBinding = PopupwindowRecyclerviewBinding.inflate(LayoutInflater.from(context));
        viewBinding.recycler.setLayoutManager(new LinearLayoutManager(context));
        viewBinding.recycler.setAdapter(adapter);
        adapter.updateCount(5);

//        viewBinding.getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(400);
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(viewBinding.getRoot());
    }
}

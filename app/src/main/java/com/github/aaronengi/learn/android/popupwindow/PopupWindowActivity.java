package com.github.aaronengi.learn.android.popupwindow;

import android.os.Bundle;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import wang.tyrael.learnandroid.databinding.ActivityPopupWindowBinding;
import wang.tyrael.learnandroid.view.recyclerview.SimpleAdapter;

public class PopupWindowActivity extends AppCompatActivity {
    ActivityPopupWindowBinding viewBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityPopupWindowBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewBinding.recyclerviewButton.setOnClickListener(v -> showRecyclerViewWindow());

        SimpleAdapter adapter = new SimpleAdapter();
        viewBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        viewBinding.recycler.setAdapter(adapter);
        adapter.updateCount(5);
    }

    private void showRecyclerViewWindow() {
        PopupWindow popupWindow = new RecyclerViewPopupWindow(this);
        popupWindow.showAsDropDown(viewBinding.recyclerviewButton);
    }
}
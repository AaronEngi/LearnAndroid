package com.github.aaronengi.learn.android.intent;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import wang.tyrael.learnandroid.databinding.ActivityIntentBinding;

public class IntentActivity extends AppCompatActivity {
    private static final String TAG = "IntentActivity";

    private ActivityIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate() called with: intent data = [" + getIntent().getData() + "]");
        //IntentActivity: onCreate() called with: intent data = [https://app.jisilu.cn/down/JisiluLowRisk_5.7.2.apk]
        //chrome edge can not download this url: jump, flash and nothing, why?

    }
}
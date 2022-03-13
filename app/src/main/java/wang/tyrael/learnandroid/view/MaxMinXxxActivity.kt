package wang.tyrael.learnandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import wang.tyrael.learnandroid.databinding.ActivityMaxMinXxxBinding
import wang.tyrael.learnandroid.view.recyclerview.SimpleAdapter

class MaxMinXxxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMaxMinXxxBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        val adapter = SimpleAdapter()
        adapter.updateCount(100)
        viewBinding.listView.adapter = adapter

        viewBinding.rl1.setOnClickListener {
            adapter.updateCount(3)
        }
        viewBinding.rl2.setOnClickListener {
            adapter.updateCount(30)
        }
        viewBinding.rl3.setOnClickListener {
            adapter.updateCount(300)
        }
    }
}
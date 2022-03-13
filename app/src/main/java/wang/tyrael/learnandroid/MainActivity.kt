package wang.tyrael.learnandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.github.aaronengi.learn.android.popupwindow.PopupWindowActivity
import wang.tyrael.learnandroid.databinding.ActivityMainBinding
import wang.tyrael.learnandroid.fragment.LearnDialogFragment
import wang.tyrael.learnandroid.fragment.LearnParentFragment
import wang.tyrael.learnandroid.view.*
import wang.tyrael.learnandroid.view.background.LearnBackgroundActivity
import wang.tyrael.learnandroid.view.edittext.EditTextFocusActivity
import wang.tyrael.learnandroid.view.edittext.NoImeEditTextActivity
import wang.tyrael.learnandroid.view.layout.*
import wang.tyrael.learnandroid.view.recyclerview.RecyclerViewGridLayoutActivity
import wang.tyrael.learnandroid.view.systemalert.LearnSystemAlertActivity
import wang.tyrael.learnandroid.view.toast.ToastActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        findViewById<View>(R.id.bn_storagefiller).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    StorageFillerActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.bn_listview).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ListViewActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.bn_dialog_fragment).setOnClickListener {
            val dialogFragment: DialogFragment = LearnDialogFragment()
            dialogFragment.show(supportFragmentManager, "LearnDialogFragment")
        }

        binding.learnParentFragmentButton.setOnClickListener {
            LearnParentFragment().show(supportFragmentManager, "")
        }

        findViewById<View>(R.id.bn_grid_view).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    RecyclerViewGridLayoutActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.bn_image_view).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ImageViewActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.bn_grid_layout).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    GridLayoutActivity::class.java
                )
            )
        }
        setStartActivityListener(R.id.bn_toast, ToastActivity::class.java)
        setStartActivityListener(R.id.bn_system_alert, LearnSystemAlertActivity::class.java)
        setStartActivityListener(R.id.bn_constraintlayout, ConstraintLayoutActivity::class.java)
        setStartActivityListener(R.id.bn_relative_layout, RelativeLayoutActivity::class.java)
        setStartActivityListener(R.id.bn_edittext, NoImeEditTextActivity::class.java)
        setStartActivityListener(R.id.bn_textview, TextViewActivity::class.java)
        setStartActivityListener(R.id.bn_background, LearnBackgroundActivity::class.java)
        setStartActivityListener(binding.minXxxBn, MaxMinXxxActivity::class.java)
        setStartActivityListener(binding.tableLayoutButton, TableLayoutActivity::class.java)
        setStartActivityListener(binding.viewVisibilityBn, ViewVisibilityActivity::class.java)
        setStartActivityListener(binding.viewVisibilityBn, LinearLayoutActivity::class.java)
        setStartActivityListener(binding.popupwindowButton, PopupWindowActivity::class.java)
        setStartActivityListener(binding.viewAlphaButton, ViewAlphaActivity::class.java)
        setStartActivityListener(binding.editTextFocusButton, EditTextFocusActivity::class.java)
    }

    private fun setStartActivityListener(view: View, activityToStart: Class<out Activity?>) {
        view.setOnClickListener { startActivity(Intent(this@MainActivity, activityToStart)) }
    }

    private fun setStartActivityListener(viewId: Int, activityToStart: Class<out Activity?>) {
        findViewById<View>(viewId).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    activityToStart
                )
            )
        }
    }
}
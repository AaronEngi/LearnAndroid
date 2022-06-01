package learn.view.constraintlayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import wang.tyrael.learnandroid.databinding.ActivityClGroupBinding

class CLGroupActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityClGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityClGroupBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.groupSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewBinding.group.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        viewBinding.buttonSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            viewBinding.dynamicButton.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

    }
}
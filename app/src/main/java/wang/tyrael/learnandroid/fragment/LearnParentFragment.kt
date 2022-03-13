package wang.tyrael.learnandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import wang.tyrael.learnandroid.databinding.FragmentLearnParentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LearnParentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearnParentFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewBinding: FragmentLearnParentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentLearnParentBinding.inflate(layoutInflater, container, false)

        viewBinding.level.text = "level ${computeLevel()}"

        viewBinding.openChild.setOnClickListener {
            LearnParentFragment().show(childFragmentManager, "")
        }

        viewBinding.closeLevel1.setOnClickListener {
            closeLevel1()
        }

        viewBinding.closeLevel2.setOnClickListener {
            closeLevel2()
        }

        viewBinding.test.setOnClickListener {
            closeLevel2()
            closeLevel1()
        }

        return viewBinding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.w("TTag", TAG + " " + "onSaveInstanceState() called with: $this")
        super.onSaveInstanceState(outState)
        dismiss()
    }

    override fun onPause() {
        //todo remove this before commit
        Log.w("TTag", TAG + " " + "onPause() called: $this")
        super.onPause()
    }

    override fun onStop() {
        //todo remove this before commit
        Log.w("TTag", TAG + " " + "onStop() called: $this")
        super.onStop()
    }

    private fun closeLevel1() {
        val parent: DialogFragment = parentFragment as DialogFragment
        parent.dismiss()
        //todo remove this before commit
        Log.w("TTag", TAG + " " + "closeLevel1() called")
    }

    private fun closeLevel2() {
        val parent2: DialogFragment = parentFragment?.parentFragment as DialogFragment
        parent2.dismiss()
        //todo remove this before commit
        Log.w("TTag", TAG + " " + "closeLevel2() called")
    }

    private fun computeLevel(): Int {
        var count = 0
        var current = parentFragment
        while (current != null) {
            count++
            current = current.parentFragment
        }
        return count
    }

    companion object {
        const val TAG = "LearnParentF"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LearnParentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LearnParentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
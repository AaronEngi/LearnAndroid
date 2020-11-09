package wang.tyrael.learnandroid.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LearnDialogFragment extends DialogFragment {
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onCreateDialog() called with: savedInstanceState = [" + savedInstanceState + "]");
//        return super.onCreateDialog(savedInstanceState);
        return new AlertDialog.Builder(context).setTitle("LearnDailog").create();
    }

    @Override
    public void onPause() {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onPause() called");
        super.onPause();
    }

    @Override
    public void onStop() {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onStop() called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onDestroyView() called");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        //todo remove before commit
        Log.i("tyraelTag", "" + this + " " + "onDismiss() called with: dialog = [" + dialog + "]");
        super.onDismiss(dialog);
    }

    //
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView textView = new TextView(inflater.getContext());
//        textView.setText("LearnDialogFragment");
//        return textView;
//    }
}

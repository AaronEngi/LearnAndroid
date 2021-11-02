package wang.tyrael.learnandroid.view.recyclerview;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private int itemCount;

    @SuppressLint("NotifyDataSetChanged")
    public void updateCount(int count) {
        itemCount = count;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleViewHolder(new TextView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        TextView tvPosition = (TextView) holder.itemView;
        tvPosition.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}

package wang.tyrael.learnandroid.view.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wang.tyrael.learnandroid.R;

public class RecyclerViewGridLayoutActivity extends AppCompatActivity {
    GridLayoutManager gridLayoutManager = new GridLayoutManager(RecyclerViewGridLayoutActivity.this, 2);
    int itemCount;
    RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SimpleViewHolder(new TextView(parent.getContext())) ;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            TextView tvPosition = (TextView) holder.itemView;
            tvPosition.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return itemCount;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        findViewById(R.id.bn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = 3;
                gridLayoutManager.setSpanCount(3);
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.bn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = 4;
                gridLayoutManager.setSpanCount(2);
                adapter.notifyDataSetChanged();
            }
        });

    }
}

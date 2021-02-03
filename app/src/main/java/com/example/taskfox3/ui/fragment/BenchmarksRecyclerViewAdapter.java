package com.example.taskfox3.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;

import java.util.ArrayList;
import java.util.List;

public class BenchmarksRecyclerViewAdapter extends RecyclerView.Adapter<BenchmarksRecyclerViewAdapter.BenchmarkViewHolder> {

    private final List<BenchmarkItem> items = new ArrayList<>();

    public BenchmarksRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public BenchmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_for_tab, parent, false);
        return new BenchmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BenchmarkViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() { //odpowiada za illość elementów
        return items.size();
    }


    public void setItems(List<BenchmarkItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }


    public static class BenchmarkViewHolder extends RecyclerView.ViewHolder {
        private final TextView operationName;
        private final TextView operationTime;
        private final ProgressBar progressBar;

        public BenchmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            operationName = itemView.findViewById(R.id.tv_name_operation);
            operationTime = itemView.findViewById(R.id.tv_time_operation);
            progressBar = itemView.findViewById(R.id.progressBar);
        }

        public void bindItem(BenchmarkItem benchmarkItem) {
            operationName.setText(benchmarkItem.getTaskName());
            operationTime.setText(String.valueOf(benchmarkItem.getMeasuredTime()));
            //operationName.setText(benchmarkItem.getNameOfOperation());

        }
    }
}

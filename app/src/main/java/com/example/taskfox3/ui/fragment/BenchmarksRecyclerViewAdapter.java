package com.example.taskfox3.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.DataTable;

import java.util.List;

public class BenchmarksRecyclerViewAdapter extends RecyclerView.Adapter<BenchmarksRecyclerViewAdapter.BenchmarkViewHolder> {
    
    private final List<DataTable> dataTableList =  new ArrayList<>();

    public BenchmarksRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public BenchmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_for_tab,parent,false);
        return new BenchmarkViewHolder(view);
        //ponieważ View komponenty zostaną ponownie wykorzystane w tym samym elemencie wizualnym
        //w trakcie życia listy różne dane zostaną ustawione
    }

    @Override
    public void onBindViewHolder(@NonNull BenchmarkViewHolder holder, int position) {
        holder.operationName.setText(dataTableList.get(position).getNameOfOperation());
        holder.operationTime.setText(dataTableList.get(position).getTimeOfOperation() );
      //  holder.progressBar.setProgress(dataTableList.get(position).progressBar);//??
        // odpowiada za relację między java a obiektem View
    }

    @Override
    public int getItemCount() { //odpowiada za illość elementów
        return dataTableList.size();
    }

    public void setItems(List<DataTable> items) {
        dataTableList.clear();
        dataTableList.addAll(items);
        notifyDataSetChanged();
    }

    public class BenchmarkViewHolder extends RecyclerView.ViewHolder {
        private final TextView operationName;
        private final TextView operationTime;
        private final ProgressBar progressBar;

        public BenchmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            operationName = itemView.findViewById(R.id.tv_name_operation);
            operationTime = itemView.findViewById(R.id.tv_time_operation);
            progressBar = itemView.findViewById(R.id.progressBar);
            //in BenchmarkViewHolder create method bintItem(items.get(0)) and use it ---- ??
        }
    }
}
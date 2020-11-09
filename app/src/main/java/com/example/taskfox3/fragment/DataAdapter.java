package com.example.taskfox3.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.AdapterViewHolder> {
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView operationName;
        private TextView operationTime;
        private ProgressBar progressBar;



        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            operationName = itemView.findViewById(R.id.tv_name_operation);
            operationTime = itemView.findViewById(R.id.tv_time_operation);
            progressBar = itemView.findViewById(R.id.progressBar);

            //in AdapterViewHolder create method bintItem(items.get(0)) and use it ---- ??
        }


    }
    //--------->

    List<DataTable> dataTableList;

    public DataAdapter(List<DataTable> dataTableList) {
        this.dataTableList = dataTableList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_for_tab,parent,false);
        return new AdapterViewHolder(view);
        //ponieważ View komponenty zostaną ponownie wykorzystane w tym samym elemencie wizualnym
        //w trakcie życia listy różne dane zostaną ustawione
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.operationName.setText(dataTableList.get(position).getNameOfOperation());
        holder.operationTime.setText(dataTableList.get(position).getTimeOfOperation() );


      //  holder.progressBar.setProgress(dataTableList.get(position).progressBar);//??
        // odpowiada za relację między java a obiektem View
    }

    @Override
    public int getItemCount() { //odpowiada za illość elementów
        return dataTableList.size();
    }


}

package com.example.rma_1_alma_kuduzovic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FirstTableAdapter extends RecyclerView.Adapter<FirstTableAdapter.ViewHolder> {

    private final List<String> column1Data;
    private final List<String> column2Data;

    public FirstTableAdapter(List<String> column1Data, List<String> column2Data) {
        this.column1Data = column1Data;
        this.column2Data = column2Data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.column1TextView.setText(column1Data.get(position));
        holder.column2TextView.setText(column2Data.get(position));
    }

    @Override
    public int getItemCount() {
        return column1Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView column1TextView;
        TextView column2TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            column1TextView = itemView.findViewById(R.id.column1TextView);
            column2TextView = itemView.findViewById(R.id.column2TextView);
        }
    }
}

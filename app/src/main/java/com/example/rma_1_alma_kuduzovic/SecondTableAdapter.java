package com.example.rma_1_alma_kuduzovic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondTableAdapter extends RecyclerView.Adapter<SecondTableAdapter.ViewHolder> {

    private static boolean useOunces;
    private final List<TemporaryData> temporaryDataList;

    public SecondTableAdapter(List<TemporaryData> temporaryDataList, boolean useOunces) {
        this.temporaryDataList = temporaryDataList;
        SecondTableAdapter.useOunces = useOunces;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TemporaryData temporaryData = temporaryDataList.get(position);
        holder.bind(temporaryData);
    }

    @Override
    public int getItemCount() {
        return temporaryDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView column1TextView;
        TextView column2TextView;
        TextView column3TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            column1TextView = itemView.findViewById(R.id.column1TextView);
            column2TextView = itemView.findViewById(R.id.column2TextView);
            column3TextView = itemView.findViewById(R.id.column3TextView);
        }

        public void bind(TemporaryData temporaryData) {

            column1TextView.setText(temporaryData.getTitle());
            column2TextView.setText(formatQuantity(temporaryData.getTotalquantity()));
            column3TextView.setText(temporaryData.getPrecent() + "%");
        }

        private String formatQuantity(double quantity) {

            String suffix = useOunces ? "oz" : "g";
            return quantity + suffix;
        }
    }
}

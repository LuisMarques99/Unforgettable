package com.example.unforgettable.ui.medicines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unforgettable.R;
import com.example.unforgettable.entities.Medicine;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private Context context;
    private List<Medicine> medicines;
    private OnMedicineListener onMedicineListener;

    public MedicineAdapter(Context context, List<Medicine> medicines, OnMedicineListener onMedicineListener) {
        this.context = context;
        this.medicines = medicines;
        this.onMedicineListener = onMedicineListener;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate layout
        View medicineView = inflater.inflate(R.layout.item_medicine, parent, false);

        // Return a new holder instance
        return new MedicineViewHolder(medicineView, onMedicineListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Medicine medicine = medicines.get(position);

        // Set name
        TextView textView = viewHolder.medicineInfo;
        textView.setText(medicine.getName());
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView medicineInfo;
        OnMedicineListener onMedicineListener;

        public MedicineViewHolder(@NonNull View itemView, OnMedicineListener onMedicineListener) {
            super(itemView);

            medicineInfo = itemView.findViewById(R.id.view_medicine_info);
            this.onMedicineListener = onMedicineListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onMedicineListener.onMedicineClick(getAdapterPosition());
        }
    }

    public interface OnMedicineListener {
        void onMedicineClick(int position);
    }
}

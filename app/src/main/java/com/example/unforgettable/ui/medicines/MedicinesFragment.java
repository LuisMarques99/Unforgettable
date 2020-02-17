package com.example.unforgettable.ui.medicines;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unforgettable.R;
import com.example.unforgettable.entities.Medicine;
import com.example.unforgettable.room.Database;

import java.util.ArrayList;
import java.util.List;

public class MedicinesFragment extends Fragment implements MedicineAdapter.OnMedicineListener, View.OnClickListener {

    private RecyclerView medicinesRecycler;
    private MedicineAdapter medicineAdapter;
    private List<Medicine> medicines;
    private Database database;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_medicines, container, false);

        root.findViewById(R.id.fab_add_medicine).setOnClickListener(this);

        // Initialize the database
        database = new Database(this.getContext());

        // Set medicines list
        medicines = new ArrayList<>();

        // Set medicine adapter
        medicineAdapter = new MedicineAdapter(this.getContext(), medicines, this);

        // Set recycler view
        medicinesRecycler = root.findViewById(R.id.recycler_view_medicines);
        medicinesRecycler.setAdapter(medicineAdapter);

        // Set layout manager
        medicinesRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Swipe
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(medicinesRecycler);

        retrieveMedicines();

        return root;
    }

    @Override
    public void onMedicineClick(int position) {
        Intent intent = new Intent(getContext(), MedicineViewActivity.class);
        intent.putExtra("Medicine", medicines.get(position));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), MedicineViewActivity.class);
        startActivity(intent);
    }

    private void retrieveMedicines() {
        database.retrieveMedicineTask().observe(this, new Observer<List<Medicine>>() {
            @Override
            public void onChanged(List<Medicine> meds) {
                if (medicines.size() > 0) {
                    medicines.clear();
                }
                if (medicines != null) {
                    medicines.addAll(meds);
                }
                medicineAdapter.notifyDataSetChanged();
            }
        });
    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallback =
            new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView,
                                      @NonNull RecyclerView.ViewHolder viewHolder,
                                      @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    deleteMedicine(medicines.get(viewHolder.getAdapterPosition()));
                }
            };

    private void deleteMedicine(Medicine medicine) {
        medicines.remove(medicine);
        medicineAdapter.notifyDataSetChanged();
        database.deleteMedicine(medicine);
    }

}
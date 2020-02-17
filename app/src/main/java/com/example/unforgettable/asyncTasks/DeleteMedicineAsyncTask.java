package com.example.unforgettable.asyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.unforgettable.entities.Medicine;
import com.example.unforgettable.room.MedicineDAO;

public class DeleteMedicineAsyncTask extends AsyncTask<Medicine, Void, Void> {

    private static final String TAG = "DeleteMedicineAsyncTask";

    private MedicineDAO medicineDAO;

    public DeleteMedicineAsyncTask(MedicineDAO medicineDAO) {
        this.medicineDAO = medicineDAO;
    }

    @Override
    protected Void doInBackground(Medicine... medicines) {
        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());
        medicineDAO.deleteMedicine(medicines);
        return null;
    }
}

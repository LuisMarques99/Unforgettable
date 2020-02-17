package com.example.unforgettable.room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.unforgettable.asyncTasks.DeleteMedicineAsyncTask;
import com.example.unforgettable.asyncTasks.DeleteUserAsyncTask;
import com.example.unforgettable.asyncTasks.InsertMedicineAsyncTask;
import com.example.unforgettable.asyncTasks.InsertUserAsyncTask;
import com.example.unforgettable.asyncTasks.UpdateMedicineAsyncTask;
import com.example.unforgettable.asyncTasks.UpdateUserAsyncTask;
import com.example.unforgettable.entities.Medicine;
import com.example.unforgettable.entities.User;

import java.util.List;

public class Database {
    private MedicinesDatabase medicinesDatabase;
    private UsersDatabase usersDatabase;

    public Database(Context context) {
        medicinesDatabase = MedicinesDatabase.getInstance(context);
        usersDatabase = UsersDatabase.getInstance(context);
    }

    public void insertMedicine(Medicine medicine) {
        new InsertMedicineAsyncTask(medicinesDatabase.medicineDAO()).execute(medicine);
    }

    public void insertUser(User user) {
        new InsertUserAsyncTask(usersDatabase.userDAO()).execute(user);
    }

    public void updateMedicine(Medicine medicine) {
        new UpdateMedicineAsyncTask(medicinesDatabase.medicineDAO()).execute(medicine);
    }

    public void updateUser(User user) {
        new UpdateUserAsyncTask(usersDatabase.userDAO()).execute(user);
    }

    public void deleteMedicine(Medicine medicine) {
        new DeleteMedicineAsyncTask(medicinesDatabase.medicineDAO()).execute(medicine);
    }

    public void deleteUser(User user) {
        new DeleteUserAsyncTask(usersDatabase.userDAO()).execute(user);
    }

    public LiveData<List<Medicine>> retrieveMedicineTask() {
        return medicinesDatabase.medicineDAO().getAllMedicines();
    }

    public LiveData<List<User>> retrieveUserTask() {
        return usersDatabase.userDAO().getAllUsers();
    }
}

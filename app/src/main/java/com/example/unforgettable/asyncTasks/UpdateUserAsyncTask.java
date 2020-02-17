package com.example.unforgettable.asyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.unforgettable.entities.User;
import com.example.unforgettable.room.UserDAO;

public class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {

    private static final String TAG = "UpdateUserAsyncTask";

    private UserDAO userDAO;

    public UpdateUserAsyncTask(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    protected Void doInBackground(User... users) {
        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());
        userDAO.insertUser(users);
        return null;
    }
}

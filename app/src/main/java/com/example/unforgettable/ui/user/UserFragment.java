package com.example.unforgettable.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.unforgettable.R;
import com.example.unforgettable.entities.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserFragment extends Fragment {

    private Context context;
    private User user;
    private Intent userIntent;
    private FloatingActionButton editButton;
    private TextView viewName, viewAge, viewGender, viewSosContact;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_user, container, false);

        context = this.getContext();

        user = new User();

        viewName = root.findViewById(R.id.view_name);
        viewAge = root.findViewById(R.id.view_age);
        viewSosContact = root.findViewById(R.id.view_sosContact);

        editButton = root.findViewById(R.id.fab_edit_profile);

        userIntent = new Intent(context, UserEdit.class);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Editar informaçoes", Toast.LENGTH_SHORT).show();
                startActivity(userIntent);
            }
        });

        return root;
    }
}
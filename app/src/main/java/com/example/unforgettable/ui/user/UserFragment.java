package com.example.unforgettable.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.unforgettable.R;
import com.example.unforgettable.entities.User;
import com.example.unforgettable.room.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserFragment extends Fragment {

    //private Database database;
    private User user;
    private FloatingActionButton editButton;
    private TextView viewName, viewAge, viewGender, viewSosContact;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_user, container, false);

        editButton = root.findViewById(R.id.fab_edit_profile);

        //database = new Database(this.getContext());

        user = (User) getActivity().getIntent().getSerializableExtra("UserEdit");

        viewName = root.findViewById(R.id.view_name);
        viewAge = root.findViewById(R.id.view_age);
        viewGender = root.findViewById(R.id.view_gender);
        viewSosContact = root.findViewById(R.id.view_sosContact);

        viewName.setText(user.getName());
        viewAge.setText(user.getAge());
        viewGender.setText(user.getGender());
        viewSosContact.setText(user.getSosContact());

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Editar informaçoes", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), UserEditActivity.class);
                intent.putExtra("UserInfo", user);
                startActivity(intent);
            }
        });

        return root;
    }
}
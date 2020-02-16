package com.example.unforgettable.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.unforgettable.MainActivity;
import com.example.unforgettable.R;
import com.example.unforgettable.entities.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserEdit extends AppCompatActivity {

    private User user;
    private Intent userIntent;
    private FloatingActionButton confirmButton;
    private EditText editName, editAge, editSosContact;
    private Spinner editGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Editar Perfil");

        user = new User();

        editName = findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editSosContact = findViewById(R.id.edit_sosContact);

        // Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.gender_values,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editGender = findViewById(R.id.spinner_edit_gender);
        editGender.setAdapter(adapter);

        confirmButton = findViewById(R.id.fab_confirm_profile);

        userIntent = new Intent(this, MainActivity.class);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(editName.getText().toString());
                user.setAge(editAge.getText().toString());
                /*try {
                    user.setSosContact(new Contact(editSosContact.getText().toString()));
                } catch (InvalidContactException e) {
                    Toast.makeText(getApplicationContext(), "Contacto Invalido",
                            Toast.LENGTH_SHORT);
                }*/

                startActivity(userIntent);
            }
        });
    }
}

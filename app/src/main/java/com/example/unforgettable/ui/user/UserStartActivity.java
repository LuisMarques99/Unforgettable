package com.example.unforgettable.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unforgettable.MainActivity;
import com.example.unforgettable.R;
import com.example.unforgettable.entities.User;
import com.example.unforgettable.exceptions.InvalidContactException;
import com.example.unforgettable.room.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserStartActivity extends AppCompatActivity {

    private User user;
    private EditText editName, editAge, editSosContact;
    private Spinner editGenderSpinner;
    private FloatingActionButton confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        confirmButton = findViewById(R.id.fab_confirm_profile);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Definir utilizador");

        editName = findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editSosContact = findViewById(R.id.edit_sosContact);

        // Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.gender_values,
                R.layout.item_gender_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editGenderSpinner = findViewById(R.id.spinner_edit_gender);
        editGenderSpinner.setAdapter(adapter);

        user = new User();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editName.getText().toString().isEmpty() && !editAge.getText().toString().isEmpty()
                        && !editGenderSpinner.toString().isEmpty() && !editSosContact.getText().toString().isEmpty()) {
                    user.setName(editName.getText().toString());
                    user.setAge(editAge.getText().toString());
                    user.setGender(editGenderSpinner.getSelectedItem().toString());
                    try {
                        user.setSosContact(editSosContact.getText().toString());
                    } catch (InvalidContactException e) {
                        Toast.makeText(getApplicationContext(), "Por favor introduza um" +
                                " contacto válido", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(getApplicationContext(), "Utilizador definido com sucesso!",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("UserEdit", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Utilizador não definido! Por favor" +
                            " tente novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

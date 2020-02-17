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

public class UserEditActivity extends AppCompatActivity {

    private Database database;
    private User user;
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

        user = (User) getIntent().getSerializableExtra("UserInfo");

        editName = findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editSosContact = findViewById(R.id.edit_sosContact);

        editName.setText(user.getName());
        editAge.setText(user.getAge());
        editSosContact.setText(user.getSosContact());

        // Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.gender_values,
                R.layout.item_gender_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editGender = findViewById(R.id.spinner_edit_gender);
        editGender.setAdapter(adapter);

        confirmButton = findViewById(R.id.fab_confirm_profile);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(editName.getText().toString());
                user.setAge(editAge.getText().toString());
                user.setGender(editGender.getSelectedItem().toString());
                try {
                    user.setSosContact(editSosContact.getText().toString());
                } catch (InvalidContactException e) {
                    Log.d("Invalid Contact", "Conacto Inválido");
                }

                Toast.makeText(getApplicationContext(), "Utilizador atualizado com sucesso!",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("UserEdit", user);
                startActivity(intent);
            }
        });
    }
}

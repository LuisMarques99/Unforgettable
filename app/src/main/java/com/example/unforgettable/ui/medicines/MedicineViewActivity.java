package com.example.unforgettable.ui.medicines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unforgettable.MainActivity;
import com.example.unforgettable.R;
import com.example.unforgettable.entities.Medicine;
import com.example.unforgettable.room.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicineViewActivity extends AppCompatActivity {

    private Medicine medicine;
    private EditText editName, editDescription;
    private FloatingActionButton confirmButton;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_view);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Adicionar medicamento");

        database = new Database(this);

        editName = findViewById(R.id.edit_medicine_name);
        editDescription = findViewById(R.id.edit_medicine_description);

        confirmButton = findViewById(R.id.fab_confirm_medicine);

        final Intent intent = new Intent(this, MainActivity.class);

        if (getIntent().hasExtra("Medicine")) {
            medicine = (Medicine) getIntent().getSerializableExtra("Medicine");
            editName.setText(medicine.getName());
            editDescription.setText(medicine.getDescription());

            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!editName.getText().toString().isEmpty()) {
                        medicine.setName(editName.getText().toString());
                        medicine.setDescription(editDescription.getText().toString());

                        database.updateMedicine(medicine);

                        Toast.makeText(getApplicationContext(), "Medicamento atualizado",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Medicamento não atualizado!\n" +
                                "Por favor introduza um nome para o medicamento", Toast.LENGTH_LONG).show();
                    }

                    startActivity(intent);
                }
            });
        } else {
            medicine = new Medicine();

            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!editName.getText().toString().isEmpty()) {
                        medicine.setName(editName.getText().toString());
                        medicine.setDescription(editDescription.getText().toString());

                        database.insertMedicine(medicine);

                        Toast.makeText(getApplicationContext(), "Medicamento introduzido",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Medicamento não introduzido!\n" +
                                "Por favor introduza um nome para o medicamento", Toast.LENGTH_LONG).show();
                    }

                    startActivity(intent);
                }
            });
        }
    }
}

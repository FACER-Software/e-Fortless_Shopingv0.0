package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pagos extends AppCompatActivity {

    Button pag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        pag = findViewById(R.id.Registro);
        pag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pagos.this, "Registro Exitoso", Toast.LENGTH_LONG ).show();
            }
        });
    }
}
package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Nutri extends AppCompatActivity {

    Button nutri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutri);

        nutri = findViewById(R.id.Registro);
        nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Nutri.this, "Registro Exitoso", Toast.LENGTH_LONG ).show();
            }
        });
    }
}
package mx.ipn.e_fortlessshoping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button inicio, registro;
    EditText Correo,Contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Correo = findViewById(R.id.Correo);
        Contrasena = findViewById(R.id.Contrasena);

        inicio = (Button) findViewById(R.id.Inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Bienvenido 1", Toast.LENGTH_LONG ).show();
                //TODO codigo de inicio de sesion
                String Corr, Contra;
                Corr = Correo.getText().toString();
                Contra = Contrasena.getText().toString();

                if(Corr.equals("1") && Contra.equals("1"))
                    startActivity(new Intent(Login.this, Princi.class));
            }
        });

        registro = (Button) findViewById(R.id.Registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
                finish();
            }
        });

    }
}

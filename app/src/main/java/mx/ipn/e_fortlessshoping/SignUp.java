package mx.ipn.e_fortlessshoping;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    Button inicio, registro, crear;
    EditText Correo, Nombre, ApPat, ApMat, Pass1, Pass2, Muni;
    RadioButton Masc, Fem;
    RadioGroup Marrano;
    int Edad;

    String Sexo;

    EditText fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Correo = findViewById(R.id.Correo);
        Nombre = findViewById(R.id.Nombre);
        ApPat = findViewById(R.id.ApPat);
        ApMat = findViewById(R.id.ApMat);
        Pass1 = findViewById(R.id.Contrasena);
        Pass2 = findViewById(R.id.Contrasena2);
        Muni = findViewById(R.id.Muni);

        Masc = findViewById(R.id.Masculino);
        Fem = findViewById(R.id.Femenino);


        Marrano = findViewById(R.id.GrupoMarrano);


        inicio = (Button) findViewById(R.id.Inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, Login.class));
                finish();
            }
        });

        registro = (Button) findViewById(R.id.Registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Correo.getText().toString().isEmpty() ||
                        Nombre.getText().toString().isEmpty() ||
                        ApPat.getText().toString().isEmpty() ||
                        ApMat.getText().toString().isEmpty() ||
                        fecha.getText().toString().isEmpty() ||
                        Pass1.getText().toString().isEmpty() ||
                        Pass2.getText().toString().isEmpty() ||
                        Muni.getText().toString().isEmpty() ||
                        Marrano.getCheckedRadioButtonId() == -1) {
                    Snackbar.make(v, "Por favor rellene todos los campos", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {

                    if (!Pass1.getText().toString().equals(Pass2.getText().toString())) {
                        String uno = Pass1.getText().toString();
                        String dos = Pass2.getText().toString();

                        //Toast.makeText(getApplicationContext(), uno + ", " + dos, Toast.LENGTH_LONG).show();
                        Snackbar.make(v, "Las contraseñas no coinciden", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {

                        if (Masc.isChecked()) {
                            Sexo = "Masculino";
                        }
                        if (Fem.isChecked()) {
                            Sexo = "Femenino";
                        }

                        EjecServ("https://facersoft.com.mx/api/alta.php");
                    }
                }
            }
        });

        fecha = findViewById(R.id.FecNac);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.FecNac:
                        showDatePickerDialog(fecha);
                        break;
                }
            }
        });

        //ftp://facer@services.nirbby.com/apache/alta.php

    }

    private String twoDigits(int n) {
        return (n <= 9) ? ("0" + n) : String.valueOf(n);
    }

    private void showDatePickerDialog(EditText fecha) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = year + "-" + twoDigits(month + 1) + "-" + twoDigits(day);
                Edad = 2020 - year;
                SignUp.this.fecha.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void EjecServ(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error en la consulta, " + error, Toast.LENGTH_LONG).show();
                Log.d("Volley", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("Correo", Correo.getText().toString());
                parametros.put("Pass", Pass1.getText().toString());
                parametros.put("NombreUs", Nombre.getText().toString());
                parametros.put("ApellidoPus", ApPat.getText().toString());
                parametros.put("ApellidoMus", ApMat.getText().toString());
                parametros.put("Sexo", Sexo);
                parametros.put("Edad", String.valueOf(Edad));
                parametros.put("FechaNac", fecha.getText().toString());
                parametros.put("Muni", Muni.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

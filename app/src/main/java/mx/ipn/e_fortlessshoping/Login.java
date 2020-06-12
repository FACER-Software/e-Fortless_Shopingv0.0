package mx.ipn.e_fortlessshoping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button inicio, registro;
    EditText Correo,Contrasena;
    CarrxD usu = new CarrxD();

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
                Toast.makeText(Login.this, "Bienvenido " + Correo.getText().toString(), Toast.LENGTH_LONG ).show();
                validarUsuario("https://facersoft.com.mx/api/validar_usuario.php");
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

    private void validarUsuario (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    usu.seteMail(Correo.getText().toString());
                    startActivity(new Intent(Login.this, Princi.class));
                    finish();
                } else {
                    Toast.makeText(Login.this, "No se encontro el usuario o la contraseña", Toast.LENGTH_LONG ).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "Error" + error, Toast.LENGTH_LONG ).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("Correo", Correo.getText().toString());
                parametros.put("Pass", Contrasena.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

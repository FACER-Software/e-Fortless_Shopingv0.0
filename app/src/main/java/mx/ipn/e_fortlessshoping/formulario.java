package mx.ipn.e_fortlessshoping;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class formulario extends AppCompatActivity {

    EditText altura, peso, talla, calorias, azucares;
    Spinner comidas, enfermedad;
    String[] arrcom = new String[]{"Selecciona una opción", "1", "2", "3", "4", "5", "6"};
    String[] arrenf = new String[]{"Selecciona una opción", "Cardíaca arterioesclerótica",
            "Hipertensión arterial", "Diabetes", "Cáncer", "Osteoporósis", "Otras"};
    ArrayAdapter<String> arraycomida, arrayenfermedad;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);

        //Definicion de los datos
        altura = (EditText) findViewById(R.id.altura);
        peso = (EditText) findViewById(R.id.peso);
        talla = (EditText) findViewById(R.id.talla);
        calorias = (EditText) findViewById(R.id.calorias);
        azucares = (EditText) findViewById(R.id.azucares);
    }
}

package mx.ipn.e_fortlessshoping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Frutas extends AppCompatActivity {

    CarrxD usu = new CarrxD();

    Button cereza, durazno, fresas, elote, ajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        cereza = findViewById(R.id.Cereza);
        cereza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Cerezas");
                usu.setTotal(usu.getTotal() + 74);
                Toast.makeText(Frutas.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        durazno = findViewById(R.id.Durazno);
        durazno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Durazno");
                usu.setTotal(usu.getTotal() + 49);
                Toast.makeText(Frutas.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        fresas = findViewById(R.id.Fresas);
        fresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Freas");
                usu.setTotal(usu.getTotal() + 50);
                Toast.makeText(Frutas.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        elote = findViewById(R.id.Elote);
        elote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Elote");
                usu.setTotal(usu.getTotal() + 17);
                Toast.makeText(Frutas.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        ajo = findViewById(R.id.Ajo);
        ajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Ajo");
                usu.setTotal(usu.getTotal() + 15);
                Toast.makeText(Frutas.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
    }
}
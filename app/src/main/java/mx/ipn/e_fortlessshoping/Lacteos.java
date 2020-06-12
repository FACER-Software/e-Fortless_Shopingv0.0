package mx.ipn.e_fortlessshoping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lacteos extends AppCompatActivity {

    CarrxD usu = new CarrxD();

    Button leche, oikos, queso, mante, helado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacteos);

        leche = findViewById(R.id.leche);
        leche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Leche LALA");
                usu.setTotal(usu.getTotal() + 21);
                Toast.makeText(Lacteos.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        oikos = findViewById(R.id.oikos);
        oikos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Yoghurt Oikos");
                usu.setTotal(usu.getTotal() + 12);
                Toast.makeText(Lacteos.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });

        queso = findViewById(R.id.Queso);
        queso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Queso Manchego FUD");
                usu.setTotal(usu.getTotal() + 28);
                Toast.makeText(Lacteos.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });

        mante = findViewById(R.id.Mantequilla);
        mante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Mantequilla Iberia");
                usu.setTotal(usu.getTotal() + 24);
                Toast.makeText(Lacteos.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        helado = findViewById(R.id.Helado);
        helado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Helado Holanda");
                usu.setTotal(usu.getTotal() + 33);
                Toast.makeText(Lacteos.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });

    }
}
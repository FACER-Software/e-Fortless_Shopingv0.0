package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Frituras extends AppCompatActivity {

    CarrxD usu = new CarrxD();

    Button doritos, takis, ruffles, conejos, nutella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frituras);

        doritos = findViewById(R.id.Doritos);
        doritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Doritos Nacho");
                usu.setTotal(usu.getTotal() + 35);
                Toast.makeText(Frituras.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });


        takis = findViewById(R.id.Takis);
        takis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Carrito().SetTodo("Takis Fuego", 34);
                Toast.makeText(Frituras.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        ruffles = findViewById(R.id.Ruffles);
        ruffles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Ruffles Queso");
                usu.setTotal(usu.getTotal() + 35);
                Toast.makeText(Frituras.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        conejos = findViewById(R.id.Conejos);
        conejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Conejitos Turin");
                usu.setTotal(usu.getTotal() + 200);
                Toast.makeText(Frituras.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        nutella = findViewById(R.id.Nutella);
        nutella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Nutella");
                usu.setTotal(usu.getTotal() + 97);
                Toast.makeText(Frituras.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
    }
}
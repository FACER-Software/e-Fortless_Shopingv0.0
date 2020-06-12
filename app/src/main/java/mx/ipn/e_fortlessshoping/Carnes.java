package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Carnes extends AppCompatActivity {

    CarrxD usu = new CarrxD();

    Button molida, chuleta, chorizo, salchi, hotdog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);

        molida = findViewById(R.id.Molida);
        molida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Carne Molida");
                usu.setTotal(usu.getTotal() + 144);
                Toast.makeText(Carnes.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        chuleta = findViewById(R.id.Chuleta);
        chuleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Chuleta de cerdo");
                usu.setTotal(usu.getTotal() + 84);
                Toast.makeText(Carnes.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        chorizo = findViewById(R.id.Chorizo);
        chorizo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Chorizo");
                usu.setTotal(usu.getTotal() + 30);
                Toast.makeText(Carnes.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        salchi = findViewById(R.id.SalchPav);
        salchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Salchica de Pavo");
                usu.setTotal(usu.getTotal() + 38);
                Toast.makeText(Carnes.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });
        hotdog = findViewById(R.id.HotDog);
        hotdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Contador();
                usu.setProductos("Salchicha de HotDog");
                usu.setTotal(usu.getTotal() + 39);
                Toast.makeText(Carnes.this, "Producto agregado al carrito", Toast.LENGTH_LONG).show();
            }
        });

    }
}
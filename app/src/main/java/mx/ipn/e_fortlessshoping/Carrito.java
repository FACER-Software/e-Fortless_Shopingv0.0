package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Carrito extends AppCompatActivity{

    TextView product, total, numero;

    Button vaciar, actual;

    CarrxD usu = new CarrxD();

    String prodi;

    int Total, num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);



        product = findViewById(R.id.Productos);

        total =  findViewById(R.id.Total);

        numero = findViewById(R.id.Num);


        actual = findViewById(R.id.Actualizar);
        actual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usu.setTotal(255);
                usu.setNumero(3);
                usu.setProductos("Takis Fuego");
                usu.setProductos("COnejos Turin");
                usu.setProductos("Leche LALA");

                product.setText("Productos: " + usu.getProductos().toString());
                total.setText("Total: $" + String.valueOf(usu.getTotal()));
                numero.setText("Numero de Articulos: " + String.valueOf(usu.getNumero()));
            }
        });

        vaciar = findViewById(R.id.Vaciar);
        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.Limpiar();

                product.setText("Productos: " + usu.getProductos().toString());
                total.setText("Total: $" + String.valueOf(usu.getTotal()));
                numero.setText("Numero de Articulos: " + String.valueOf(usu.getNumero()));
            }
        });

    }

    public void SetTodo(String Prod, int precio){

        usu.setProductos(Prod);
        usu.Contador();
        usu.setTotal(usu.getTotal() + precio);

    }
}
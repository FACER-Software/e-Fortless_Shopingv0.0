package mx.ipn.e_fortlessshoping;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Herramientas extends Fragment {

    Button carro, nutri, pago;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_herramientas, container, false);

        carro = view.findViewById(R.id.CarroBrum);
        carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Carrito.class));
            }
        });
        nutri = view.findViewById(R.id.InfoNutri);
        nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Nutri.class));
            }
        });
        pago = view.findViewById(R.id.Pago);
        pago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(getContext(), Pagos.class));
            }
        });


        return view;
    }
}
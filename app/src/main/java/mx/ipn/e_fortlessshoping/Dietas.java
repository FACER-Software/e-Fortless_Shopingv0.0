package mx.ipn.e_fortlessshoping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.fragment.app.Fragment;


public class Dietas extends Fragment {

    ImageView banner;
    TableLayout tabla;
    Switch siono;
    TableRow fi1, fi2, fi3, fi4, fi5, fi6, fi7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dietas, container, false);

        banner = view.findViewById(R.id.ImgDiet);

        tabla = view.findViewById(R.id.TabDie);

        siono = view.findViewById(R.id.Siono);

        fi1 = view.findViewById(R.id.fi1);
        fi2 = view.findViewById(R.id.fi2);
        fi3 = view.findViewById(R.id.fi3);
        fi4 = view.findViewById(R.id.fi4);
        fi5 = view.findViewById(R.id.fi5);
        fi6 = view.findViewById(R.id.fi6);
        fi7 = view.findViewById(R.id.fi7);

        siono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (siono.isChecked()) {
                    banner.setVisibility(View.VISIBLE);
                    tabla.setVisibility(View.VISIBLE);
                    fi1.setVisibility(View.VISIBLE);
                    fi2.setVisibility(View.VISIBLE);
                    fi3.setVisibility(View.VISIBLE);
                    fi4.setVisibility(View.VISIBLE);
                    fi5.setVisibility(View.VISIBLE);
                    fi6.setVisibility(View.VISIBLE);
                    fi7.setVisibility(View.VISIBLE);
                } else {
                    banner.setVisibility(View.INVISIBLE);
                    tabla.setVisibility(View.INVISIBLE);
                    fi1.setVisibility(View.INVISIBLE);
                    fi2.setVisibility(View.INVISIBLE);
                    fi3.setVisibility(View.INVISIBLE);
                    fi4.setVisibility(View.INVISIBLE);
                    fi5.setVisibility(View.INVISIBLE);
                    fi6.setVisibility(View.INVISIBLE);
                    fi7.setVisibility(View.INVISIBLE);
                }
            }
        });

        return view;
    }
}
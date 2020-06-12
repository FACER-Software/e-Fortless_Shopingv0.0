package mx.ipn.e_fortlessshoping.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import mx.ipn.e_fortlessshoping.R;

public class HomeContentFragment extends Fragment {

    private  static final  String TEXT = "text";

    public static mx.ipn.e_fortlessshoping.ui.HomeContentFragment1 newInstance(String text){
        mx.ipn.e_fortlessshoping.ui.HomeContentFragment1 frag = new mx.ipn.e_fortlessshoping.ui.HomeContentFragment1();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInsanceState){
        View layout = inflater.inflate(R.layout.content_menu, container, false);

        if(getArguments() != null){
            //((TextView) layout.findViewById(R.id.text).setText(getArguments().getString(TEXT)));
        }

        return layout;
    }
}

package com.miss.belajarfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@l ink Fragment} subclass.
 */
public class Fragmentbuah extends Fragment implements View.OnClickListener {

Button btbuah;

    public Fragmentbuah() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_fragmentbuah, container, false);

         btbuah = view.findViewById(R.id.btbuah);
         btbuah.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btbuah){
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager !=null){
                FragmentSayurr fragmentsayur = new FragmentSayurr();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragmentsayur, FragmentSayurr.class.getSimpleName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }

    }
}

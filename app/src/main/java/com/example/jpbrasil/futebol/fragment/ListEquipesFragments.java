package com.example.jpbrasil.futebol.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jpbrasil.futebol.R;

/**
 * Created by JpBrasil on 28/05/2017.
 */

public class ListEquipesFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_equipe, container, false);
        return view;
    }
}

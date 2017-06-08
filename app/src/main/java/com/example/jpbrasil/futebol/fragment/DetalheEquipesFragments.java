package com.example.jpbrasil.futebol.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jpbrasil.futebol.R;


/**
 * Created by JpBrasil on 05/06/2017.
 */

public class DetalheEquipesFragments extends ListFragment {

    String chave = null;
    private TextView txt = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_detalhe_equipe);

        chave = getActivity().getIntent().getStringExtra(ListEquipesFragments.ID_EXTRA);
    }
}



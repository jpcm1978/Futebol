package com.example.jpbrasil.futebol.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.dao.EquipeDAO;
import com.example.jpbrasil.futebol.model.Equipe;
import com.example.jpbrasil.futebol.model.Jogos;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by JpBrasil on 05/06/2017.
 */

public class DetalheEquipesFragments extends Fragment {

    /*private ListView ltvEquipes;
    private ArrayAdapter<String> adapter;

    List<Equipe> equipes = new ArrayList<Equipe>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO  lembrar de consumir o json
        View view = inflater.inflate(R.layout.fragment_detalhe_equipe, container, false);

        //PEGAR REFERÊNCIA DO LISTVIEW E DO BUTTON
        ltvEquipes = (ListView)view.findViewById(R.id.ltvJson);

        loadEquipes();
        return  view;
    }

    public void loadEquipes() {
        EquipeDAO dao = new EquipeDAO(getActivity());
        equipes = dao.pegarTodasEquipes();

        List<String> equipesNomes = new ArrayList<String>();

        for (Equipe equipe:equipes){
            equipesNomes.add(equipe.getNome());
        }
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                equipesNomes);
        ltvEquipes.setAdapter(adapter);
    }*/

    public static class jogosTask extends AsyncTask(void, void, Jogos){

    }
}



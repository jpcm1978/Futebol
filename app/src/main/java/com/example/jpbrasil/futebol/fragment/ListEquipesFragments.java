package com.example.jpbrasil.futebol.fragment;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jpbrasil.futebol.FormEquipesActivity;
import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.dao.EquipeDAO;
import com.example.jpbrasil.futebol.model.Equipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JpBrasil on 28/05/2017.
 */

public class ListEquipesFragments extends Fragment {

    private ListView ltvEquipes;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbarLayout;


    List<Equipe> equipes = new ArrayList<Equipe>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_equipe, container, false);
        toolbarLayout = (Toolbar)view.findViewById(R.id.toolbar);


        //PEGAR REFERÊNCIA DO LISTVIEW E DO BUTTON
        ltvEquipes = (ListView)view.findViewById(R.id.ltvEquipes);
        Button btnAddLista = (Button)view.findViewById(R.id.btnAddLista);

        loadEquipes();

        ltvEquipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (isLandScape()){
                    loadEquipeForm(equipes.get(position));
                }else {
                    loadDetalheJson(equipes.get(position));
                }
            }
        });

        //ADICIONAR COMPORTAMENTO PARA O BOTÃO
        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isLandScape()){
                    loadEquipeForm(null);
                }else {
                    Intent it = new Intent(getActivity(), FormEquipesActivity.class);
                    startActivity(it);
                }
            }
        });

        return view;
    }

    /**
     *
     * @param equipe Recebe a equipe selecionada na lista
     */
    private void loadDetalheJson(Equipe equipe){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new DetalheEquipesFragments();
        if (equipe != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("equipe", equipe);
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.fragmentList, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //Listando Equipe no form (Tablet)
    private void loadEquipeForm(Equipe equipe) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new FormEquipesFragments();
        if (equipe != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("equipe", equipe);
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.fragmentForm, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    //Verificar se é landscape
    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    //Retornar equipe para lista depois de gravada
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
    }

    @Override
    public void onStart() {
        super.onStart();
        /*Estou notificando todos que tem esse meu adapter que agora mudei de estado e agora eles vão ter que fazer alguma coisa,
        * essa alguma coisa na implementação do ListView  é carregar de novo*/
        //adapter.notifyDataSetChanged();
        loadEquipes();
    }

    /*public interface CliqueNaEquipeListener{
        void equipeFoiClicada(Equipe equipe);
    }*/
}





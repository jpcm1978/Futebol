package com.example.jpbrasil.futebol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.jpbrasil.futebol.fragment.FormEquipesFragments;
import com.example.jpbrasil.futebol.fragment.ListEquipesFragments;



public class ListEquipesActivity extends AppCompatActivity implements FormEquipesFragments.OnRefreshFormOK{

    ListEquipesFragments fragmentList;
    private Toolbar toolbarLayout;

    private int[] escudos = {R.drawable.sport, R.drawable.bahia, R.drawable.vitoria};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_equipe);
        fragmentList = (ListEquipesFragments) getSupportFragmentManager().findFragmentById(R.id.fragmentList);
        toolbarLayout = (Toolbar)findViewById(R.id.toolbarLista);
        setSupportActionBar(toolbarLayout);
    }

    @Override
    public void refresh() {
        fragmentList.loadEquipes();
    }


}

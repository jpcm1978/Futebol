package com.example.jpbrasil.futebol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

    //método que acha toolbar


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//Criando variável que pega um menu inflater
        inflater.inflate(R.menu.menu_toolbar, menu);//referenciando o menu que criamos
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//Aqui vai detectar o menu
        Intent it;
        switch (item.getItemId()){
            case R.id.botaoMap:
                it = new Intent(this, MapsActivity.class);
                startActivity(it);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

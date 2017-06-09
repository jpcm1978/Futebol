package com.example.jpbrasil.futebol;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by JpBrasil on 07/06/2017.
 */

public class DetalheEquipesActivity extends AppCompatActivity {

    private Toolbar toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_equipe);

        toolbarLayout = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbarLayout);//Setando a toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

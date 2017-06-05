package com.example.jpbrasil.futebol.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jpbrasil.futebol.R;

/**
 * Created by JpBrasil on 05/06/2017.
 */

class DetalheEquipesFragments extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_detalhe_equipe);
        Intent it = getIntent();
        it.getSerializableExtra("lista");
    }
}

package com.example.jpbrasil.futebol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jpbrasil.futebol.dao.EquipeDAO;
import com.example.jpbrasil.futebol.model.Equipe;

import java.util.ArrayList;
import java.util.List;

public class ListEquipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_equipe);
    }
}

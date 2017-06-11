package com.example.jpbrasil.futebol;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.jpbrasil.futebol.fragment.DetalheEquipesFragments;
import com.example.jpbrasil.futebol.model.Jogos;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.type;

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

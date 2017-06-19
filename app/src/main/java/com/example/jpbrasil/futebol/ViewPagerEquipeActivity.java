package com.example.jpbrasil.futebol;

import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.jpbrasil.futebol.model.Equipe;

import java.util.List;

public class ViewPagerEquipeActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private Toolbar toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_equipe);
        toolbarLayout = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbarLayout);//Setando a toolbar


        /*viewPager = (ViewPager)findViewById(R.id.viewPager);
         String[] titulos = {"Escudo", "Estádio", "Bandeira"};
        //Instanciando PagerAdapterFragments
        PagerAdapterFragments adapterFragments = new PagerAdapterFragments(
                getSupportFragmentManager(), titulos);
        viewPager.setAdapter(adapterFragments);*/

        //Carregando o ViewPager
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        //Carregando as Imagens
        int[] equipes = {R.drawable.bandeira_sport, R.drawable.sport, R.drawable.sport_estadio};
        PagerAdapterImagens imagens = new PagerAdapterImagens(
                getApplication(), equipes);
        viewPager.setAdapter(imagens);


    }
}

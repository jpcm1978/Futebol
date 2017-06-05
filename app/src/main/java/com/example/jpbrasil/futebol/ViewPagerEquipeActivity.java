package com.example.jpbrasil.futebol;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ViewPagerEquipeActivity extends AppCompatActivity {

    private Toolbar toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_equipe);
        toolbarLayout = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbarLayout);//Setando a toolbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Carregando o ViewPager
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        String[] titulos = {"Atlético GO", "Atlético MG", "Atlético PR", "Sport"};
        //Instanciando PagerAdapterFragments
        PagerAdapterFragments adapterFragments = new PagerAdapterFragments(
                getSupportFragmentManager(), titulos);
        viewPager.setAdapter(adapterFragments);
    }
}
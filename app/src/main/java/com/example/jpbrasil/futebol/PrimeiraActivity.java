package com.example.jpbrasil.futebol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jpbrasil.futebol.model.Equipe;

public class PrimeiraActivity extends AppCompatActivity {

    TextView titulo;
    ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

        titulo = (TextView) findViewById(R.id.titulo);
        imagem = (ImageView) findViewById(R.id.img_titulo);

        imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PrimeiraActivity.this, ListTimesActivity.class);
                startActivity(it);
            }
        });
    }
}

package com.example.jpbrasil.futebol;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jpbrasil.futebol.model.Equipe;

public class DetalhesEquipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_equipe);

        final EditText edtNome = (EditText)findViewById(R.id.edtNome);
        final EditText edtLocal = (EditText)findViewById(R.id.edtLocal);
        final EditText edtTitulos = (EditText)findViewById(R.id.edtTitulos);
        final EditText edtData = (EditText)findViewById(R.id.edtData);
        Button btnGravar = (Button)findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Equipe equipe = new Equipe();
                equipe.setNome(edtNome.getText().toString());
                equipe.setLocal(edtLocal.getText().toString());
                equipe.setTitulosNacionais(edtTitulos.getText().toString());
                equipe.setDataFundacao(edtData.getText().toString());

                /**Aqui estamos pegando a Intent da PrimeiraActivity*/
                Intent it = getIntent().putExtra("equipe", equipe);
                /*Estou dizendo que coloquei meu objeto na Intent, e estou dizendo agora: Tá ok!*/
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}

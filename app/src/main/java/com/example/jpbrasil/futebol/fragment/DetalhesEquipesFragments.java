package com.example.jpbrasil.futebol.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.model.Equipe;

import static android.app.Activity.RESULT_OK;

/**
 * Created by JpBrasil on 28/05/2017.
 */

public class DetalhesEquipesFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhe_equipe, container, false);

        final EditText edtNome = (EditText)view.findViewById(R.id.edtNome);
        final EditText edtLocal = (EditText)view.findViewById(R.id.edtLocal);
        final EditText edtTitulos = (EditText)view.findViewById(R.id.edtTitulos);
        final EditText edtData = (EditText)view.findViewById(R.id.edtData);


        Bundle bundle = getArguments();
        if (bundle != null){
            Equipe equipe = (Equipe)bundle.getSerializable("equipe");
            edtNome.setText(equipe.getNome());
            edtLocal.setText(equipe.getLocal());
            edtTitulos.setText(equipe.getTitulosNacionais());
            edtData.setText(equipe.getDataFundacao());
        }

        Button btnGravar = (Button)view.findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Equipe equipe = new Equipe();
                equipe.setNome(edtNome.getText().toString());
                equipe.setLocal(edtLocal.getText().toString());
                equipe.setTitulosNacionais(edtTitulos.getText().toString());
                equipe.setDataFundacao(edtData.getText().toString());

                /**Aqui estamos pegando a Intent da PrimeiraActivity*/
                Intent it = getActivity().getIntent().putExtra("equipe", equipe);
                /*Estou dizendo que coloquei meu objeto na Intent, e estou dizendo agora: Tá ok!*/
                getActivity().setResult(Activity.RESULT_OK, it);
                getActivity().finish();
            }
        });

        return view;
    }
}

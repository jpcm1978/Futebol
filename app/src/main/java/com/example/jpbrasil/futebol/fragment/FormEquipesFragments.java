package com.example.jpbrasil.futebol.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.dao.EquipeDAO;
import com.example.jpbrasil.futebol.model.Equipe;

/**
 * Created by JpBrasil on 28/05/2017.
 */

public class FormEquipesFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_equipe, container, false);

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
        Button btnRemover = (Button)view.findViewById(R.id.btnRemover);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EquipeDAO dao = new EquipeDAO(getActivity());
                Equipe equipe = new Equipe();
                equipe.setNome(edtNome.getText().toString());
                equipe.setLocal(edtLocal.getText().toString());
                equipe.setTitulosNacionais(edtTitulos.getText().toString());
                equipe.setDataFundacao(edtData.getText().toString());
                dao.inserirEquipe(equipe);
                Toast.makeText(getActivity(), "Equipe Inserida com Sucesso!", Toast.LENGTH_SHORT).show();

               /* OnRefreshFormOK activity = (OnRefreshFormOK)getActivity();
                activity.refresh();*/

                if (!isLandScape()) {
                    /*Toast.makeText(getActivity(), "Não Funciona no Portland. Essa função só LandScape!", Toast.LENGTH_SHORT).show();
                    getActivity().finish();*/

                }
            }
        });

        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public boolean isLandScape(){
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    public interface OnRefreshFormOK{
        public void refresh();
    }

}

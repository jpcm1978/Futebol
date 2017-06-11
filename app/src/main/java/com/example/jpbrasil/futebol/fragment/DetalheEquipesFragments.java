package com.example.jpbrasil.futebol.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.model.Jogos;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by JpBrasil on 05/06/2017.
 */

public class DetalheEquipesFragments extends Fragment {

    List<Jogos> mJogos;
    ListView mListaJson;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhe_equipe, container, false);
        mListaJson = (ListView)view.findViewById(R.id.ltvJson);

        mJogos = new ArrayList<>();

        mListaJson.setAdapter(new ArrayAdapter<Jogos>(
                getActivity(),
                android.R.layout.simple_list_item_2,
                mJogos
        ));

        new JogosTask().execute();
        return view;
    }

    class JogosTask extends AsyncTask<Void, Void, Jogos>{

        @Override
        protected Jogos doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://www.dropbox.com/s/wo665ra8np3bkqo/time.json?dl=0")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();
                Log.d("JPCM", jsonString);
                Gson gson = new Gson();
                Jogos jogos = gson.fromJson(jsonString, Jogos.class);
                return jogos;
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }
}

    /**
     * ListView listView;
     private TextView time;
     private TextView adversario;
     private TextView local;
     private TextView dataHora;
     private TextView estado;
     private TextView foto;
     private TextView site;

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_detalhe_equipe, container, false);

     listView = (ListView)view.findViewById(R.id.ltvJson);
     time = (TextView) view.findViewById(R.id.nome);
     adversario = (TextView)view.findViewById(R.id.adversario);
     local = (TextView)view.findViewById(R.id.local);
     dataHora = (TextView)view.findViewById(R.id.datahora);
     estado = (TextView)view.findViewById(R.id.estado);
     foto = (TextView) view.findViewById(R.id.foto);
     site = (TextView)view.findViewById(R.id.site);

     listView.setAdapter(new ArrayAdapter<Jogos>(
     getActivity(),
     android.R.layout.simple_list_item_1,
     new ArrayList<Jogos>()
     ));

     JogosTask jogosTask = new JogosTask();
     jogosTask.execute();

     return view;
     }


     */



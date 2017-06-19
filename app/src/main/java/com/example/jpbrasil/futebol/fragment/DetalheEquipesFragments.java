package com.example.jpbrasil.futebol.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jpbrasil.futebol.JogosAdapterJson;
import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.model.Jogos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by JpBrasil on 05/06/2017.
 */

public class DetalheEquipesFragments extends Fragment {

    ArrayList<Jogos> mJogos;
    ListView mListaJson;
    View view;
    JogosAdapterJson adapterJson;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_detalhe_equipe, container, false);

        new JogosTask().execute();
       /*
        mJogos = new ArrayList<Jogos>();

        adapterJson = new JogosAdapterJson(getActivity(), mJogos);

        mListaJson = (ListView)view.findViewById(R.id.ltvJson);

        mListaJson.setAdapter(adapterJson);
*/

       /* mListaJson.setAdapter(new ArrayAdapter<Jogos>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mJogos
        ));*/


        return view;
    }

    class JogosTask extends AsyncTask<Void, Void, ArrayList<Jogos> >{

        @Override
        protected ArrayList<Jogos> doInBackground(Void... params) {

//            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://www.mocky.io/v2/5942c879120000bf0cddc5f3")
                    .build();

            try {
                Response response = new OkHttpClient().newCall(request).execute();

                String jsonString = response.body().string();
                Log.d("JPCM", jsonString);
                mJogos = new ArrayList<Jogos>();
                JSONArray jsonArrayPartidas = new JSONArray(jsonString);
                for( int i = 0; i < jsonArrayPartidas.length() ; i++ ){
                    JSONObject jogoJsonObject = jsonArrayPartidas.getJSONObject(i);
                    Jogos j = new Jogos();
                    j.setLocal(jogoJsonObject.getString("LOCAL"));
                    j.setAdversario(jogoJsonObject.getString("ADVERSARIO"));
                    j.setEstado(jogoJsonObject.getString("ESTADO"));
                    j.setSite(jogoJsonObject.getString("SITE"));
                    j.setDatahora(jogoJsonObject.getString("DATAHORA"));
                    j.setUrlFoto(jogoJsonObject.getString("FOTO"));
                    mJogos.add(j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mJogos;
        }

        @Override
        protected void onPostExecute(ArrayList<Jogos> jogos) {
            adapterJson = new JogosAdapterJson(getActivity().getBaseContext(), mJogos);

            mListaJson = (ListView)view.findViewById(R.id.ltvJson);

            mListaJson.setAdapter(adapterJson);

            super.onPostExecute(jogos);
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



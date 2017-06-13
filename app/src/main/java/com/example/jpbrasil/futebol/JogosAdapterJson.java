package com.example.jpbrasil.futebol;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jpbrasil.futebol.model.Jogos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JpBrasil on 11/06/2017.
 */

public class JogosAdapterJson extends ArrayAdapter<Jogos> {


    private Context context;
    private ArrayList<Jogos> arrayList;

    public JogosAdapterJson(Context cont, ArrayList<Jogos> lista) {
        super(cont, 0, lista);
        this.context = cont;
        this.arrayList = lista;
    }



    /**
     * Criando uma View para cada Item
     * Vai devolver nossa view personalizada
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * Vai pegar uma posiçãpo de qual o objeto que esta buscando
         * Pegando o item da lista, na posição que o getView for chamado
         */

        Jogos jogosPosicao = this.arrayList.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.fragment_detalhe_equipe, null);

        TextView nome = (TextView)convertView.findViewById(R.id.nome);
        nome.setText(jogosPosicao.getUrlNome());

        TextView adversario = (TextView)convertView.findViewById(R.id.adversario);
        adversario.setText(jogosPosicao.getAdversario());

        TextView local = (TextView)convertView.findViewById(R.id.local);
        local.setText(jogosPosicao.getLocal());

        TextView data = (TextView)convertView.findViewById(R.id.datahora);
        data.setText(jogosPosicao.getDatahora());

        TextView estado = (TextView)convertView.findViewById(R.id.estado);
        estado.setText(jogosPosicao.getEstado());

        ImageView img = (ImageView) convertView.findViewById(R.id.foto);
        Picasso.with(context).load(jogosPosicao.getUrlFoto()).into(img);

        TextView site = (TextView)convertView.findViewById(R.id.site);
        site.setText(jogosPosicao.getSite());

        return convertView;
    }

    /**
     * Retorna a quantidade de itens existentes na lista
     */
   /* @Override
    public int getCount() {
        return mJogos.size();
    }*/

    /**
     * Devolvendo o item da lista pela posição, ele quer saber um item a partir de uma posição
     */
   /* @Override
    public Object getItem(int position) {
        return mJogos.get(position);
    }*/

    /**
     * Devolvendo o id do item da lista. Esse método espera saber qual é o id do objeto que está sendo buscado
     /*  *//*
    @Override
    public long getItemId(int position) {
        return 0;
    }*/
}

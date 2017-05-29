package com.example.jpbrasil.futebol.fragment;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jpbrasil.futebol.DetalhesEquipesActivity;
import com.example.jpbrasil.futebol.R;
import com.example.jpbrasil.futebol.dao.EquipeDAO;
import com.example.jpbrasil.futebol.model.Equipe;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by JpBrasil on 28/05/2017.
 */

public class ListEquipesFragments extends Fragment {

//    private static final int REQUEST_CODE_EQUIPE = 1;

    private ListView ltvEquipes;
    private ArrayAdapter<String> adapter;

    /*Essa list era de strings, até o banco também, depois do banco foi modificada para a debaixo (equipesNomes) e foi
    * gerada uma nova lista de objeto (List<Equipe> equipe)*/
    //List<String> equipes = new ArrayList<String>();
    //List<String> equipesNomes = new ArrayList<String>();
    /*Depois do método loadEquipes, essa lista saiu daqui e foi para esse metodo por que como é atributo de classe e toda
    * vez que é executado se permanecer aqui irei incluir os times mais de uma vez */
    List<Equipe> equipes = new ArrayList<Equipe>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_equipe, container, false);

        //PEGAR REFERÊNCIA DO LISTVIEW E DO BUTTON
        ltvEquipes = (ListView)view.findViewById(R.id.ltvEquipes);
        Button btnAddLista = (Button)view.findViewById(R.id.btnAddLista);


        //POPULAR LISTA
        /*adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipes);
        ltvTimes.setAdapter(adapter);*/
        /*Antes pegavamos de uma lista conforme visto no adapter acima comentado. Agora iremos pegar do banco de dados,
        *para isso teremos que gerar um adapter com novas informações.
        * Tinhamos uma lista com equipes, então teremos que gerar um array e pegar do banco de dados as equipes que
        * tem lá, só que nesse caso o nosso getAllEquipes retorna uma lista de equipes e não de strings, então isso
        * vai fazer ter um trabalho a mais.*/

        /*EquipeDAO dao = new EquipeDAO(this);
        equipes = dao.pegarTodasEquipes();
        *//*Para cada equipe da lista equipes faça:*//*
        for (Equipe equipe:equipes){//Percorrendo toda minha lista de equipes
            equipesNomes.add(equipe.getNome());//Pegando o nome deles (getNome) e jogando na lista de strings (equipesNomes)
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipesNomes);
        ltvTimes.setAdapter(adapter);*/
        /*Ainda não concluído, do jeito que está ainda não funciona, falta o reload. O método está dentro do onCreate,
        * e o que estavamos fazendo no onRestart -> adapter.notifyDataSetChanged();
        * PRECISO REPETIR ESSE CÓDIGO ABAIXO TODA VEZ QUE TIVERMOS UMA ALTERAÇÃO NO onStart, então teremos que extrair o método
        * (esse código abaixo , que é justamente esse acima que está comentado). FAREMOS DA SEGUINTE MANEIRA:
        * seleciona o código, botão direito do mouse, Refactor, Extract, Method
        */
        loadEquipes();

        ltvEquipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadEquipeForm(equipes.get(position));
            }
        });

        //ADICIONAR COMPORTAMENTO PARA O BOTÃO
        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration configuration = getResources().getConfiguration();
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    loadEquipeForm(null);
                }else {
                /*Como estamos esperando um retorno da outra actvity, iremos usar um startActivityForResult e eu quero
                que ele me retorne um objeto equipe.*/
                    //startActivity(it);
                    Intent it = new Intent(getActivity(), DetalhesEquipesActivity.class);
                    startActivity(it);
                }
                /*/*A partir de agora, depois que montamos a activity de formulário, ele vai precisar de dois parâmetros,
                um é a própria INTENT e o outro vai ser a REQUEST_CODE que é um número para identificar (imagina na tela
                inicial que teremos mais de um botão e todos eles fazem coisas diferentes, quando chamamos o
                STARTACTIVITYFORRESULT teremos que implementar ONACTIVITYRESULT, veja abaixo que como parametro ele recebe
                requestcode, então se a tela principal tivesse 3 botões que fizessem a mesma função de chamar uma activity
                esperando um resultado, eu teria que identificar qual foi o botão que eu chamei, e a forma de identificar
                é usando esse requestcode.
                Teremos que criar um código único para ver o tipo de requisição que eu usei, no nosso caso eu criei
                ORGAO_REQUEST_CODE*/
            }
        });
        return view;
    }

    private void loadEquipeForm(Equipe equipe) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new DetalhesEquipesFragments();
        if (equipe != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("equipe", equipe);
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.fragmentDetalhe, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadEquipes() {
        EquipeDAO dao = new EquipeDAO(getActivity());
        equipes = dao.pegarTodasEquipes();

        List<String> equipesNomes = new ArrayList<String>();

        for (Equipe equipe:equipes){
            equipesNomes.add(equipe.getNome());
        }
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                equipesNomes);
        ltvEquipes.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        /*Estou notificando todos que tem esse meu adapter que agora mudei de estado e agora eles vão ter que fazer alguma coisa,
        * essa alguma coisa na implementação do ListView  é carregar de novo*/
        //adapter.notifyDataSetChanged();
        loadEquipes();
    }

    /*Intent data -> é a informação que estamos precisando que o cara vai passar, que vem através do Intent*//*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        *//*Quando essa activity voltar vai retornar algo, então vamos fazer uma checagem primeiro*//*
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_CODE_EQUIPE){
                *//*Fiz essas verificações acima, agora é só pegar o objeto*//*
                Equipe equipe = (Equipe)data.getSerializableExtra("equipe");//Pronto, peguei a Equipe agora é inserir na lista
                //equipes.add(equipe.getNome());//Feito isso temos que dar o refrash (on Restart)
                *//*Essa parte comentada acima era usada antes do banco ser usado, depois da classe EquipeDAO contruída,
                usaremos essa forma abaixo:*//*
                EquipeDAO dao = new EquipeDAO(getActivity());
                dao.inserirEquipe(equipe);
            }
        }
    }*/
}

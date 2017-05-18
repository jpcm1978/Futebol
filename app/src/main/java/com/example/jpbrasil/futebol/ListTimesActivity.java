package com.example.jpbrasil.futebol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jpbrasil.futebol.model.Equipe;

import java.util.ArrayList;
import java.util.List;

public class ListTimesActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_EQUIPE = 1;

    ListView ltvTimes;
    Button btnAddLista;

    List<String> equipes = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_times);

        ltvTimes = (ListView)findViewById(R.id.ltvTimes);
        btnAddLista = (Button)findViewById(R.id.btnAddLista);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipes);
        ltvTimes.setAdapter(adapter);

        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Como estamos esperando um retorno da outra actvity, iremos usar um startActivityForResult e eu quero
                que ele me retorne um objeto equipe.*/
                //startActivity(it);
                Intent it = new Intent(ListTimesActivity.this, FormAddTimesActivity.class);
                startActivityForResult(it, REQUEST_CODE_EQUIPE);
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
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
        /*Estou notificando todos que tem esse meu adapter que agora mudei de estado e agora eles vão ter que fazer alguma coisa,
        * essa alguma coisa na implementação do ListView  é carregar de novo*/
    }

    /*Intent data -> é a informação que estamos precisando que o cara vai passar, que vem através do Intent*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*Quando essa activity voltar vai retornar algo, então vamos fazer uma checagem primeiro*/
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_CODE_EQUIPE){
                /*Fiz essas verificações acima, agora é só pegar o objeto*/
                Equipe equipe = (Equipe)data.getSerializableExtra("equipe");//Pronto, peguei a Equipe agora é inserir na lista
                equipes.add(equipe.getNome());//Feito isso temos que dar o refrash (on Restart)
            }
        }
    }
}

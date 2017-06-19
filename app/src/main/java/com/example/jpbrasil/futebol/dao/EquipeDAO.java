package com.example.jpbrasil.futebol.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jpbrasil.futebol.model.Equipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JpBrasil on 19/05/2017.
 */

public class EquipeDAO extends SQLiteOpenHelper{

    private String sql;
    private String sqlRemove;

    /*O OpenHelper do SQLite, ele implementa dois métodos: ONCREATE E ONUPGRADE, que já recebe uma referência (um objeto)
         *para o nosso database (que tem um monte de método para agente trabalhar e manipular informação.
         *Essa classe abstrata também tem um construtor que  que teremos que implementar (EquipeDAO). Esse construtor tem
         *setar: CONTEXTO (Context), o nome do banco (name), um CURSORFACTORY e a versão do banco (version) */
    public EquipeDAO(Context context) {
        super(context, "futebol", null, 2);
    }

    /*Aqui teremos que criar a tabela. Vai passar referência de DB, que é através dele que iremos fazer as tranzações com o
    * banco de dados*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE equipes(nome TEXT NOT NULL, local TEXT NOT NULL, " +
                "titulosNacionais TEXT NOT NULL, dataFundacao TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        sql = "DROP TABLE IF EXISTS equipes";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERIR
    public void inserirEquipe (Equipe equipe){
        sql = "INSERT INTO equipes(nome, local, titulosNacionais, dataFundacao) VALUES ('"+ equipe.getNome() + "','" +
        equipe.getLocal() + "','" + equipe.getTitulosNacionais() + "','" + equipe.getDataFundacao() +"');";
        /*Para pegar uma instancia do SQLite pegamos GETWRITABLEDATABASE. Se for uma operação de escrita ele retorna
        *uma instancia do SQLite Data Base. Esse getWritableDatabase serve: se formos fazer uma operação para incluir
        * alguma coisa no banco de dados, escrever algo, iremos chamar ele. Se for só uma operação de leitura, chamamos
        * o getReadableDatabase*/
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public void removerEquipe(Equipe equipe){
        sqlRemove = "DELETE FROM equipes WHERE nome="+ equipe.getNome();
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sqlRemove);
        database.close();

    }



    //GET ALL EQUIPES
    public List<Equipe> pegarTodasEquipes(){
        sql = "SELECT * FROM equipes;";
        SQLiteDatabase db =getReadableDatabase();
        /*Nesse caso execSQL() não servirá por que retorna void. Ultilizaremos rawQuery que retorna cursor.
        * Esse cursor está guardando a referência para um elemento da lista, esse elemento guarda a posição
        * do próximo ou do anterior*/
        Cursor cursor = db.rawQuery(sql, null);

        List<Equipe> equipes = new ArrayList<Equipe>();

        /*Enquanto eu puder mover para o próximo*/
        while (cursor.moveToNext()){
            /*Para montar o objeto, teremos que adicionar uma lista
            (logo acima -> List<Equipe> equipes = new ArrayList<Equipe>();)
            e iremos pegar cada uma equipe dessa lista*/
            Equipe equipe = new Equipe();
            /*Estou setando o nome (setNome) neste objeto que acabei de criar (equipe), estou esperando uma string (getString)
            * e o nome da coluna que estou carregando (getColumnIndex("nome"))*/
            equipe.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            equipe.setLocal(cursor.getString(cursor.getColumnIndex("local")));
            equipe.setTitulosNacionais(cursor.getString(cursor.getColumnIndex("titulosNacionais")));
            equipe.setDataFundacao(cursor.getString(cursor.getColumnIndex("dataFundacao")));
            equipes.add(equipe);
        }
        db.close();
        return equipes;
    }
}

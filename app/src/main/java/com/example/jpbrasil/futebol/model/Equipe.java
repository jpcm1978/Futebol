package com.example.jpbrasil.futebol.model;

import java.io.Serializable;

/**
 * Created by JpBrasil on 18/05/2017.
 */

public class Equipe implements Serializable{

    String nome;
    String local;
    String titulosNacionais;
    String dataFundacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTitulosNacionais() {
        return titulosNacionais;
    }

    public void setTitulosNacionais(String titulosNacionais) {
        this.titulosNacionais = titulosNacionais;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    @Override
    public String toString() {
        return nome;
    }
}

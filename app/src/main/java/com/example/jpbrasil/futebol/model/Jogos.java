package com.example.jpbrasil.futebol.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JpBrasil on 06/06/2017.
 */

public class Jogos implements Serializable {

    @SerializedName("TIME")
    List<Jogos> jogos;
    String urlNome;
    String adversario;
    String local;
    String datahora;
    String estado;
    String urlFoto;
    String site;

    public List<Jogos> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogos> jogos) {
        this.jogos = jogos;
    }

    public String getUrlNome() {
        return urlNome;
    }

    public void setUrlNome(String urlNome) {
        this.urlNome = urlNome;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Jogos() {

    }


}

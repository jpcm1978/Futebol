package com.example.jpbrasil.futebol.model;

import java.io.Serializable;

/**
 * Created by JpBrasil on 06/06/2017.
 */

public class Jogos implements Serializable {

    String local;
    String diaHora;
    String adversario;

    public Jogos() {

    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }
}

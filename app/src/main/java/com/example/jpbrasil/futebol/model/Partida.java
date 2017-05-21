package com.example.jpbrasil.futebol.model;

import java.io.Serializable;

/**
 * Created by JpBrasil on 21/05/2017.
 */

public class Partida implements Serializable{

    String adversario;
    String dia;
    String hora;
    String local;

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Partida(String adversario, String dia, String hora, String local) {
        this.adversario = adversario;
        this.dia = dia;
        this.hora = hora;
        this.local = local;
    }

    @Override
    public String toString() {
        return "Partida: " + "<br>" +
                "Adversario: " + adversario + "<br>" +
                "Dia: " + dia + "<br>" +
                "Hora: " + hora + "<br>" +
                "Local: " + local;
    }
}

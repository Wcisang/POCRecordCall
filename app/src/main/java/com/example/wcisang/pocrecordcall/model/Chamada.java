package com.example.wcisang.pocrecordcall.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by wcisang on 06/01/17.
 */

public class Chamada extends RealmObject {

    Date data;
    String telefone;

    public Chamada() {
    }

    public Chamada(Date data) {
        this.data = data;
    }

    public Chamada(Date data, String telefone) {
        this.data = data;
        this.telefone = telefone;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

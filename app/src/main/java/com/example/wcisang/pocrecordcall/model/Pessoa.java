package com.example.wcisang.pocrecordcall.model;

import android.os.Parcelable;

import org.parceler.Parcel;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by wcisang on 06/01/17.
 */

@Parcel(implementations = { Pessoa.class },
        value = org.parceler.Parcel.Serialization.BEAN,
        analyze = { Pessoa.class } )
public class Pessoa extends RealmObject {

    String nome;
    String telefone;
    RealmList<Chamada> chamadas;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.chamadas = new RealmList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public RealmList<Chamada> getChamadas() {
        return chamadas;
    }

    public void setChamadas(RealmList<Chamada> chamadas) {
        this.chamadas = chamadas;
    }
}

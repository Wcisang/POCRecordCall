package com.example.wcisang.pocrecordcall.dao;

import com.example.wcisang.pocrecordcall.model.Pessoa;

import io.realm.Realm;

/**
 * Created by wcisang on 06/01/17.
 */

public class PessoaDAO {


    Realm realm;

    public PessoaDAO() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(Pessoa pessoa){
        realm.beginTransaction();
        realm.copyToRealm(pessoa);
        realm.commitTransaction();
    }

    public Pessoa getPessoaByNumero(String numero){
        return realm.where(Pessoa.class).contains("telefone",numero).findFirst();
    }

}

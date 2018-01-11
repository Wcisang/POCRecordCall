package com.example.wcisang.pocrecordcall.dao;

import com.example.wcisang.pocrecordcall.model.Chamada;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import io.realm.Realm;

/**
 * Created by wcisang on 08/01/17.
 */

public class ChamadaDAO {

    Realm realm;

    public ChamadaDAO() {
        realm = Realm.getDefaultInstance();
    }

    public void insertChamada(Pessoa p, Chamada c){
        realm.beginTransaction();
        p.getChamadas().add(c);
        realm.commitTransaction();
    }
}

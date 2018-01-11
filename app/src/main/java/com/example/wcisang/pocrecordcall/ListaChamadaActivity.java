package com.example.wcisang.pocrecordcall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wcisang.pocrecordcall.adapter.ListChamadaAdapter;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmList;

public class ListaChamadaActivity extends AppCompatActivity {

    @BindView(R.id.lstChamadas) ListView listView;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_chamada_activity);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        String nomePessoa = bundle.getString("NomePessoa");
        Pessoa p = realm.where(Pessoa.class).contains("nome",nomePessoa).findFirst();

        RealmList chamadas = p.getChamadas();

        listView.setAdapter(new ListChamadaAdapter(this,chamadas));

    }
}

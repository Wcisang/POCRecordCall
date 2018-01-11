package com.example.wcisang.pocrecordcall;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.wcisang.pocrecordcall.adapter.ListPessoaAdapter;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    @BindView(R.id.listPessoa) ListView listView;
    @BindView(R.id.myFAB) FloatingActionButton fab;
    ListPessoaAdapter listPessoaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        checkPermission();

        realm = Realm.getDefaultInstance();

        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm element) {
                listPessoaAdapter.notifyDataSetChanged();
            }
        });

        final RealmResults<Pessoa> pessoas = realm.where(Pessoa.class).findAll();

        listPessoaAdapter = new ListPessoaAdapter(this,pessoas);
        listView.setAdapter(new ListPessoaAdapter(this,pessoas));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, ListaChamadaActivity.class);
                it.putExtra("NomePessoa",pessoas.get(position).getNome());
                startActivity(it);
            }
        });
    }

    @OnClick(R.id.myFAB)
    public void fabClick(){

        InsertPessoaDialog pessoaDialog = new InsertPessoaDialog(this);
        pessoaDialog.show();

    }

    public void checkPermission(){

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_PHONE_STATE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        2);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

    }
}

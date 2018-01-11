package com.example.wcisang.pocrecordcall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wcisang.pocrecordcall.R;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by wcisang on 07/01/17.
 */

public class ListPessoaAdapter extends RealmBaseAdapter<Pessoa> {


    OrderedRealmCollection<Pessoa> pessoas;
    Context context;

    public ListPessoaAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Pessoa> data) {
        super(context, data);
        this.context = context;
        this.pessoas = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_pessoas,parent,false);
            holder = new CustomHolder();
            convertView.setTag(holder);

            holder.nome = (TextView) convertView.findViewById(R.id.txtNome);
            holder.telefone = (TextView) convertView.findViewById(R.id.txtTelefone);

        }else{
            holder = (CustomHolder) convertView.getTag();
        }

        Pessoa pessoa = pessoas.get(position);

        holder.nome.setText(pessoa.getNome());
        holder.telefone.setText(pessoa.getTelefone());

        return convertView;
    }


    public static class CustomHolder{
        TextView nome;
        TextView telefone;
    }
}

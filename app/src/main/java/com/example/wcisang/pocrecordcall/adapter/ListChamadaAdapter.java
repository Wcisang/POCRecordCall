package com.example.wcisang.pocrecordcall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wcisang.pocrecordcall.R;
import com.example.wcisang.pocrecordcall.model.Chamada;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by wcisang on 08/01/17.
 */

public class ListChamadaAdapter extends RealmBaseAdapter<Chamada> {

    OrderedRealmCollection<Chamada> chamadas;


    public ListChamadaAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Chamada> data) {
        super(context, data);
        this.chamadas = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_chamadas,parent,false);
            holder = new Holder();
            holder.telefone = (TextView) convertView.findViewById(R.id.txtChamadaTelefone);
            holder.data = (TextView) convertView.findViewById(R.id.txtChamadaData);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        Chamada chamada = chamadas.get(position);

        holder.telefone.setText(chamada.getTelefone());
        holder.data.setText(chamada.getData().toString());

        return convertView;
    }


    public class Holder{

        TextView telefone;
        TextView data;

    }
}

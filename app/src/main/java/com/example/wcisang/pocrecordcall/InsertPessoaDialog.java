package com.example.wcisang.pocrecordcall;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import com.example.wcisang.pocrecordcall.dao.PessoaDAO;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by wcisang on 06/01/17.
 */

public class InsertPessoaDialog extends Dialog {

    @BindView(R.id.edt_nome) EditText edtNome;
    @BindView(R.id.edt_Numero) EditText edtNumero;




    public InsertPessoaDialog(Context context) {
        super(context);
    }

    public InsertPessoaDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected InsertPessoaDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_insert_pessoa);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_add)
    public void insertPessoa(){

        String nome = edtNome.getText().toString();
        String telefone = edtNumero.getText().toString();
        PessoaDAO dao = new PessoaDAO();
        dao.insert(new Pessoa(nome,telefone));

        dismiss();
    }
}

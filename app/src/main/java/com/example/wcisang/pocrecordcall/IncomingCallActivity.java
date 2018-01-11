package com.example.wcisang.pocrecordcall;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.wcisang.pocrecordcall.dao.ChamadaDAO;
import com.example.wcisang.pocrecordcall.dao.PessoaDAO;
import com.example.wcisang.pocrecordcall.model.Chamada;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncomingCallActivity extends AppCompatActivity {

    @BindView(R.id.txtNumeroChamada)
    TextView txtNumero;
    @BindView(R.id.txtPessoaChamada) TextView txtPessoa;

    String number;
    String p;
    Pessoa pessoa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);


        Bundle bundle = getIntent().getExtras();
        number = bundle.getString("Numero");
        p = bundle.getString("Pessoa");

        pessoa = new PessoaDAO().getPessoaByNumero(number);

        txtNumero.setText(number);
        txtPessoa.setText(p + " está cadastrado(a) no sistema, deseja salvar o registro da ligação?");



    }

    @OnClick(R.id.yesbutton)
    public void simClick(){
        ChamadaDAO dao = new ChamadaDAO();
        Chamada c = new Chamada();
        c.setTelefone(number);
        c.setData(new Date());
        dao.insertChamada(pessoa,c );
        finish();
    }


    @OnClick(R.id.nobutton)
    public void naoClick(){
        finish();
    }
}

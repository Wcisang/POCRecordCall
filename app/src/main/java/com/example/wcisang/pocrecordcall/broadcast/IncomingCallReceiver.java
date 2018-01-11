package com.example.wcisang.pocrecordcall.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wcisang.pocrecordcall.IncomingCallActivity;
import com.example.wcisang.pocrecordcall.MainActivity;
import com.example.wcisang.pocrecordcall.R;
import com.example.wcisang.pocrecordcall.dao.ChamadaDAO;
import com.example.wcisang.pocrecordcall.dao.PessoaDAO;
import com.example.wcisang.pocrecordcall.model.Chamada;
import com.example.wcisang.pocrecordcall.model.Pessoa;

import java.util.Date;
import java.util.Random;


/**
 * Created by wcisang on 04/01/17.
 */

public class IncomingCallReceiver extends BroadcastReceiver {


    Context context;
    private static Boolean isSecondTime = Boolean.FALSE;

    public IncomingCallReceiver() {
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        this.context = context;
        try {
            String estado = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String num = intent.getExtras().getString("incoming_number");
            if (estado.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE) && num != null) {
                    showScreen(context, num, intent);
            }

        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }


    }


    private void showScreen(Context context, final String number, Intent intent) {

        PessoaDAO pessoaDAO = new PessoaDAO();
        final Pessoa p = pessoaDAO.getPessoaByNumero(number);
        if (p != null) {

            Intent i = new Intent(context.getApplicationContext(), IncomingCallActivity.class);
            i.putExtras(intent);
            i.putExtra("Numero",number);
            i.putExtra("Pessoa",p.getNome());
            i.setClassName("com.example.wcisang.pocrecordcall", "com.example.wcisang.pocrecordcall.IncomingCallActivity");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }


}

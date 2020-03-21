package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Receptor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, Servicio.class);

        Bundle data = intent.getExtras();
        String action = data.getString("action");

        if(action.equals(context.getString(R.string.intentSonido))) {
            //Llamar al servicio
        }
        if(action.equals(context.getString(R.string.intentCancion))) {
            //Llamar al servicio
        }
        if(action.equals(context.getString(R.string.intentDetener))) {
            //Llamar al servicio
        }
    }
}

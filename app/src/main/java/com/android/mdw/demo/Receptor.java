package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receptor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, Servicio.class);

        Bundle data = intent.getExtras();
        String action = data.getString("action");

        if(intent.getAction() == null) {
            if(action.equals(context.getString(R.string.intentSonido))) {
                //Llamar al servicio
                Toast.makeText(context, R.string.serviceSonido, Toast.LENGTH_LONG).show();
                context.startService(intent);
            }
            if(action.equals(context.getString(R.string.intentCancion))) {
                //Llamar al servicio
                Toast.makeText(context, R.string.serviceCancion, Toast.LENGTH_LONG).show();
                context.startService(intent);
            }
            if(action.equals(context.getString(R.string.intentDetener))) {
                //Llamar al servicio
                Toast.makeText(context, R.string.serviceDetener, Toast.LENGTH_LONG).show();
                context.startService(intent);
            }
        }
        else {
            if(intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                //Cuando se conectan los auriculares
                if (intent.getIntExtra("state", 0) == 1){
                    Toast.makeText(context, R.string.auxOn, Toast.LENGTH_LONG).show();
                    intent.putExtra("action", context.getString(R.string.intentCancion));
                    context.startService(intent);
                }
                //Cuando se desconectan los auriculares
                else {
                    Toast.makeText(context, R.string.auxOff, Toast.LENGTH_LONG).show();
                    context.stopService(intent);
                }
            }
        }
    }
}

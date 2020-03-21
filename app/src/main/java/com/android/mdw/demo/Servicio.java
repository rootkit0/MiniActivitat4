package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class Servicio extends Service {

	private MediaPlayer sonido;
	private MediaPlayer cancion;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();
		sonido = MediaPlayer.create(this, R.raw.train);
		cancion = MediaPlayer.create(this, R.raw.rave4love);
		sonido.setLooping(true);
		cancion.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		sonido.stop();
		cancion.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		Bundle data = intent.getExtras();
		String action = data.getString("action");

		if(action.equals(getString(R.string.intentSonido))) {
			sonido.start();
		}
		else if(action.equals(getString(R.string.intentCancion))) {
			cancion.start();
		}
		else if(action.equals(getString(R.string.intentDetener))) {
			sonido.stop();
			cancion.stop();
		}
		return startid;
	}
}

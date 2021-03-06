package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class Servicio extends Service {

	private MediaPlayer sonido;
	private MediaPlayer cancion;
	//OPCIONAL
	private MediaPlayer uri;

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
		try{
			uri.stop();
		}
		catch(Exception e){

		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		Bundle data = intent.getExtras();
		String action = data.getString("action");

		if(action.equals(getString(R.string.intentSonido))) {
			sonido.start();
		}
		if(action.equals(getString(R.string.intentCancion))) {
			cancion.start();
		}
		if(action.equals(getString(R.string.intentDetener))) {
			sonido.stop();
			cancion.stop();
			try{
				uri.stop();
			}
			catch(Exception e){

			}
		}
		//OPCIONAL
		if(action.equals(R.string.intentUri)) {
			Uri cancion = intent.getData();
			uri = MediaPlayer.create(this, cancion);
			uri.setLooping(true);
			uri.start();
		}
		return startid;
	}
}

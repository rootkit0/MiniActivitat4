package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
  private Intent in;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button btnReproducirSonido = (Button) findViewById(R.id.btnReproducirSonido);
    Button btnReproducirCancion = (Button) findViewById(R.id.btnReproducirCancion);
    Button btnDetener = (Button) findViewById(R.id.btnDetener);
    Button btnSeleccionarCancion = (Button) findViewById(R.id.btnSeleccionarCancion);
    Button btnReproducirSeleccion = (Button) findViewById(R.id.btnReproducirSeleccion);

    btnReproducirSonido.setOnClickListener(this);
    btnReproducirCancion.setOnClickListener(this);
    btnDetener.setOnClickListener(this);
    btnSeleccionarCancion.setOnClickListener(this);
    btnReproducirSeleccion.setOnClickListener(this);
  }

  @Override
  public void onClick(View src) {
    Intent in;

    switch (src.getId()) {
      case R.id.btnReproducirSonido:
        //Llamada al servicio
        //Toast.makeText(this, R.string.toastSonido, Toast.LENGTH_LONG).show();
        //in = new Intent(this, Servicio.class);
        //in.putExtra("action", getString(R.string.intentSonido));
        //startService(in);
        //Llamada al receptor y este llama al servicio
        Toast.makeText(this, R.string.toastSonido, Toast.LENGTH_LONG).show();
        in = new Intent(this, Receptor.class);
        in.putExtra("action", getString(R.string.intentSonido));
        sendBroadcast(in);
        break;
      case R.id.btnReproducirCancion:
        //Llamada al servicio
        //Toast.makeText(this, R.string.toastCancion, Toast.LENGTH_LONG).show();
        //in = new Intent(this, Servicio.class);
        //in.putExtra("action", getString(R.string.intentCancion));
        //startService(in);
        //Llamada al receptor y este llama al servicio
        Toast.makeText(this, R.string.toastCancion, Toast.LENGTH_LONG).show();
        in = new Intent(this, Receptor.class);
        in.putExtra("action", getString(R.string.intentSonido));
        sendBroadcast(in);
        break;
      case R.id.btnDetener:
        //Llamada al servicio
        //Toast.makeText(this, R.string.toastDetener, Toast.LENGTH_LONG).show();
        //in = new Intent(this, Servicio.class);
        //stopService(in);
        //Llamada al receptor y este llama al servicio
        Toast.makeText(this, R.string.toastDetener, Toast.LENGTH_LONG).show();
        in = new Intent(this, Receptor.class);
        in.putExtra("action", getString(R.string.intentDetener));
        sendBroadcast(in);
        break;
      case R.id.btnSeleccionarCancion:
        break;
      case R.id.btnReproducirSeleccion:
        break;
    }
  }
}
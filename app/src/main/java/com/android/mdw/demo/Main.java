package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
    switch (src.getId()) {
      case R.id.btnReproducirSonido:
        break;
      case R.id.btnReproducirCancion:
        break;
      case R.id.btnDetener:
        break;
      case R.id.btnSeleccionarCancion:
        break;
      case R.id.btnReproducirSeleccion:
        break;
    }
  }
}
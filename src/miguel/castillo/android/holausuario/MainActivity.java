package miguel.castillo.android.holausuario;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Obtenermos los controles del Layout
		final EditText TxtName = (EditText) findViewById(R.id.TxtName);
		final Button BtnHello = (Button) findViewById(R.id.BtnHello);

		BtnHello.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Creamos el Intent (Que es el objeto necesario para enviar
				// datos entre dos Activity)
				// Existen carias cariantes de Intent, cada una de ellas
				// oriantada a distintas acciones.
				Intent intent = new Intent(MainActivity.this, FrmSaludo.class);

				// Creamos la información a pasar entre actividades (Datos a
				// mandar, que contiene una lista clave, valor)
				Bundle b = new Bundle();
				b.putString("NAME", TxtName.getText().toString());

				// Añadimos la información del bundle al intent
				intent.putExtras(b);

				// Iniciamos la nueva actividad
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

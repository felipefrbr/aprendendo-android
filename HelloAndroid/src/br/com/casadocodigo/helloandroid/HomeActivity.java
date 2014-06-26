package br.com.casadocodigo.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends ActionBarActivity {

	private EditText nomeEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		
		this.nomeEditText = (EditText) findViewById(R.id.nomeEditText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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

	public void supreenderUsuario(View v){
		
		String nome = nomeEditText.getText().toString();

		Intent intent = new Intent(SaudacaoActivity.ACAO_EXIBIR_SAUDACAO);
		
		intent.addCategory(SaudacaoActivity.CATEGORIA_SAUDACAO);
		
		intent.putExtra(SaudacaoActivity.EXTRA_NOME_USUARIO, nome);
		
		startActivity(intent);
		
	}
}

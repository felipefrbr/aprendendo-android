package br.com.casadocodigo.boaviagem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.com.casadocodigo.boaviagem.R;

public class BoaViagemActivity extends Activity {

	private EditText usuario;
	private EditText senha;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		usuario = (EditText) findViewById(R.id.usuario);
		senha = (EditText) findViewById(R.id.senha);
		
	}
	
	public void entrarOnClick(View v){
		
		System.out.println(usuario.getText().toString());
		System.out.println(senha.getText().toString());
		
	}
}

package br.com.casadocodigo.boaviagem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import br.com.casadocodigo.boaviagem.R;

public class DashboardActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}
	
	public void selecionarOpcao(View v){
		TextView textView = (TextView) v;
		Toast toast = Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT);
		toast.show();
	}
}

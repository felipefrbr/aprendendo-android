package br.com.casadocodigo.boaviagem.activity;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GastoListActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarGastos()));
		
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		TextView textView = (TextView) view;
		String mensagem = "Gasto selecionado: " + textView.getText().toString();
		
		Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_LONG);
		toast.show();
	}

	private List<String> listarGastos(){
		return Arrays.asList("Sanduíche R$ 19,90","Táxi Aeroporto - Hotel R$ 34,00","Revista R$ 12,00");
	}
}

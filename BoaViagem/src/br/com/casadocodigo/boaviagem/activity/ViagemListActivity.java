package br.com.casadocodigo.boaviagem.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import br.com.casadocodigo.boaviagem.R;

public class ViagemListActivity extends ListActivity implements
		OnItemClickListener {

	private List<Map<String,Object>> viagens;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] de = {"imagem", "destino", "data", "total"};
		int[] para = {R.id.tipoViagem, R.id.destino, R.id.data, R.id.valor};
		SimpleAdapter adapter =	new SimpleAdapter(this, listarViagens(),R.layout.lista_viagem, de, para);
		
		setListAdapter(adapter);
		
		ListView listView = getListView();
		listView.setOnItemClickListener(this);

	}

	private List<Map<String, Object>> listarViagens() {
		viagens = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.ic_launcher);
		item.put("destino", "S�o Paulo");
		item.put("data","02/02/2012 a 04/02/2012");
		item.put("total","Gasto total R$ 314,98");
		viagens.add(item);
		
		item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.ic_launcher);
		item.put("destino", "Macei�");
		item.put("data","14/05/2012 a 22/05/2012");
		item.put("total","Gasto total R$ 25834,67");
		viagens.add(item);
		
		return viagens;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {

		Map<String, Object> viagem = viagens.get(position);
		String mensagem = "Viagem selecionada: " +  viagem.get("destino");
		
		Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_LONG);
		toast.show();
				
		
		startActivity(new Intent(this, GastoListActivity.class));
		
	}
}

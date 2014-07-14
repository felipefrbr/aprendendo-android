package br.com.casadocodigo.boaviagem.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;
import br.com.casadocodigo.boaviagem.R;

public class GastoListActivity extends ListActivity implements OnItemClickListener {

	private ArrayList<Map<String, Object>> gastos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		String[] de = {"data", "descricao", "valor", "categoria"};
		int[] para = {R.id.data, R.id.descricao, R.id.valor, R.id.categoria};
		
		SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(), R.layout.lista_gasto, de, para);
		adapter.setViewBinder(new GastoViewBinder());
		
		setListAdapter(adapter);
		
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		Map<String, Object> gasto = gastos.get(position);
		String mensagem = "Gasto selecionado: " + gasto.get("descricao");
		
		Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_LONG);
		toast.show();
	}

	private List<Map<String, Object>> listarGastos(){
		
		gastos = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("data", "04/02/2012");
		item.put("descricao", "Di�ria Hotel");
		item.put("valor", "R$ 260,00");
		item.put("categoria", R.color.categoria_hospedagem);
		gastos.add(item);
		
		item = new HashMap<String, Object>();
		item.put("data", "03/02/2012");
		item.put("descricao", "Wifi");
		item.put("valor", "R$ 7,00");
		item.put("categoria", R.color.categoria_outros);
		gastos.add(item);

		item = new HashMap<String, Object>();
		item.put("data", "02/02/2012");
		item.put("descricao", "Taxi Aeroporto-Hotel");
		item.put("valor", "R$ 34,00");
		item.put("categoria", R.color.categoria_transporte);
		gastos.add(item);

		item = new HashMap<String, Object>();
		item.put("data", "02/02/2012");
		item.put("descricao", "Sanduiche");
		item.put("valor", "R$ 19,90");
		item.put("categoria", R.color.categoria_alimentacao);
		gastos.add(item);
		
		return gastos;
	}
	
	
	private class GastoViewBinder implements ViewBinder {
		
		private String dataAnterior = "";
		
		@Override
		public boolean setViewValue(View view, Object data,
				String textRepresentation) {
			
			if(view.getId() == R.id.data){
				
				if(!dataAnterior.equals(data)){
					TextView textView = (TextView) view;
					textView.setText(textRepresentation);
					dataAnterior = textRepresentation;
					view.setVisibility(View.VISIBLE);
				} else {
					view.setVisibility(View.GONE);
				}
				return true;
			}
			if(view.getId() == R.id.categoria){
				Integer id = (Integer) data;
				view.setBackgroundColor(getResources().getColor(id));
				return true;
			}
			return false;
		}
	}
	
	
}

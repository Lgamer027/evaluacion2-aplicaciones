package cl.inacap.listadecompras;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cl.inacap.listadecompras.MODELO.ListadeCompras;
import cl.inacap.listadecompras.MODELO.Producto;

public class ListaProductosActivity extends ListActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista() {
        lista = getListView();

        ArrayList<Producto> productos= ListadeCompras.getInstancia().getListadeCompras();

        ArrayAdapter<Producto> listaAdapter = new ArrayAdapter<Producto>(this,
                android.R.layout.simple_list_item_1,
                productos);

        lista.setAdapter(listaAdapter);

    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id) {
        Intent intent = new Intent(ListaProductosActivity.this, DetallesActivity.class);
        intent.putExtra("idProducto", (int) id);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (resultCode == RESULT_OK) {
                cargarLista();
            }
        }
    }
}

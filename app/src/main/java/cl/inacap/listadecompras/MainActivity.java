package cl.inacap.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.listadecompras.MODELO.ListadeCompras;
import cl.inacap.listadecompras.MODELO.Producto;

public class MainActivity extends AppCompatActivity {

    private ListadeCompras listadeCompras=ListadeCompras.getInstancia();
    private ArrayList<Producto> productos=listadeCompras.getListadeCompras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ver_lista=(Button) findViewById(R.id.ver_lista);
        ver_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productos.size()>0){
                    Intent intent = new Intent(MainActivity.this, ListaProductosActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText( MainActivity.this, "La lista esta vasia", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button botonNuevo=(Button) findViewById(R.id.botonNuevo);
        botonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NuevoProductoActivity.class);
                startActivity(intent);
            }
        });

        Button botonEliminar=(Button) findViewById(R.id.botonEliminar);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listadeCompras.eliminarComprados();
                Toast.makeText(MainActivity.this, "Se han eliminado todos los productos comprados", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
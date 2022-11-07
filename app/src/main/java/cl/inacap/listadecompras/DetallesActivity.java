package cl.inacap.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.inacap.listadecompras.MODELO.ListadeCompras;
import cl.inacap.listadecompras.MODELO.Producto;

public class DetallesActivity extends AppCompatActivity {

    public Producto producto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");
        //producto=Producto.productos[id];

        producto= ListadeCompras.getInstancia().getProducto(id);

        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());


        TextView txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtCantidad.setText("cantidad: "+producto.getCantidad()+" "+producto.getUnidad());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);
        if(producto.isEstado()==Producto.COMPRADO)
        {
            txtEstado.setText("Estado: COMPRADO");
            estado.setText("Marcar como Pendiente");
        }
        else
        {
            txtEstado.setText("Estado: PENDIENTE");
            estado.setText("Marcar como Comprado");
        }
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto.setEstado(!producto.isEstado());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
package cl.inacap.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.listadecompras.MODELO.ListadeCompras;
import cl.inacap.listadecompras.MODELO.Producto;

public class NuevoProductoActivity extends AppCompatActivity {

    private ListadeCompras listadeCompras=ListadeCompras.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);
        Button botonIngresarProducto=(Button) findViewById(R.id.botonIngresarProducto);
        botonIngresarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarProducto(view);
            }
        });
    }

    public void ingresarProducto(View view)
    {
        String nombre = ((Spinner) findViewById(R.id.ingresarProducto)).getSelectedItem().toString();
        String cantidadStr = ((TextView) findViewById(R.id.ingresarCantidad)).getText().toString();
        String unidad = ((Spinner) findViewById(R.id.ingresarCategoria)).getSelectedItem().toString();

        if (cantidadStr.isEmpty()) {
            Toast.makeText(this, "Ingrese la cantidad", Toast.LENGTH_SHORT).show();
        }
        else{


            int cantidad=Integer.parseInt(cantidadStr);

            if(cantidad<=0)
            {
                Toast.makeText(this, "La cantidad debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            }
            else if(nombre.isEmpty())
            {
                Toast.makeText(this, "Debe seleccionar el producto", Toast.LENGTH_SHORT).show();
            }

            else {

                Producto producto = new Producto(nombre, cantidad, unidad);
                listadeCompras.agregarProducto(producto);
                finish();
            }

        }
    }

}
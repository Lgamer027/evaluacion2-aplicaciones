package cl.inacap.listadecompras.MODELO;

import java.util.ArrayList;

public class ListadeCompras {
    private static ListadeCompras instancia=new ListadeCompras();
    private ArrayList<Producto> listadeCompras;

    private ListadeCompras() {
        listadeCompras=new ArrayList<>();



    }
    public static ListadeCompras getInstancia()
    {
        return instancia;
    }

    public void agregarProducto(Producto producto)
    {
        listadeCompras.add(producto);
    }

    public Producto getProducto(int id)
    {
        return listadeCompras.get(id);
    }
    public ArrayList<Producto> getListadeCompras()
    {
        return listadeCompras;
    }

    public void eliminarComprados()
    {
        for(int i=0; i<listadeCompras.size();i++)
        {
            if(listadeCompras.get(i).isEstado()==Producto.COMPRADO)
            {
                listadeCompras.remove(i);
                i--;
            }
        }
    }

}

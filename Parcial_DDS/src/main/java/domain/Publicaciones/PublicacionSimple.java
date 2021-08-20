package domain.Publicaciones;

import domain.Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class PublicacionSimple implements Publicacion{

  private Producto productoUnico;

    public PublicacionSimple(Producto producto){this.productoUnico = producto;}

    @Override
    public Integer costo(){
        return productoUnico.getPrecio();
    }
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaDeProductos = new ArrayList<Producto>();
        listaDeProductos.add(productoUnico);
        return listaDeProductos;
    }
}



package domain.Publicaciones;

import domain.Productos.Producto;

import java.util.List;

public abstract class PublicacionSimple {

  private Producto productoUnico;
  private List<Producto> listaDeProductos;


    public Double costo(){
        return productoUnico.getPrecio();
    }

    public List<Producto> getProductos() {
        listaDeProductos.add(productoUnico);
        return listaDeProductos;
    }
}



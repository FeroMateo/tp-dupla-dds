package domain.Publicaciones;

import domain.Pedido;
import domain.Productos.Producto;

import java.util.List;

public interface Publicacion {

    public Integer costo();
    public List<Producto> getProductos();

}

package domain.Publicaciones;

import domain.Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class PublicacionCombo implements Publicacion{

     private List<Producto> productos = new ArrayList<Producto>();
     Integer cantidadProductos;


     public PublicacionCombo(List<Producto> listaProd){this.productos = listaProd;}

     public Integer sumaDeCostos(){
          return productos.stream()
                  .mapToInt(producto -> producto.precio())
                  .sum();
     }

     @Override
     public Integer costo(){
    cantidadProductos = productos.size();
    if(cantidadProductos<=2){
         return sumaDeCostos();
    }else if(cantidadProductos>2 && cantidadProductos<=4){
         return (int)(sumaDeCostos() * 0.90);
    }else{
         return (int)(sumaDeCostos() * 0.85);
         }
     }
    @Override
    public List<Producto> getProductos() {
        return productos;
    }
}

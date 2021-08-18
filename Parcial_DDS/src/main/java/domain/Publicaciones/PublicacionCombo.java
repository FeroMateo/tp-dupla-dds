package domain.Publicaciones;

import domain.Productos.Producto;

import java.util.List;

public abstract class PublicacionCombo implements Publicacion{

     private List<Producto> productos;
     Integer cantidadProductos = productos.size();


     public Double sumaDeCostos(){
          return productos.stream()
                  .mapToDouble(producto -> producto.getPrecio())
                  .sum();
     }

     @Override
     public Double costo(){

    if(cantidadProductos<=2){
         return sumaDeCostos();
    }else if(cantidadProductos>2 && cantidadProductos<=4){
         return sumaDeCostos() * 0.90;
    }else{
         return sumaDeCostos() * 0.85;
         }
     }
    @Override
    public List<Producto> getProductos() {
        return productos;
    }
}

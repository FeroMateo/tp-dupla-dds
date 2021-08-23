package Controladores;

import domain.Productos.Producto;

import java.util.List;

public class ObserverProveedor {

    public void notificarProv(List<Producto> listaProductos,ControladorNotificaciones controlador){

     for(Producto prod: listaProductos) {
         controlador.notificarProveedorWP(prod);
     }
    }
}

package Controladores;

import domain.Pedido;
import domain.Productos.Producto;

import java.util.List;

public class ObserverProveedor {

    private Pedido pedido;

    public void notificarProv(List<Producto> listaProductos,ControladorNotificaciones controlador){

     for(Producto prod: listaProductos) {
         controlador.notificarProveedorWP(prod);
     }
    }
    public void setObservador(Pedido pedidoNuevo){
        this.pedido = pedidoNuevo;

    }
    public void update(){
        while(true){
            if(){

            }
        }
    }
}

package Controladores;

import domain.Pedido;
import domain.Productos.Producto;

import java.util.List;

public class ObserverProveedor {

    private Pedido pedido;
    private ControladorNotificaciones controlador;

    Runnable tarea = () ->
    {
        System.out.println("SE CREO EL HILO");
        this.update();
    };

    public void iniciarObserver(Pedido pedidoNuevo,ControladorNotificaciones control)
    {
     this.pedido = pedidoNuevo;
     this.controlador = control;
     Thread hilo = new Thread(tarea);

     hilo.start();

    }

    public void update(){

        while (true) {
            try {
                Thread.sleep(10); // for 100 FPS
            } catch (InterruptedException ignore) {
            }
            if(pedido.consultarSiReponerStock())
            {
                System.out.println("Notificando proveedor..");
                controlador.notificarProveedorWP();
                pedido.seContactoConProveedor();
            }
        }
    }
}

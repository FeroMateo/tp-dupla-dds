package domain;

import Controladores.ControladorNotificaciones;
import Controladores.DatabaseController;
import domain.Productos.Producto;
import domain.Publicaciones.Publicacion;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public List<Producto> productos = new ArrayList<Producto>();
    public List<Publicacion> publicaciones = new ArrayList<Publicacion>();
    private Integer costoTotal;

    ControladorNotificaciones notificaciones = new ControladorNotificaciones();

    DatabaseController controlador = new DatabaseController();
    Connection con = controlador.conectarDataBase();

    public void agregarProductosPublicacion(List<Producto> listaProductos)
    {
        for(Producto prod: listaProductos)
        {
            agregarProducto(prod);
        }
    }

    public Integer costo()
    {
        Integer valorTotal = 0;
        for (Publicacion pub: publicaciones)
        {
            valorTotal = valorTotal + pub.costo();
        }
        System.out.println(valorTotal);
        return valorTotal;
    }

    public void recibirPedido()
    {
        if(productos.stream().allMatch(prod->controlador.hayStockDelProducto(con,prod)))
        {
            System.out.println("SE CONFIRMA EL PEDIDO");
            confirmarPedido();
            //NOTIFICAR CLIENTE Y REPARTIDOR
            notificaciones.notificarClienteWP(123);
            notificaciones.notificarRepartidorWP("IRIGOYEN 463",123);

        }else
        {
           System.out.println("NO HAY STOCK PARA ESE PEDIDO");
        }
    }

    public void agregarPublicacion(Publicacion publicacion)
    {
        publicaciones.add(publicacion);
        agregarProductosPublicacion(publicacion.getProductos());
    }

    public void agregarProducto(Producto producto)
    {
        productos.add(producto);
        System.out.println("SE AGREGO UN PRODUCTO");
    }

    public void confirmarPedido()
    {
        for(Producto prod: productos)
        {
            controlador.actualizarStockProducto(con,prod);
        }
        this.costoTotal = costo();
    }
}

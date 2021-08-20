package domain;

import Controladores.ControladorNotificaciones;
import Controladores.DatabaseController;
import domain.Productos.Producto;
import domain.Publicaciones.Publicacion;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class Pedido {
    public List<Producto> productos = new ArrayList<Producto>();
    public List<Publicacion> publicaciones = new ArrayList<Publicacion>();
    private Integer costoTotal;
    private Integer id_pedido;

    ControladorNotificaciones notificaciones = new ControladorNotificaciones();

    DatabaseController controlador = new DatabaseController();
    Connection con = controlador.conectarDataBase();

    public Integer crearID_PEDIDO()
    {
        Random random = new Random();
        int numero = random.nextInt(100000);
        this.id_pedido = numero;
        System.out.println(numero);
        return numero;
    }

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

    public void recibirPedido(String direccion)
    {
        if(productos.stream().allMatch(prod->controlador.hayStockDelProducto(con,prod)))
        {
            System.out.println("SE CONFIRMA EL PEDIDO");
            confirmarPedido();
            //NOTIFICAR CLIENTE Y REPARTIDOR
            notificaciones.notificarClienteWP(this.id_pedido);
            notificaciones.notificarRepartidorWP(direccion,this.id_pedido);

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

        controlador.cargarPedido(con,this.id_pedido,this.costoTotal);
    }
}

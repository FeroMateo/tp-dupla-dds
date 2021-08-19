package domain;

import Controladores.DatabaseController;
import domain.Productos.Producto;
import domain.Publicaciones.Publicacion;

import java.sql.Connection;
import java.util.List;

public class Pedido {
    List<Producto> productos;
    private Integer costoTotal;
    private Publicacion tipoPedido;

    DatabaseController controlador = new DatabaseController();
    Connection con = controlador.conectarDataBase();

    public void recibirPedido()
    {
        if(productos.stream().allMatch(prod->controlador.hayStockDelProducto(con,prod)))
        {
            System.out.println("SE CONFIRMA EL PEDIDO");
        }else
        {
           System.out.println("NO HAY STOCK PARA ESE PEDIDO");
        }
    }
    public void agregarProducto(Producto producto)
    {
        productos.add(producto);
    }
    public void confirmarPedido()
    {
        for(Producto prod: productos)
        {
            controlador.actualizarStockProducto(con,prod);
        }
    }

    public void setProductos() {
        tipoPedido.getProductos();
    }
}

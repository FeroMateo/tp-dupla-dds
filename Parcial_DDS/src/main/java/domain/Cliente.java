package domain;
import com.sun.java.swing.plaf.windows.WindowsIconFactory;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import domain.Productos.Producto;
import Controladores.DatabaseController;

import java.util.Date;
import java.util.List;




public class Cliente {

    private Pedido pedidoActual;
    private List<Pedido> historicoPedidos;

    public Pedido iniciarPedido()
    {
        return new Pedido();
    }
    public void agregarProducto(Pedido pedido,Producto producto)
    {
        pedido.agregarProducto(producto);
    }

    public void confirmarCompra(Pedido pedido)
    {
        pedido.recibirPedido();
    }

    public void comprarGolosinas()
    {
        Pedido pedido = iniciarPedido();
        Producto golosina = new Producto();
        golosina.nombre = "golosina";
        golosina.cantidad = 20;
        golosina.precio = 1;

        agregarProducto(pedido,golosina);
        //confirmarCompra(pedido);
    }
}

package domain;
import com.sun.java.swing.plaf.windows.WindowsIconFactory;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import domain.Productos.Producto;
import Controladores.DatabaseController;
import domain.Publicaciones.Publicacion;
import domain.Publicaciones.PublicacionCombo;
import domain.Publicaciones.PublicacionSimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;




public class Cliente {

    private Pedido pedidoActual;
    private List<Pedido> historicoPedidos = new ArrayList<Pedido>();

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
        historicoPedidos.add(pedido);
    }
    public Publicacion publicacionOreo(Integer cantidad)
    {
        Producto oreos = new Producto();
        oreos.crearse("oreos",cantidad,100);
        return new PublicacionSimple(oreos);
    }

    public void agregarPublicacionAPedido(Pedido pedido, Publicacion publicacion)
    {
        pedido.agregarPublicacion(publicacion);
    }

    public void comprarGolosinas()
    {
        Pedido pedido = iniciarPedido();
        agregarPublicacionAPedido(pedido,publicacionOreo(20));

        confirmarCompra(pedido);
    }
}

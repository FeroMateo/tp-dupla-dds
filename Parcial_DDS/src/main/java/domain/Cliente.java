package domain;
import com.sun.java.swing.plaf.windows.WindowsIconFactory;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import domain.Productos.Producto;
import Controladores.DatabaseController;

import java.util.ArrayList;
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

    public void comprarGolosinas()
    {
        Pedido pedido = iniciarPedido();
        Producto golosina = new Producto();
        golosina.crearse("golosina",20,1);
        Producto oreos = new Producto();
        oreos.crearse("oreos",200,1);
        Producto melba = new Producto();
        melba.crearse("melba",20,1);
        Producto rumba = new Producto();
        rumba.crearse("rumba",20,1);

        pedido.agregarProducto(golosina);
        pedido.agregarProducto(oreos);
        pedido.agregarProducto(melba);
        pedido.agregarProducto(rumba);
        confirmarCompra(pedido);
    }
}

package Controladores;
import domain.Repartidores.Disponibilidad.Disponible;
import domain.Repartidores.Disponibilidad.Viajando;
import domain.Repartidores.Repartidor;

import java.util.ArrayList;
import java.util.List;

public class ControladorDelivery {

    private List<Repartidor> deliverys = new ArrayList<Repartidor>();

    public void instanciarDeliverys()
    {
        Repartidor mateo = new Repartidor();
        mateo.Repartidor(new Viajando(),"1123732266");
        Repartidor bruno = new Repartidor();
        bruno.Repartidor(new Disponible(),"1132027257");

        deliverys.add(mateo);
        deliverys.add(bruno);

    }


    public void confirmarDelivery(ControladorNotificaciones controlNotific,String ubicacion,Integer id_pedido){

        for(Repartidor repartidor: deliverys)
        {
            if(repartidor.estado.confirmarDisponibilidad())
            {
                System.out.println(repartidor.telefono);
                controlNotific.notificarRepartidorWP(ubicacion,id_pedido,repartidor.telefono);
                break;
            }
        }
    }
}

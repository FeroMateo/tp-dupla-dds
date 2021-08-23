package Controladores;
import domain.Repartidores.Disponibilidad.Disponible;
import domain.Repartidores.Disponibilidad.Viajando;
import domain.Repartidores.Repartidor;

import java.util.ArrayList;
import java.util.List;

public class ControladorDelivery {

    private List<Repartidor> deliverys = new ArrayList<Repartidor>();
    private List<Repartidor> deliverysDisponibles = new ArrayList<Repartidor>();

    public void instanciarDeliverys()
    {
        Repartidor mateo = new Repartidor();
        mateo.Repartidor(new Disponible());
        Repartidor bruno = new Repartidor();
        bruno.Repartidor(new Viajando());

        deliverys.add(mateo);
        deliverys.add(bruno);

    }


    public void confirmarDelivery(ControladorNotificaciones controlNotific,String ubicacion,Integer id_pedido){

        //deliverysDisponibles = (List<Repartidor>) deliverys.stream().filter(repartidor -> repartidor.estado.confirmarDisponibilidad());

        controlNotific.notificarRepartidorWP(ubicacion,id_pedido);
    }
}

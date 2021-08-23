package Controladores;
import domain.Repartidores.Repartidor;

import java.util.List;

public class ControladorDelivery {

    private List<Repartidor> deliverys;
    private List<Repartidor> deliverysDisponibles;

    public void confirmarDelivery(ControladorNotificaciones controlNotific,String ubicacion,Integer id_pedido){

    deliverysDisponibles = (List<Repartidor>) deliverys
            .stream()
            .filter(repartidor -> repartidor.estado.confirmarDisponibilidad());


       controlNotific.notificarRepartidorWP(ubicacion,id_pedido);
    }
}

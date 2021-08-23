package domain.Repartidores;

import domain.Repartidores.Disponibilidad.Disponibilidad;
import domain.Pedido;
import domain.Repartidores.Disponibilidad.NoDisponible;

public class Repartidor {
    public Disponibilidad estado;
    public  Pedido pedido;


    public void Repartidor(Disponibilidad disponibilidad)
    {
        this.estado = disponibilidad;
    }

    public void repartir(String direccion){

        this.estado = new NoDisponible();

    }
}


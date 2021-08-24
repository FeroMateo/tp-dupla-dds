package domain.Repartidores;

import domain.Repartidores.Disponibilidad.Disponibilidad;
import domain.Pedido;
import domain.Repartidores.Disponibilidad.NoDisponible;

public class Repartidor {
    public Disponibilidad estado;
    public String telefono;

    public void Repartidor(Disponibilidad disponibilidad,String numero)
    {
        this.estado = disponibilidad;
        this.telefono = numero;
    }

    public void repartir(String direccion){

        this.estado = new NoDisponible();

    }
}


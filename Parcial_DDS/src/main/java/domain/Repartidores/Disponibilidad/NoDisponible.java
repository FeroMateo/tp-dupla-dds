package domain.Repartidores.Disponibilidad;

public class NoDisponible extends Disponibilidad{

    @Override
    public Boolean confirmarDisponibilidad(){
        return false;
    }
}

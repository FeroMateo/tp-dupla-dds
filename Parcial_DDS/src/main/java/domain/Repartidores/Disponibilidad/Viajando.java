package domain.Repartidores.Disponibilidad;

public class Viajando extends Disponibilidad {
    @Override
    public Boolean confirmarDisponibilidad(){
        return false;
    }
}

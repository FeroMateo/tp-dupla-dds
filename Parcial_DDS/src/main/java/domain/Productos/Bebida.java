package domain.Productos;

public class Bebida extends Producto {


    private Double litros;
    private Double litrosTotales = litros * cantidad;
    @Override
    public Integer precio() {

        if(litrosTotales<3){
            return precio * cantidad;
        }else{
            return (int) (precio * cantidad * 0.90);
        }
    }
}

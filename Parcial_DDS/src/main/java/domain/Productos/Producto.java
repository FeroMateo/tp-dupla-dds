package domain.Productos;

import java.security.SecureRandom;

public class Producto {

    public String nombre;
    public Integer precio;
    public Integer cantidad;

    public Integer getCantidad(){return cantidad;}
    public String getNombre() { return nombre; }
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}

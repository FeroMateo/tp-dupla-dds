package domain.Productos;

import java.security.SecureRandom;

public class Producto {

    public String nombre;
    public Integer precio;
    public Integer cantidad;

    public Integer getCantidad(){return cantidad;}
    public String getNombre() { return nombre; }
    public Integer precio() {
        return precio * cantidad;
    }

    public void crearse(String name,Integer cant,Integer price)
    {
        nombre = name;
        cantidad = cant;
        precio = price;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}

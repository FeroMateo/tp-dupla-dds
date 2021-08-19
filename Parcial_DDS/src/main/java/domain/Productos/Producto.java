package domain.Productos;

import java.security.SecureRandom;

public class Producto {

    private String nombre;
    private Integer precio;
    private Integer cantidad;

    public Integer getCantidad(){return cantidad;}
    public String getNombre() { return nombre; }
    public Integer getPrecio() {
        return precio;
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

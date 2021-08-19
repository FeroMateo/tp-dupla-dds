package Controladores;

import domain.Productos.Producto;

import java.sql.*;

public class DatabaseController {

    public Connection conectarDataBase()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/trabajodupla","root", "");
            System.out.println("BASE CONECTADA PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!");
            return conn;
        }
        catch(Exception e) {
            System.out.println("Do not connect to DB - Error:"+e);
            return null;
        }
    }

    public void leerPedidos(Connection connection)
    {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `pedido`");

            resultSet.next();
            System.out.println(resultSet.getString("id_pedido"));
            }
        catch (SQLException ex)
        {
            System.out.println("Do not connect to DB - Error:"+ex);
        }

    }
    public Boolean hayStockDelProducto(Connection connection, Producto prod)
    {
        String producto = prod.getNombre();
        Integer cantidad = prod.getCantidad();
        try {
            Statement statement = connection.createStatement();

            String sentencia = String.format("SELECT * FROM `stock` WHERE `producto` LIKE '%s'", producto);

            ResultSet resultSet = statement.executeQuery(sentencia);

            resultSet.next();

            Integer valor = resultSet.getInt("cantidad");
            if (valor <= cantidad)
            {
                System.out.println("ERROR: NO HAY MAS STOCK");
                return false;
            }else
            {
                System.out.println("HAY STOCK");
                return true;
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR:"+ex);
            return false;
        }

    }

    public void actualizarStockProducto(Connection connection,Producto prod)
    {
        String producto = prod.getNombre();
        Integer cantidad = prod.getCantidad();

        try {
            Statement statement = connection.createStatement();

            String sentencia = String.format("SELECT * FROM `stock` WHERE `producto` LIKE '%s'", producto);


            ResultSet resultSet = statement.executeQuery(sentencia);
            resultSet.next();
            Integer valor = resultSet.getInt("cantidad");
            valor = valor - cantidad;
            if(valor<0)
                valor=0;
            System.out.println(valor);
            String sentencia2 = String.format("UPDATE stock SET cantidad = %d WHERE producto = '%s'", valor,producto);

            Statement statement1 = connection.createStatement();
            Integer funco =  statement1.executeUpdate(sentencia2);
            System.out.println("SE ACTUALIZO EL STOCK");
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR:"+ex);
        }

    }

}




package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {

public void main(String[] args)
    {
     try
        {
            Connection connection =  DriverManager.getConnection("http://localhost:3306/phpmyadmin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM 'pedido'");

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("id_pedido"));
            }
        }catch (Exception e)
     {
         e.printStackTrace();
     }
    }
}

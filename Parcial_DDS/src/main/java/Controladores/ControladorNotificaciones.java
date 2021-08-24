package Controladores;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import domain.Productos.Producto;

public class ControladorNotificaciones {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC41023bd65e9f12d9ae58b997b747c989";
    public static final String AUTH_TOKEN = "9f0177019bca7d46ebba123c211679e6";

    public void notificarClienteSMS(Integer id_pedido){

        String mensaje = String.format("PEDIDO NUMERO: %d CONFIRMADO, DEMORA ESTIMADA 10 MINUTOS",id_pedido);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+541132027257"),
                new com.twilio.type.PhoneNumber("+19713512077"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }
    public void notificarRepartidorSMS(String direccion,Integer id_pedido,String numero){

        String numero_spliteado = String.format("+54%s",numero);
        String mensaje = String.format("ENVIAR PEDIDO %d A %s EN MENOS DE 10 MINUTOS",id_pedido,direccion);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(numero_spliteado),
                new com.twilio.type.PhoneNumber("+19713512077"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }
    public void notificarClienteWP(Integer id_pedido){

        String mensaje = String.format("PEDIDO NUMERO: %d CONFIRMADO, DEMORA ESTIMADA 10 MINUTOS",id_pedido);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491132027257"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }
    public void notificarRepartidorWP(String direccion,Integer id_pedido,String numero){

        String numero_spliteado = String.format("whatsapp:+549%s",numero);
        String mensaje = String.format("ENVIAR PEDIDO %d A %s EN MENOS DE 10 MINUTOS",id_pedido,direccion);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(numero_spliteado),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }

//NOTIFICACIONES PROVEEDOR

    public void notificarProveedorWP(){

        String mensaje = String.format("Hola, necesitamos que se comuniquen con nosotros para agregar STOCK, DulceDeliver.");

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5491132027257"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }

    public void notificarProveedorSMS(){

        String mensaje = String.format("Hola, necesitamos que se comuniquen con nosotros para agregar STOCK, DulceDeliver.");

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+541123732266"),
                new com.twilio.type.PhoneNumber("+19713512077"),
                mensaje)
                .create();

        //System.out.println(message.getSid());
    }
}

package cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Conexion {

    protected final int PUERTO = 5600; //Puerto para la conexión
    protected final String HOST = "raspberry.myvnc.com"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataInputStream entradaCliente;
    protected DataOutputStream salidaCliente;
    
    public Conexion(String tipo) throws IOException {//Constructor    
        if (tipo.equalsIgnoreCase("servidor")) {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        }
    }
    
    public void conectar() throws IOException{       
        cs = new Socket(HOST, PUERTO);
    }
}

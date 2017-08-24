package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;




public class client extends Conexion implements Runnable {
    private String cmd;
    private String msg;

    public client() throws IOException {
        super("cliente");
    }

    public void run() {

        try {
            System.out.println("Abriendo conexion");
            super.conectar();
            salidaCliente = new DataOutputStream(cs.getOutputStream());
            cmd = "Client-> Encender led";
            salidaCliente.writeUTF(cmd);
            //entradaCliente = new DataInputStream(cs.getInputStream());
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while ((mensajeServidor = entrada.readLine()) != null){ //Mientras haya mensajes desde el cliente
                System.out.println(mensajeServidor);
            }
            cs.close();                      
        }catch (EOFException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }/* catch (InterruptedException ex) {

        }*/

    }

}

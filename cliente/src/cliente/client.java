package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;




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
            entradaCliente = new DataInputStream(cs.getInputStream());
            //Thread.sleep(500);
            msg = entradaCliente.readUTF();
            System.out.println(msg);
            cs.close();                      
        }catch (EOFException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }/* catch (InterruptedException ex) {

        }*/

    }

}

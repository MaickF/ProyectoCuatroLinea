/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
* @author Jorge V
*/
public class Cliente {
Socket client;
int puerto = 9000;
String ip = "localhost";
ObjectInputStream entrada;
ObjectOutputStream salida;

public void inicioCliente() throws IOException{
    ArrayList<String> lista = new ArrayList<String>();
    lista.add("EOOO");
    lista.add("CHINGASUMADRE");
    try{
        
        client = new Socket(ip,puerto);
        salida = new ObjectOutputStream(client.getOutputStream());
        salida.writeObject(lista);
        salida.flush();
        entrada = new ObjectInputStream(client.getInputStream());
        lista = (ArrayList<String>) entrada.readObject();
        System.out.println(lista.get(1));
        entrada.close();
        salida.close();
    }catch(Exception e){};
}

public static void main (String [ ] args) throws IOException {
    Cliente cli = new Cliente();
    cli.inicioCliente();
}


}

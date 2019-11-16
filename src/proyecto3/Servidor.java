/*+/
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;
import java.net.*;
import java.io.*;
/**
* @author Jorge V
*/
public class Servidor {
    ServerSocket serv;
    Socket socket;
    int puerto = 9000;
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    public void inicio() throws IOException{
    serv = new ServerSocket(puerto);
    socket = new Socket();
    try{
        while(true){
      
        
       
        socket = serv.accept();
        
        HiloServer hilo = new HiloServer(socket);
        hilo.start();
         
      }
    }catch(Exception e){};
    }
    
    public static void main (String [ ] args) throws IOException {
    Servidor cli = new Servidor();
    cli.inicio();
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Fabian
 */
public class HiloServer extends Thread{
    Socket cliente = null;
    ServerSocket serv;
    Socket socket;
    int puerto = 9000;
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    public HiloServer(Socket cliente){
      this.cliente = cliente;
    }
    
    public void run(){
      ArrayList<String> lista = null;
      try{
        entrada = new ObjectInputStream(cliente.getInputStream());
        lista = (ArrayList<String>)entrada.readObject();
        System.out.println(lista.get(0));
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.writeObject(lista);
        System.out.println("HHAHAHSHDHGDGDGDH");
      }catch(Exception e){};
    }
}

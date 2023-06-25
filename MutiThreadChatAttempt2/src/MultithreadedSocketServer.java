import java.util.HashMap;
import java.util.ArrayList;

import java.net.*;
import java.io.*;
public class MultithreadedSocketServer {
  public static void main(String[] args) throws Exception {
    
	  ArrayList<ServerClientThread1> arr = new ArrayList<>();
	  
	  try{
      ServerSocket server=new ServerSocket(8888);
      int counter=0;
      System.out.println("Server Started ....");
      while(true){
        counter++;
        Socket serverClient = server.accept();  //server accept the client connection request
        System.out.println(" >> " + "Client No:" + counter + " started!");
        ServerClientThread1 sct = new ServerClientThread1(serverClient,counter, arr); //send  the request to a separate thread
        arr.add(sct); //add to hashmap
        sct.start();
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
  
  public static InetAddress SocketID(Socket serverClient) { //the serverClient variable is taken in as parameter...

  //this is getting the address of the server....
	  
  return serverClient.getInetAddress();
	  
 

}
}
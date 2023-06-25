import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.io.PrintWriter;

class ServerClientThread1 extends Thread {
  private Socket serverClient;
  private ArrayList<ServerClientThread1> arr;
  int clientNo;
  int squre;
  private int port;
  private PrintWriter writer = null;
  private DataOutputStream outStream = null;
  private DataInputStream inStread = null;
  
  public ServerClientThread1(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  
  public ServerClientThread1(Socket serverClient, int port, ArrayList<ServerClientThread1> arr){
  this.port = port;	 
  this.serverClient = serverClient;
  this.arr = arr;
  }
  
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      outStream = new DataOutputStream(serverClient.getOutputStream());
      PrintWriter writer = new PrintWriter(serverClient.getOutputStream(), true);
      String clientMessage="", serverMessage="";
      while(!clientMessage.equals("bye")){
        clientMessage=inStream.readUTF();
        System.out.println(clientMessage);
        
 
        String reply = clientMessage;	
        
 
        universalPrint(reply, arr);
        
      
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception k){
      System.out.println(k);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    
  }
  }

  private static void universalPrint(String reply, ArrayList<ServerClientThread1> arr) throws IOException, UnknownHostException {
    	
	  for(ServerClientThread1 ist: arr) {

	
		  
	  ist.outStream.writeUTF(reply);
	
	
	  } 	
  }
}

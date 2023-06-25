import java.util.ArrayList;

import java.net.*;
import java.io.*;
public class Client1 {
  public static void main(String[] args) throws Exception {
  try{
    Socket socket=new Socket("127.0.0.1",8888);
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataInputStream ins =new DataInputStream(System.in);
    DataOutputStream out =new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";
   
    while(!clientMessage.equals("bye")){

      clientMessage=br.readLine();
      out.writeUTF("Client 1:" + clientMessage); 
      out.flush();
      serverMessage=inStream.readUTF();
      System.out.println(serverMessage);
    }
    out.close();
    out.close();
    socket.close();
  }catch(Exception e){
    System.out.println(e);
  }
  }
}
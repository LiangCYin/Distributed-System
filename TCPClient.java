package Networking;
// TCPClient.java
// A client program implementing TCP socket
import java.net.*; 
import java.io.*;
import java.util.Scanner;

public class TCPClient { 
	public static void main (String args[]) 
	{// arguments supply message and hostname of destination  
        Socket s = null; 
    	try{ 
	      int serverPort = 10100;
              String ip = "localhost";
              //String data = "Hello, How are you?"; 
              
	      s = new Socket(ip, serverPort); 
	      DataInputStream msg = new DataInputStream(System.in);
	      String str = "Start Chat ..........................";
	      
	      DataOutputStream output = new DataOutputStream( s.getOutputStream()); 
	      output.writeUTF(str); // UTF is a string encoding
	      System.out.println(str);
	      DataInputStream input = new DataInputStream( s.getInputStream());
	      
	      while(true) {
	    	  System.out.print("Client:\t");
	    	  str = msg.readLine();
	    	  output.writeUTF(str + "\n");
	    	  str = input.readUTF();
	    	  System.out.println("Server:\t" + str);
	      }
	      
	      //System.out.println("Received: "+ data) ; 
	    }
	    catch (UnknownHostException e){ 
	    	System.out.println("Sock:"+e.getMessage());}
	    catch (EOFException e){
	    	System.out.println("EOF:"+e.getMessage()); }
	    catch (IOException e){
	    	System.out.println("IO:"+e.getMessage());} 
    	finally {
      		if(s!=null) 
      			try {s.close();
      			} 
      			catch (IOException e) {/*close failed*/}
    }
  }
}


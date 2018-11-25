package Networking;
// TCPServer.java
// A server program implementing TCP socket
import java.net.*; 
import java.io.*; 
import java.util.Scanner;

public class TCPServer { 
  public static void main (String args[]) 
  { 
    try{ 
            int serverPort = 10100; 
            ServerSocket listenSocket = new ServerSocket(serverPort); 
      
            //System.out.println("server start listening... ... ...");
		
            while(true) { 
                Socket clientSocket = listenSocket.accept(); 
                Connection c = new Connection(clientSocket); 
            } 
    } 
    catch(IOException e) {
    	System.out.println("Listen :"+e.getMessage());} 
  }
}

class Connection extends Thread { 
	DataInputStream input, msg; 
	DataOutputStream output; 
	Socket clientSocket; 
	
	public Connection (Socket aClientSocket) { 
	    try { 
                    clientSocket = aClientSocket; 
                    input = new DataInputStream( clientSocket.getInputStream());
                    String str;
                    str = input.readUTF();
                    System.out.println("Client:\t" + str);
                    output = new DataOutputStream( clientSocket.getOutputStream());
                    msg = new DataInputStream(System.in);
                    while(true) {
                    	str = input.readUTF();
                    	System.out.print("Client:\t" + str);
                    	System.out.print("Server:\t");
                    	str = msg.readLine();
                    	output.writeUTF(str);
                    }
                    //this.start(); 
	    } 
            catch(IOException e) {
    		System.out.println("Connection:"+e.getMessage());
            } 
  	} 

//  	public void run() { 
//	    try { // an echo server 
////		    String data = input.readUTF(); 
////		    System.out.println ("receive from : " + 
////		    	clientSocket.getInetAddress() + ":" +
////		    	clientSocket.getPort() + " message - " + data);
////		    output.writeUTF(data); 
//            } 
//            catch(EOFException e) {
//    		System.out.println("EOF:"+e.getMessage()); } 
//            catch(IOException e) {
//    		System.out.println("IO:"+e.getMessage());}  
//   
//            finally { 
//      		try { 
//      			clientSocket.close();
//      		}
//      		catch (IOException e){/*close failed*/}
//            }
//        }
}


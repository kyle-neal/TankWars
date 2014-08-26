package test;

import java.io.*;
import java.net.*;

import test.smtpClient.test;
public class serverObject {
    public static void main(String args[]) {
// declaration section:
// declare a server socket and a client socket for the server
// declare an input and an output stream
ServerSocket echoServer = null;
String line = null;
DataInputStream is;
PrintStream os;
Socket clientSocket = null;
// Try to open a server socket on port 9999
// Note that we can't choose a port less than 1023 if we are not
// privileged users (root)
try {
   echoServer = new ServerSocket(9999);
}
catch (IOException e) {
   System.out.println(e);
}   
// Create a socket object from the ServerSocket to listen and accept 
// connections.
// Open input and output streams
try {
       clientSocket = echoServer.accept();
       is = new DataInputStream(clientSocket.getInputStream());
       os = new PrintStream(clientSocket.getOutputStream());
       ObjectInputStream ois = new ObjectInputStream(is);
    	 
       test t = null;
    	   try {
			 t = (test)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Server");
				e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("Server");
			e.printStackTrace();
		}
			System.out.println(t.getS());
             os.println(line); 
    } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Server");
		e.printStackTrace();
	}
finally
{
	System.out.print(true);
}
}
}


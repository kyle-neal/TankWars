package test;


import java.io.*;
import java.net.*;
public class testSendObject 
{
    public static void main(String[] args) 
    {
		// declaration section:
		// smtpClient: our client socket
		// os: output stream
		// is: input stream
        Socket smtpSocket = null;  
        DataOutputStream os = null;
        DataInputStream is = null;
        
		// Initialization section:
		// Try to open a socket on port 25
		// Try to open input and output streams
        try 
        {
            smtpSocket = new Socket("127.0.0.1", 9999);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
          	ObjectOutputStream oos = new ObjectOutputStream(os);
        } 
        catch (UnknownHostException e) 
        {
            System.err.println("Don't know about host: hostname");
        } 
        catch (IOException e) 
        {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
        
	// If everything has been initialized then we want to write some data
	// to the socket we have opened a connection to on port 25
    if (smtpSocket != null && os != null && is != null) 
    {
	    //Now we will try to write an object to the server
	    test Obj = new test(5, "Hi Kyle");
	    
	    try
	    {
	    	ObjectOutputStream oos = new ObjectOutputStream(os);
	    	oos.writeObject(Obj);
	    }
	    catch(Exception e)
	    {
	      	System.out.println("Client");
	    	System.err.println(e);
	    }
	    
		// clean up:
		// close the output stream
		// close the input stream
		// close the socket
	    try 
	    {
			os.close();
		    is.close();
		    smtpSocket.close();   
		} 
	    catch (IOException e) 
	    {
	    	System.out.println("Client");
			e.printStackTrace();
		}
    }
   } 
    
    static class test implements Serializable
    {
    	private int value = 0;
    	private String s = "Hi";
    	
    	public test(int x, String txt)
    	{
    		this.value = x;
    		this.s = txt;
    	}
    	
    	public test()
    	{
    		//NO-OP
    	}
    	
    	public int getValue() { return this.value; }
    	public String getS() { return this.s; }
    }
}

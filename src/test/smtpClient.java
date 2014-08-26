package test;


import java.io.*;
import java.net.*;
public class smtpClient 
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
            try 
            {
				// The capital string before each colon has a special meaning to SMTP
				// you may want to read the SMTP specification, RFC1822/3
            	os.writeBytes("HELO\n");    
                os.writeBytes("MAIL From: k3is@fundy.csd.unbsj.ca\n");
                os.writeBytes("RCPT To: k3is@fundy.csd.unbsj.ca\n");
                os.writeBytes("DATA\n");
                os.writeBytes("From: k3is@fundy.csd.unbsj.ca\n");
                os.writeBytes("Subject: testing\n");
                os.writeBytes("Hi there\n"); // message body
                os.writeBytes("\n.\n");
                os.writeBytes("QUIT");
               
				// keep on reading from/to the socket till we receive the "Ok" from SMTP,
				// once we received that then wenull want to break.
                String responseLine;
                while ((responseLine = is.readLine()) != null) 
                {
                    System.out.println("Server: " + responseLine);
                    
                    if (responseLine.indexOf("Ok") != -1) 
                    {
                      break;
                    }
                }

            } 
            catch (UnknownHostException e) 
            {
                System.err.println("Trying to connect to unknown host: " + e);
            } 
            catch (IOException e) 
            {
                System.err.println("IOException:  " + e);
            }
        }
    
	    //Now we will try to write an object to the server
	    test Obj = new test(5, "Hi Kyle");
	    
	    try
	    {
	    	ObjectOutputStream oos = new ObjectOutputStream(os);
	    	oos.writeObject(Obj);
	    }
	    catch(Exception e)
	    {
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
			e.printStackTrace();
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

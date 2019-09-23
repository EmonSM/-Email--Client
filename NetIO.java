import java.io.*;   // input output package
import java.net.*;  // networking package
public class NetIO {
    public static String myIPAddress() {
	String ipAddress = "";
	try { 
	    InetAddress me = InetAddress.getLocalHost(); // InetAddress is an Object, getLocalHost gets lots of information - ip address, host name, etc.
	    ipAddress = me.getHostAddress();
	}
	catch (Exception e){
	    System.out.println("Error getting ip address");
	}
	return ipAddress;
    }
    
    public static String myUserName() {
	return System.getProperty("user.name");
    }
    
    public static int sendRequest(String message, String destinationIPAddress) {
	int errorCode = Globals.NET_SEND_ERROR;
	try {
	    // Create a socket and timeout
	    Socket me =  new Socket();
	    me.connect(new InetSocketAddress(destinationIPAddress, Globals.PORT_NUMBER), Globals.TIME_OUT);
	    
	    // get output stream and send request (DO NOT NEED TO KNOW)
	    DataOutputStream output = new DataOutputStream(me.getOutputStream()); 
	    output.writeUTF(message);
	    
	    // optional, wait for confirmation from receiving computer
	    DataInputStream input = new DataInputStream(me.getInputStream());
	    String request = input.readUTF();
	    
	    if (isANumber(request)) errorCode = Integer.parseInt(request);
	    me.close();
	}
	catch (IOException e) {
	    System.out.println("Unable to send message");
	}
	return errorCode;
    }
    
    private static boolean isANumber(String s) {
	boolean isNumber = true;
	for (int i = 0; i < s.length() && isNumber; i++) {
	    isNumber = Character.isDigit(s.charAt(i));
	}
	return isNumber;
    }
    
    public static String receiveRequest() {
	String request = "";
	int errorCode = Globals.NET_RECEIVE_ERROR;
	
	try {
	    // crate a sever socket
	    ServerSocket server = new ServerSocket(Globals.PORT_NUMBER, 100);
	    
	    // create socket and timeout
	    Socket myComputer = server.accept();
	    myComputer.setSoTimeout(Globals.TIME_OUT);
	    
	    // get input stream and receive request from sender
	    DataInputStream input = new DataInputStream(myComputer.getInputStream());
	    request = input.readUTF();
	    
	    // optional, get output stream and send confirmation
	    DataOutputStream output = new DataOutputStream(myComputer.getOutputStream());
	    output.writeUTF("" + Globals.NET_OK);

	    myComputer.close();
	    server.close();
	    errorCode = Globals.NET_OK;
	}
	catch (IOException e) {
	    System.out.println("Error receiving");
	}
	return request;
    }
    
    public static void main(String[] args) {
	System.out.println(myIPAddress());
	System.out.println(myUserName());
    }
}

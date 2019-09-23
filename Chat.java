import hsa.*;
public class Chat {
    public static void main(String[] args) {
	ReceiveThread receiveThread = new ReceiveThread();
	new Thread(receiveThread).start();
	
	String message = "";
	String ipAddress = "";
	int errorCode = -1;
	
	Console sender = new Console(NetIO.myIPAddress());
	sender.print("Destination IP Address: ");
	ipAddress = sender.readLine();
	do {
	    sender.print("Message: ");
	    message = sender.readLine();
	    
	    errorCode = NetIO.sendRequest(message, ipAddress);
	} while (true);
    }   
}

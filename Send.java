import hsa.*;
public class Send {
    //Fayyad: 10.104.82.39
    //Rui: 10.104.85.58
    public static void main(String[] args) {
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

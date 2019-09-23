import hsa.*;
public class Receive {
    public static void main(String[] args) {
	String message = "";
	
	Console receiver = new Console(NetIO.myIPAddress());
	receiver.println("System ready. Waiting...");
	do {
	    message = NetIO.receiveRequest();
	    receiver.println(message);
	} while (true);
    }
}

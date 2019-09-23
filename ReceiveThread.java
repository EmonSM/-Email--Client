import hsa.*;
public class ReceiveThread implements Runnable {
    public ReceiveThread() {
    }
    
    public void run() {
	String message = "";
	
	Console receiver = new Console("Receiver Window. My Ip Address is " + NetIO.myIPAddress());
	receiver.println("System ready. Waiting...");
	do {
	    message = NetIO.receiveRequest();
	    receiver.println(message);
	} while (true);
    }
}

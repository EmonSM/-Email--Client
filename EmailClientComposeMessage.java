import javax.swing.*;   // Graphics package (collection of classes) for frames, panels, etc.
import java.awt.*;    // Abstract Window Toolkit, package for more graphics
import java.awt.event.*;    // Package for handling mouse and keyboard events

public class EmailClientComposeMessage implements ActionListener {
    // ActionListener is an interface that handles events
    //Java usually ignores signals from mouse and keyboard because no mechanism
    //ActionListener allows java calls your method such as mouse press
    
    private JFrame frame = null; //Window frame, pre-created class
    
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;
    
    private JLabel receiverLabel = null; 
    private JTextField receiver = null;
    private JLabel subjectLabel = null;
    private JTextField subject = null;
    
    private JTextArea messageText = null; //TextField is 1 line, TextArea has multiple lines
    private JScrollPane scroll = null;
    
    private JButton send = null;
    private JButton cancel = null;
    
    public EmailClientComposeMessage() {
	// set up the frame
	frame = new JFrame("New Message - ICS3U TOPS Bloor CI");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(180, 160);
	frame.setResizable(false);
	
	
	// set up the container with 3 panels wih laout
	Container contentPane = frame.getContentPane();
	BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS); // access to methods in container
	contentPane.setLayout(contentPaneLayout); // object in frame // setLayout is a method 
	
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3 = new JPanel();
	
	contentPane.add(panel1); // adding panel to frame
	contentPane.add(panel2);
	contentPane.add(panel3);
	
	// set up the first panel, default layout
	FlowLayout panel1Layout = new FlowLayout(FlowLayout.CENTER);
	panel1.setLayout(panel1Layout);
	
	receiverLabel = new JLabel("To:");
	panel1.add(receiverLabel);
	receiver = new JTextField(9);
	receiver.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
	panel1.add(receiver);
	
	subjectLabel = new JLabel("Subject:");
	panel1.add(subjectLabel);
	subject = new JTextField(51); // 51 columns of non-proportional font Courier New 20
	subject.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	panel1.add(subject);

	// set up the second panel
	FlowLayout panel2Layout = new FlowLayout(FlowLayout.CENTER);
	panel2.setLayout(panel2Layout);
	
	messageText = new JTextArea(10, 69);
	scroll = new JScrollPane(messageText);
	panel2.add(scroll);
	messageText.setBorder(BorderFactory.createLineBorder(Color.blue));
	messageText.setLineWrap(true); // Automatically wraps text to the new line
	messageText.setWrapStyleWord(true); // Automatically wraps word to the next line
	messageText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	
	// set up the third panel
	FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER);
	panel3.setLayout(panel3Layout);
	
	send = new JButton("Send");
	panel3.add(send);
	cancel = new JButton("Cancel");
	panel3.add(cancel);
	
	send.addActionListener(this);
	cancel.addActionListener(this);
	
	// make the whole thing visible
	frame.pack(); // optimizes space in the window for the objects
	frame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent event) {
	Object buttonPressed = event.getSource();
	if (buttonPressed == send) {
	    System.out.println("Pressed Send");
	}
	else if (buttonPressed == cancel) {
	    System.out.println("Pressed Cancel");
	}
	else {
	    System.out.println("Other");
	}
    }
    
    public static void main(String[] args) {
	EmailClientComposeMessage e = new EmailClientComposeMessage();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmailClientGUI implements ActionListener {
    private JFrame frame = null;
    
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;
    
    private EmailClientPane eMailClientPane = null;
    
    private JLabel title = null;
    private JButton compose = null;
    private JButton get = null;
    private JButton delete = null;
    private JButton inbox = null;
    private JButton outbox = null;
    
    public EmailClientGUI() {
	frame = new JFrame("Email");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(100, 50);
	frame.setResizable(false);
	
	Container contentPane = frame.getContentPane();
	BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
	contentPane.setLayout(contentPaneLayout);
	
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3 = new JPanel();
	
	contentPane.add(panel1); 
	contentPane.add(panel2);
	contentPane.add(panel3);
	
	FlowLayout panel1Layout = new FlowLayout(FlowLayout.LEFT);
	panel1.setLayout(panel1Layout);
	
	title = new JLabel(" From                  Date Received                                        Subject");
	panel1.add(title);
	
	FlowLayout panel2Layout = new FlowLayout(FlowLayout.LEFT);
	panel2.setLayout(panel2Layout);
	
	eMailClientPane = new EmailClientPane();
	panel2.add(eMailClientPane.getSplitPane());
	
	FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER);
	panel3.setLayout(panel3Layout);
	
	compose = new JButton("Compose");
	panel3.add(compose);
	get = new JButton("Get Mail");
	panel3.add(get);
	delete = new JButton("Delete");
	panel3.add(delete);
	inbox = new JButton("InBox");
	panel3.add(inbox);
	outbox = new JButton("OutBox");
	panel3.add(outbox);
	
	compose.addActionListener(this);
	get.addActionListener(this);
	delete.addActionListener(this);
	inbox.addActionListener(this);
	outbox.addActionListener(this);
	
	frame.pack(); 
	frame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent event) {
    }
}

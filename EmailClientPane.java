import javax.swing.*;
import java.awt.Dimension;
import javax.swing.event.*;

public class EmailClientPane extends JPanel implements ListSelectionListener {
    private String[] messageHeaders = new String[Globals.MAX_CLIENT_MESSAGES]; // set to 500
    private String messageText = "";
    
    private JList messageHeadersJList = null;
    private JTextArea messageJTextArea = null;
    
    private JScrollPane messageHeadersJScrollPane = null;
    private JScrollPane messageTextJScrollPane = null;

    private JSplitPane splitPane = null;
    
    public EmailClientPane() {
	//Create the list of images and put it in a scroll pane.
	messageHeadersJList = new JList(messageHeaders);
    
	messageHeadersJScrollPane = new JScrollPane(messageHeadersJList);
    
	messageJTextArea = new JTextArea(messageText);
	messageJTextArea.setLineWrap(true);
	messageJTextArea.setWrapStyleWord(true);
	messageJTextArea.setEditable(false);
	messageTextJScrollPane = new JScrollPane(messageJTextArea);
    
	//Create a split pane with the two scroll panes in it.
	splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, messageHeadersJScrollPane, messageTextJScrollPane);
	splitPane.setOneTouchExpandable(true);
	splitPane.setDividerLocation(250);
    
	//Provide minimum sizes for the two components in the split pane.
	Dimension minimumSize = new Dimension(800, 50);
	messageHeadersJScrollPane.setMinimumSize(minimumSize);
	messageTextJScrollPane.setMinimumSize(minimumSize);
    
	//Provide a preferred size for the split pane.
	splitPane.setPreferredSize(new Dimension(800, 600));
    }
    
    public void valueChanged(ListSelectionEvent e) {
    } 
    
    public JSplitPane getSplitPane() {
	return splitPane;
    }
}

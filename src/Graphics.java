package graph;
import java.awt.BorderLayout;
import javax.swing.*;


public class Graphics extends JFrame {
	private JTextField senderTf, receiverTf, itemTf, numberTf;
	private JPanel panel;
	private JTable jTable;
	private JFrame frame;

	
	
	
	   
	public void paintTable(String[][] data, String[] columns, int numTransaction) {
		//Show the table.
		
	    frame = new JFrame("Transaction No." + numTransaction);
	    frame.setBounds(300, 300, 900, 400);
	    panel = new JPanel();
	    panel.setBounds(300, 300, 900, 400);
	    jTable = new JTable(data, columns);
	    jTable.setBounds(30, 40, 200, 300);
	    JScrollPane sp = new JScrollPane(jTable);
	    frame.add(sp, BorderLayout.CENTER);
	    frame.add(panel, BorderLayout.NORTH);
	    frame.setVisible(true);
	}
	
	public void setJTextFields()
    {
        JLabel sender = new JLabel("Sender");
        panel.add(sender);
        senderTf = new JTextField(10);
        panel.add(senderTf);
        JLabel receiver = new JLabel("Receiver");
        panel.add(receiver);
        receiverTf = new JTextField(10);
        panel.add(receiverTf);
        JLabel item = new JLabel("Item");
        panel.add(item);
        itemTf = new JTextField(10);
        panel.add(itemTf);
        JLabel number = new JLabel("Number");
        panel.add(number);
        numberTf = new JTextField(10);
        panel.add(numberTf);
        
    }
	
	   

	public JTextField getSenderTf() {
		return this.senderTf;
	}
	public JTextField getReceiverTf() {
		return this.receiverTf;
	}
	public JTextField getNumberTf() {
		return this.numberTf;
	}
	public JTextField getItemTf() {
		return this.itemTf;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
    
	
    
    
    
   

}

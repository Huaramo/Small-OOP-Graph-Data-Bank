package graph;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.*;

public class Test {
	private static int numOfTransaction;
	public static void main(String[] args) throws CloneNotSupportedException, IOException{
		   // Construct the OOP-databank.-------------------
		   // Read the tsv-file here!
		   InputReader reader = new InputReader();
		   reader.readTable();
		   
		   // Prepare the indices of connecting relationships between the nodes.
		   Graphen graph = new Graphen(reader.getNodeNames().length);
		   graph.addEdge(0, 2);
		   graph.addEdge(0, 3);
		   graph.addEdge(1, 2);
		   graph.addEdge(1, 3);
		   graph.addEdge(1, 4);
		   graph.addEdge(2, 4);
		   
		   
		 //Prepare the collection of nodes and the node map...
		   Node[] bigCollection = new Node[5];
		   for(int i = 0; i < reader.getNodeNames().length; i++) {
			   bigCollection[i] = new Node(reader.getNodeNames()[i], i);
			   graph.addNodeToMap(bigCollection[i]);
			     
		   }
		   
		 // Write the adjacency lists of neighboring node labels...
		   OutputWriter writer = new OutputWriter();
		   writer.writeAdj(graph);
		   
		 //Prepare the data and token map...
		   String[][] dataNums = reader.getData();
		   for(int i = 0; i < bigCollection.length; i++) {
			   for(int j = 0; j < dataNums[0].length; j++) {
				   Token tk = new Token(reader.getTokenNames()[j], Integer.parseInt(dataNums[i][j]) , j);
				   bigCollection[i].addToken(tk);
			       bigCollection[i].addTokenToMap(tk);
			       }
		   }
		   numOfTransaction = 0;
		   String[][] data=bigCollection[0].getData(bigCollection);
 		   String[] columns = bigCollection[0].getColumnNames();
 		   
 		   
 		   //Plot the table...
		   Graphics graphics = new Graphics();
		   graphics.paintTable(data, columns, numOfTransaction);
		   graphics.setJTextFields();
		   
		   //Insert button here...
		   JButton button = new JButton("Confirm");
		    button.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent eve) 
		        {    
		    		numOfTransaction += 1;
		        	//From the text field find the corresponding object.
		        	String item = graphics.getItemTf().getText();
		        	int number = Integer.parseInt(graphics.getNumberTf().getText()); 
		        	int senderInd = graph.getNodeMap().get(graphics.getSenderTf().getText());
		        	int receiverInd = graph.getNodeMap().get(graphics.getReceiverTf().getText());
		        	Node sender = bigCollection[senderInd];
		        	Node receiver = bigCollection[receiverInd];
		        	//Perform the transaction.
		           sender.transact(receiver, item, number, graph);
		           
		 		   //Update the data.
		 		   String[][] data=bigCollection[0].getData(bigCollection);
		 		   String[] columns = bigCollection[0].getColumnNames();
		        	//Write the current state of the token number distributions as a TSV-file.
		        	OutputWriter ow = new OutputWriter();
		        	try {
		        	ow.writeTable(columns, data);
		        	}
		        	catch(IOException e) {
		        		System.err.println("Cannot write the current state into a file.");
		        	}
		        	
		        	//Repaint the JTable.
		        	graphics.paintTable(data, columns, numOfTransaction);
		        	graphics.setJTextFields();
		        	graphics.getFrame().add(button, BorderLayout.SOUTH);
		        	
		        }
		    });
		    
		    graphics.getFrame().add(button, BorderLayout.SOUTH); 
		    
		   

		    
		    
		   
	   }

}

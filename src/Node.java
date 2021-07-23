package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;



public class Node {
   private String label;
   private ArrayList<Token> tokens;
   private HashMap<String, Integer> tokenMap;
   private int index;


      
   public Node() {
	   this.tokens = new ArrayList<Token>();
	   tokenMap = new HashMap<String, Integer>();
	   
   }
   
   public Node(String label, int index) {
	   this.label = label;
	   this.index = index;
	   tokens = new ArrayList<Token>();
	   tokenMap = new HashMap<String, Integer>();
   }
   
   
   
   public ArrayList<Token> getTokens(){
	   return this.tokens;
   }
   
  
   
   public String getLabel() {
	   return this.label;
   }
   
   public int getIndex() {
	   return this.index;
   }
   
   public void setTokenMap(HashMap<String, Integer> tokenMap) {
	   this.tokenMap = tokenMap;
   }
   
   public HashMap<String, Integer> getTokenMap(){
	   return this.tokenMap;
   }
   public void addTokenToMap(Token tk) {
	   this.getTokenMap().put(tk.getLabel(), tk.getIndex());
   }
   public void addToken(Token tk) {
	   this.getTokens().add(tk);
   }
   
   public boolean isConnectedWith(Node n, Graphen g) {
	   return g.getAdj().get(this.getIndex()).contains(n.getIndex());
   }
   
   public boolean isTransactable(String item, int number) {
	   int indexOfItem = this.getTokenMap().get(item);
	   int numberOfItem= this.getTokens().get(indexOfItem).getNumber();
	   return numberOfItem >= number;
   }
   
   public void transact(Node receiver, String item, int number, Graphen graph) {
	   if(this.isConnectedWith(receiver, graph) && this.isTransactable(item, number)) {
		   int indexOfItem = this.getTokenMap().get(item);
		   int numberOfItem= this.getTokens().get(indexOfItem).getNumber() - number;
		   this.getTokens().get(indexOfItem).setNumber(numberOfItem);
		   numberOfItem = receiver.getTokens().get(indexOfItem).getNumber() + number;
		   receiver.getTokens().get(indexOfItem).setNumber(numberOfItem);
		   //System.out.println("Transaction finished!");
		   //System.out.println();
		   
	   }
	   else {
		   //System.out.println("Error: The transaction cannot be made.");
		   if(!this.isConnectedWith(receiver, graph))
			   JOptionPane.showMessageDialog(null, "Error: The two places are not connected.");
		   if(!this.isTransactable(item, number))
			   JOptionPane.showMessageDialog(null, "Error: The number of requested items are not enough for this transaction.");
		   //System.out.println();
			   
	   }
	   
   }
   
   public void printTokens() {
	   System.out.println("------------------");
	   System.out.println("Place: " + this.getLabel());
	   for(Token tk: this.getTokens()) {
		   System.out.println(tk.getLabel() + ": " + tk.getNumber());
	   }
	   System.out.println();
   }
   
   public ArrayList<String> collectTokenNames() {
	   ArrayList<String> tokenNames = new ArrayList<String>();
	   for(Token tk: this.getTokens()) {
		   tokenNames.add(tk.getLabel());
	   }
	   return tokenNames;
   }
   
   
   public ArrayList<Integer> collectTokenNumbers() {
	   ArrayList<Integer> numbers = new ArrayList<Integer>();
	   for(Token tk: this.getTokens()) {
		   numbers.add(tk.getNumber());
	   }
	   return numbers;
   }
   
   
  public String[] getColumnNames() {
	  ArrayList<String> columnNames=this.collectTokenNames();
	   columnNames.add(0, "Node Name");
	   String[] columns =  columnNames.toArray(new String[0]);
	  return columns;
  }
  
  public String[][] getData(Node[] bigCollection) {
	  ArrayList<ArrayList<String>> dataArrList = new ArrayList<ArrayList<String>>(); 
	   for(Node ob: bigCollection) {
		   List<String> tmp = ob.collectTokenNumbers().stream().map((x) -> Integer.toString(x)).collect(Collectors.toList());
		   tmp.add(0, ob.getLabel());
		   ArrayList<String> tmp2 = new ArrayList<String>(tmp);
		   dataArrList.add(tmp2);
	   }
	   String[][] data = new String[dataArrList.size()][];
	   for (int i = 0; i < dataArrList.size(); i++) {
	       ArrayList<String> row = dataArrList.get(i);
	       data[i] = row.toArray(new String[row.size()]);
	   }
	  return data;
  }
   
   
   
}

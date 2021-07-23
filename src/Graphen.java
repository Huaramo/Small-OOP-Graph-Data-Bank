package graph;
import java.util.ArrayList;
import java.util.HashMap;

public class Graphen {
	//Here, several HashMaps need to be prepared:
	//1. The HashMaps that maps the node label to the corresponding node index;
	//2. The HashMaps that maps the token label to the corresponding token index;
	
	//The adjacent list that stores the indices of connections.
	private ArrayList<ArrayList<Integer> > adj;
	private HashMap<String, Integer> nodeMap;
	
	public Graphen(int numOfNodes) {
		this.adj = new ArrayList<ArrayList<Integer> >();
		for (int i = 0; i < numOfNodes; i++)
            adj.add(new ArrayList<Integer>());
		
		this.nodeMap = new HashMap<String, Integer>();
		
	}
  
    	   
	public void addEdge(int a, int b)
{
this.getAdj().get(a).add(b);
this.getAdj().get(b).add(a);
}


//A utility function to print the adjacency list
//representation of graph

public ArrayList<ArrayList<Integer> > getAdj() {
	return this.adj;
}	

public void addNodeToMap(Node n) {
	   this.getNodeMap().put(n.getLabel(), n.getIndex());
}
 
public HashMap<String, Integer> getNodeMap(){
	return this.nodeMap;
} 


}

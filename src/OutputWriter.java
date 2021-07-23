package graph;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

public class OutputWriter {
	
	public void writeTable(String[] columns, String[][] data) throws IOException{
		Writer writer = new FileWriter("present_transaction.tsv");
	    for(String col: columns)
	    	writer.write(col+"\t");
	    writer.write("\n");
	    for(String[] line: data) {
	    	for(String item: line) {
	    		writer.write(item + "\t");
	    	}
	    	writer.write("\n");
	    }
	    writer.close();
		
	}
	
	public void writeAdj(Graphen g) throws IOException{
		Writer writer = new FileWriter("neighbors.txt");
		//For every node in adjacency list
		HashMap<String, Integer> map = g.getNodeMap();
		HashMap<Integer, String> swappedMap = new HashMap<Integer, String>();
		map.forEach((key, value) -> swappedMap.put(value, key));
		for(ArrayList<Integer> neighbors: g.getAdj()) {
			String tmpStr = "";
			for(Integer ind: neighbors) {
				tmpStr += swappedMap.get(ind) + ",";
			}
			tmpStr = tmpStr.substring(0, tmpStr.length()-1);
			int index = g.getAdj().indexOf(neighbors);
			String nodeName = swappedMap.get(index);
			writer.write(index+"\t" +nodeName + "\t" +tmpStr+"\n");
		}
		writer.close();
		
	}
	
	

}

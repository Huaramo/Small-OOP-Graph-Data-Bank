package graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.System;

public class InputReader {
	//InputReader saves the index of each node and each token
	// Also the numeric data.
	private String[] nodeNames; 
	private String[] tokenNames;
	private String[][] data;
	
	public void readTable() throws IOException{
		int lineNo = 0;
		BufferedReader reader = new BufferedReader(new FileReader("present_transaction.tsv"));
		String tmpLine = "";
		List<String> tmpNodeNames = new ArrayList<String>();
		List<String[]> tmpData = new ArrayList<String[]>();
		String[] tmpTokenNames;
		while ((tmpLine = reader.readLine()) != null) {
			if (lineNo == 0) {
				tmpTokenNames= tmpLine.split("\t");
				tokenNames = Arrays.copyOfRange(tmpTokenNames, 1, tmpTokenNames.length);
			    lineNo++;
		    }
			else {
				String[] tmp=tmpLine.split("\t");
				tmpNodeNames.add(tmp[0]);
				tmpData.add(Arrays.copyOfRange(tmp, 1, tmp.length));
			}
			
		}
		nodeNames = convertToStringArray(tmpNodeNames);
		data = convertTo2dStringArray(tmpData);
		
		
		
		
	}
	
	public String[]  getNodeNames(){
		return nodeNames;
	}
	
	public String[] getTokenNames() {
		return tokenNames;
	}
	
	public String[][] getData(){
		return data;
	}
	
	public String[][] convertTo2dStringArray(List<String[]> data) {
		String[][] tmp = new String[data.size()][];
		
		for(int i = 0; i < data.size(); i++) {
			tmp[i] = data.get(i);
		}
		return tmp;
	}
	
	public String[] convertToStringArray(List<String> nodeNames) {
		String[] tmp = new String[nodeNames.size()];
		for(int i = 0; i < nodeNames.size(); i++) {
			tmp[i] = nodeNames.get(i);
		}
		return tmp;
	}
	

	

}

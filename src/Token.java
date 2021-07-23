package graph;
import java.util.ArrayList;
import java.util.HashMap;

public class Token implements Cloneable {
	private String label;
	private int number;
	private int index;
	
	public Token(String label, int number, int index) {
		this.label = label;
		this.number = number;
		this.index = index;
	}
	
	public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	public String getLabel() {
		return this.label;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getIndex() {
		return this.index;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}

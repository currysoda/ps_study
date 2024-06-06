package ps.stack;


import domain.Data;

public class StackNode {
	
	private Data data;
	private Data previous;
	
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	public Data getPrevious() {
		return previous;
	}
	
	public void setPrevious(Data previous) {
		this.previous = previous;
	}
}

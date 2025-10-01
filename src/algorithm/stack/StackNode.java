package algorithm.stack;


import domain.Data;

public class StackNode {
	
	private Data      data;
	// Linked 전용 Arrays 구현엔 필요 없음
	private StackNode previous;
	
	public StackNode() {
		data = null;
		previous = null;
	}
	
	public StackNode(Data data) {
		this.data = data;
		previous = null;
	}
	
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	public StackNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(StackNode previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}

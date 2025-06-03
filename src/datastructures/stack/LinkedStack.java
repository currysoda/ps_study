package datastructures.stack;


public class LinkedStack implements Stack {
	
	private StackNode top;
	private Long      count;
	
	public LinkedStack() {
		top = null;
		count = 0L;
	}
	
	@Override
	public void init() {
		top = null;
		count = 0L;
	}
	
	@Override
	public Boolean isEmpty() {
		return top == null;
	}
	
	@Override
	public StackNode push(StackNode node) {
		count++;
		
		if (top == null) {
			node.setPrevious(null);
			top = node;
		}
		else {
			
			node.setPrevious(top);
			top = node;
		}
		return node;
	}
	
	@Override
	public StackNode pop() {
		if (top == null) {
			return null;
		}
		else {
			count--;
			StackNode temp = top;
			top = top.getPrevious();
			
			return temp;
		}
	}
	
	@Override
	public StackNode peek() {
		return top;
	}
	
	@Override
	public Long nodeCount() {
		return count;
	}
	
	@Override
	public StackNode searchStackNode(StackNode stackNode) {
		if (top == null) {
			return null;
		}
		else {
			StackNode temp = top;
			
			while (temp != null) {
				
				Long result = temp.getData().getId();
				
				if (result == stackNode.getData().getId()) {
					return temp;
				}
				
				temp = temp.getPrevious();
			}
			return null;
		}
	}
	
	@Override
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		StackNode temp = top;
		
		while (temp != null) {
			
			Long result = temp.getData().getId();
			
			sb.append(result).append("\n");
			
			temp = temp.getPrevious();
		}
		
		return sb.toString();
	}
}

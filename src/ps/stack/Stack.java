package ps.stack;

public interface Stack {
	
	void init();
	
	Boolean isEmpty();
	
	StackNode push(StackNode stackNode);
	
	StackNode pop();
	
	StackNode peek();
	
	Long nodeCount();
	
	StackNode searchStackNode(StackNode stackNode);
	
	void print();
}

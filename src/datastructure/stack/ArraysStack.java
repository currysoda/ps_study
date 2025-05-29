package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class ArraysStack implements Stack {
	
	private List<StackNode> list;
	private Long            count;
	
	public ArraysStack() {
		list = new ArrayList<>();
		count = 0L;
	}
	
	@Override
	public void init() {
		list = new ArrayList<>();
		count = 0L;
	}
	
	@Override
	public Boolean isEmpty() {
		return list == null;
	}
	
	@Override
	public StackNode push(StackNode stackNode) {
		count++;
		list.add(stackNode);
		
		return stackNode;
	}
	
	@Override
	public StackNode pop() {
		count--;
		StackNode temp = list.get(list.size() - 1);
		
		list.remove(list.get(list.size() - 1));
		
		return temp;
	}
	
	@Override
	public StackNode peek() {
		return list.get(list.size() - 1);
	}
	
	@Override
	public Long nodeCount() {
		return count;
	}
	
	@Override
	public StackNode searchStackNode(StackNode stackNode) {
		for (int i = list.size() - 1; i > -1; i--) {
			if (stackNode.getData().getId() == list.get(i).getData().getId()) {
				return list.get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public void print() {
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = list.size() - 1; i > -1; i--) {
			sb.append(list.get(i).getData().getId()).append("\n");
		}
		
		return sb.toString();
	}
}

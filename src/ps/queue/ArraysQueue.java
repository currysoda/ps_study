package ps.queue;

import java.util.ArrayList;
import java.util.List;
import ps.stack.StackNode;

public class ArraysQueue implements Queue {
	
	private List<QueueNode> list;
	
	public ArraysQueue() {
		list = new ArrayList<>();
	}
	
	@Override
	public void init() {
		list = new ArrayList<>();
	}
	
	@Override
	public Boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public QueueNode inQueue(QueueNode queueNode) {
		list.add(queueNode);
		return list.get(list.size() - 1);
	}
	
	@Override
	public QueueNode deQueue() {
		if (list.isEmpty()) {
			return null;
		}
		else {
			QueueNode result = list.get(0);
			list.remove(0);
			
			return result;
		}
		
	}
	
	@Override
	// 맨 앞의 요소 반환
	public QueueNode peek() {
		if (list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}
	
	@Override
	public Long nodeCount() {
		return (long) list.size();
	}
	
	@Override
	public QueueNode searchQueueNode(QueueNode queueNode) {
		return null;
	}
	
	@Override
	public void print() {
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getData().getId()).append("\n");
		}
		
		return sb.toString();
		
	}
	
}

package datastructure.queue;

public class LinkedQueue implements Queue {
	
	private QueueNode back;
	private QueueNode front;
	private Long      count;
	
	public LinkedQueue() {
		back = null;
		front = null;
		count = 0L;
	}
	
	
	@Override
	public void init() {
		back = null;
		front = null;
		count = 0L;
	}
	
	@Override
	public Boolean isEmpty() {
		return front == null;
	}
	
	@Override
	public QueueNode inQueue(QueueNode queueNode) {
		count++;
		if (front == null) {
			queueNode.setNext(null);
			front = queueNode;
			back = queueNode;
			return front;
		}
		else {
			back.setNext(queueNode);
			queueNode.setNext(null);
			back = queueNode;
			return back;
		}
	}
	
	@Override
	public QueueNode deQueue() {
		if (front == null) {
			return null;
		}
		else {
			QueueNode remove = front;
			front = front.getNext();
			
			return remove;
		}
	}
	
	@Override
	public QueueNode peek() {
		if (front == null) {
			return null;
		}
		else {
			return front;
		}
	}
	
	@Override
	public Long nodeCount() {
		return count;
	}
	
	@Override
	public QueueNode searchQueueNode(QueueNode queueNode) {
		if (front == null) {
			return null;
		}
		else {
			QueueNode temp = front;
			
			while (temp != null) {
				if (temp.getData().getId() == queueNode.getData().getId()) {
					return temp;
				}
				
				temp = temp.getNext();
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
		
		QueueNode temp = front;
		
		while (temp != null) {
			sb.append(temp.getData().getId()).append("\n");
			
			temp = temp.getNext();
		}
		
		return sb.toString();
	}
	
}

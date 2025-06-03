package datastructures.queue;

import domain.Data;

public class QueueNode {
	
	private Data      data;
	// Linked 전용 Arrays 구현엔 필요 없음
	private QueueNode next;
	
	public QueueNode() {
	
	}
	
	@Override
	public String toString() {
		return data.getId().toString();
	}
	
	public QueueNode(Data data) {
		this.data = data;
	}
	
	public QueueNode getNext() {
		return next;
	}
	
	public void setNext(QueueNode next) {
		this.next = next;
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
}

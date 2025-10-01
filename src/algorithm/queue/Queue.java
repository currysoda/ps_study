package algorithm.queue;

public interface Queue {
	
	void init();
	
	Boolean isEmpty();
	
	QueueNode inQueue(QueueNode queueNode);
	
	QueueNode deQueue();
	
	// 맨 앞의 요소 반환
	QueueNode peek();
	
	Long nodeCount();
	
	QueueNode searchQueueNode(QueueNode queueNode);
	
	void print();
}

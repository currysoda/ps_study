package algorithm.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(10);
		pq.add(20);
		pq.add(15);
		pq.add(25);
		pq.add(30);
		
		System.out.println("pq = " + pq);
		System.out.println("pq.peek() = " + pq.peek());
		
		pq.poll();
		
		System.out.println("pq = " + pq);
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq2.add(10);
		pq2.add(15);
		pq2.add(20);
		pq2.add(25);
		pq2.add(30);
		
		System.out.println("pq2 = " + pq2);
		System.out.println("pq2.peek() = " + pq2.peek());
		
		pq2.poll();
		
		System.out.println("pq2 = " + pq2);
	}
	
}

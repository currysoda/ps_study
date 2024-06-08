import domain.Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ps.queue.ArraysQueue;
import ps.queue.LinkedQueue;
import ps.queue.Queue;
import ps.queue.QueueNode;
import ps.stack.ArraysStack;
import ps.stack.LinkedStack;
import ps.stack.Stack;
import ps.stack.StackNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/dataset/dataexample.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue queue = new LinkedQueue();
		queue.init();
		System.out.println(queue.isEmpty());
		
		String input;
		while ((input = br.readLine()) != null) {
			Data      data      = new Data((long) Integer.parseInt(input));
			QueueNode queueNode = new QueueNode(data);
			QueueNode inNode    = queue.inQueue(queueNode);
		}
		
		System.out.println("--------------------");
		System.out.println("queue = " + queue);
		System.out.println("--------------------");
		System.out.println("peek = " + queue.peek().getData().getId());
		System.out.println("--------------------");
		System.out.println("queue.deQueue() = " + queue.deQueue());
		System.out.println("queue.deQueue() = " + queue.deQueue());
		System.out.println("queue.deQueue() = " + queue.deQueue());
		System.out.println("--------------------");
		System.out.println("queue = " + queue);
		
		
		br.close();
		bw.close();
	}
}

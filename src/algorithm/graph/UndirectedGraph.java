package algorithm.graph;

import java.util.List;
import java.util.ArrayList;

public class UndirectedGraph implements graph {
	
	// vertex 가 자연수라는 가정
	// vertex 0 은 없고 배열구조라서 존재만 한다
	private final List<List<Integer>> graph = new ArrayList<>();
	
	@Override
	public void addEdge(Edge edge) {
		
		int start = edge.getStart();
		int end   = edge.getEnd();
		
		int goal = end > start ? end : start;
		
		/*
		 * size = 1 은 실제 vertex 가 없고 배열이라 어쩔수 없이 있는 0만 있는 상태
		 * 따라서 size + 1 이 실제 존재하는 vertex 의 갯수가 된다.
		 * */
		int count = (graph.size() + 1) - goal;
		
		while (count-- > 0) {
			graph.add(new ArrayList<>());
		}
		
		graph.get(start).add(end);
		graph.get(end).add(start);
	}
	
	@Override
	public void removeEdge(Edge edge) {
		int start = edge.getStart();
		int end   = edge.getEnd();
		
		
	}
	
	@Override
	public void clearGraph() {
		graph.clear();
	}
	
	@Override
	public boolean isEmpty() {
		return graph.isEmpty();
	}
	
	@Override
	public int getEdgeCount() {
		return 0;
	}
	
	@Override
	public int getVertexCount() {
		if (isEmpty()) {
			return 0;
		}
		else {
			return graph.size() - 1;
		}
	}
	
	@Override
	public List<Integer> getNeighbors(int vertex) {
		return List.of();
	}
	
	@Override
	public void printEdgeAll() {
	
	}
	
	@Override
	public void dfs() {
	
	}
	
	@Override
	public void bfs() {
	
	}
}

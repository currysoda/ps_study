package algorithm.graph;

import java.util.List;
import java.util.ArrayList;

public class UndirectedGraph implements graph {
	
	private final List<List<Integer>> graph = new ArrayList<>();
	
	@Override
	public void addEdge(Edge edge) {
	
	}
	
	@Override
	public void removeEdge(Edge edge) {
	
	}
	
	@Override
	public void clearGraph() {
	
	}
	
	@Override
	public void isEmpty() {
	
	}
	
	@Override
	public int getEdgeCount() {
		return 0;
	}
	
	@Override
	public int getVertexCount() {
		return 0;
	}
	
	@Override
	public List<Integer> getNeighbors(int vertex) {
		return List.of();
	}
	
	@Override
	public void printEdgeAll() {
	
	}
}

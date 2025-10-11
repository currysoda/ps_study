package algorithm.graph;

import java.util.List;

/**
 * vertex 는 1 이상 / 정수 인접 리스트로 구현 / 따라서 List<List> 의 0 은 리스트라서 넣는 것 실제 값으로 유효 X
 * 정수 인접리스트임을 이용해서 vertex 는 전부 정수니까 graph 사이즈와 start end 를 이용하므로
 * addVertex 등은 필요 없음
 */
public interface graph {
	
	void addEdge(Edge edge);
	
	void removeEdge(Edge edge);
	
	void clearGraph();
	
	void isEmpty();
	
	int getEdgeCount();
	
	int getVertexCount();
	
	List<Integer> getNeighbors(int vertex);
	
	void printEdgeAll();
}

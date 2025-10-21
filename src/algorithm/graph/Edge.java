package algorithm.graph;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Edge {
	
	private int start;
	private int end;
}

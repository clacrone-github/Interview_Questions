package dev.clacrone.interview.utils;

import java.util.List;

public class Graph {

	private List<GraphNode> nodes;
	
	public Graph(List<GraphNode> nodes) {
		// TODO Auto-generated constructor stub
		this.nodes = nodes;
	}

	public boolean isEmpty() {
		return nodes == null || nodes.isEmpty();
	}
	
	public List<GraphNode> getNodes() {
		return nodes;
	}
	
	public GraphNode removeFirst() {
		return isEmpty() ? null : nodes.remove(0);
	}
}

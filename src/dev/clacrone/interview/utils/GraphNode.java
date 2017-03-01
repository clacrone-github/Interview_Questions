package dev.clacrone.interview.utils;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	private GraphState state;
	private String name;
	private List<GraphNode> adjacencyList;
	
	public GraphNode(String name) {
		this.name = name;
		state = GraphState.UNVISITED;
		adjacencyList = new ArrayList();
	}

	public GraphState getState() {
		return state;
	}

	public void setState(GraphState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GraphNode> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<GraphNode> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public void addEdge(GraphNode n) {
		adjacencyList.add(n);
	}
}

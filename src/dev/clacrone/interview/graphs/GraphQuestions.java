package dev.clacrone.interview.graphs;

import java.util.LinkedList;
import java.util.List;

import dev.clacrone.interview.utils.Graph;
import dev.clacrone.interview.utils.GraphNode;
import dev.clacrone.interview.utils.GraphState;

public class GraphQuestions {
	public static boolean doesGraphHaveRoute(Graph g, GraphNode start, GraphNode end) {
		List<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.add(start);
		GraphNode temp;
		while (!queue.isEmpty()) {
			temp = queue.remove(0);
			if (temp != null) {
				temp.setState(GraphState.VISITING);
				System.out.println("temp: " + temp.getName());
				for (GraphNode neighbor : temp.getAdjacencyList()) {
					System.out.println("neighbor: " + neighbor.getName());
					if (neighbor.getState() == GraphState.UNVISITED) {
						if (neighbor == end) {
							return true;
						}
						neighbor.setState(GraphState.VISITING);
						queue.add(neighbor);
					}
				}
				temp.setState(GraphState.VISITED);
			}
		}
		System.out.println("exiting");
		return false;
	}
}

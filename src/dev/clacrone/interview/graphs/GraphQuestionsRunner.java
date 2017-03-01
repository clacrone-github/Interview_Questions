package dev.clacrone.interview.graphs;

import java.util.ArrayList;
import java.util.List;

import dev.clacrone.interview.utils.Graph;
import dev.clacrone.interview.utils.GraphNode;

public class GraphQuestionsRunner {

	public static void runGraphQuestions() {
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		GraphNode craig = new GraphNode("Craig");
		GraphNode megan = new GraphNode("Megan");
		GraphNode bryan = new GraphNode("Bryan");
		GraphNode aimee = new GraphNode("Aimee");
		GraphNode jer = new GraphNode("Jer");
		GraphNode katrina = new GraphNode("Katrina");
		GraphNode brent = new GraphNode("Brent");
		GraphNode steph = new GraphNode("Steph");
		GraphNode damon = new GraphNode("Damon");
		
		craig.addEdge(megan);
		craig.addEdge(bryan);
		craig.addEdge(aimee);
		craig.addEdge(jer);
		
		megan.addEdge(craig);
		
		bryan.addEdge(brent);
		bryan.addEdge(aimee);
		
		aimee.addEdge(bryan);
		aimee.addEdge(craig);
		
		jer.addEdge(steph);
		
		katrina.addEdge(megan);
		
		steph.addEdge(katrina);
		
		nodes.add(craig);
		nodes.add(megan);
		nodes.add(bryan);
		nodes.add(aimee);
		nodes.add(jer);
		nodes.add(katrina);
		nodes.add(brent);
		nodes.add(steph);
		Graph g = new Graph(nodes);
		boolean result = GraphQuestions.doesGraphHaveRoute(g, craig, damon);
		
		System.out.println("result: " + result);
	}

}

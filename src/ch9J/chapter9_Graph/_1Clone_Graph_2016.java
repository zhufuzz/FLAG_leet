package ch9J.chapter9_Graph;

import java.util.*;

public class _1Clone_Graph_2016 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		ArrayList<UndirectedGraphNode> nodes = findAllNodes(node);
		
		//mapping old node to new node
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map =	copyNodes(nodes);
		
		//connect all edges
		connectNeighbors(nodes, map);
		
		return map.get(node);
	}
	
	private ArrayList<UndirectedGraphNode> findAllNodes(UndirectedGraphNode node) {
		//BFS
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
		HashSet<UndirectedGraphNode> inQueue = new HashSet<>();
		
		queue.offer(node);
		nodes.add(node);
		inQueue.add(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			for (UndirectedGraphNode neighbor : head.neighbors) {
				//version 1
				if (!inQueue.contains(neighbor)) {
					queue.offer(neighbor);
					nodes.add(neighbor);
					inQueue.add(neighbor);
				}
				//version 2
				if (inQueue.contains(neighbor)) {
					continue;
				}
				queue.offer(neighbor);
				nodes.add(neighbor);
				inQueue.add(neighbor);
			}
		}
		return nodes;
	}
	
	private HashMap<UndirectedGraphNode, UndirectedGraphNode> copyNodes(
			ArrayList<UndirectedGraphNode> nodes
			){
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new
				HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		for (UndirectedGraphNode node : nodes) {
			map.put(node, new UndirectedGraphNode(node.label));
		}
		return map;
	}
	
	private void connectNeighbors(ArrayList<UndirectedGraphNode> nodes, 
								  HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (UndirectedGraphNode node : nodes) {
			for (UndirectedGraphNode neighbor : node.neighbors) {
				UndirectedGraphNode newNode = map.get(node);
				UndirectedGraphNode newNeighbor = map.get(neighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}
	}
	
}

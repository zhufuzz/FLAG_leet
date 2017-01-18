package ch9S.chapter2_DataStructure1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _01Find_the_Connected_Component_in_the_Undirected_Graph_bfs {
/**
 * @param nodes a array of Undirected graph node
 * @return a connected set of a Undirected graph
 */
public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
    // Write your code here
    
    int m = nodes.size();
    Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
    
   for (UndirectedGraphNode node : nodes){
        visited.put(node, false);
   }
    
    List<List<Integer>> result = new ArrayList<>();
    
    for (UndirectedGraphNode node : nodes){
        if (visited.get(node) == false){
            bfs(node, visited, result);
        }
    }
    
    return result;
}

public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result){
    List<Integer>row = new ArrayList<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    visited.put(node, true);
    queue.offer(node);
    while (!queue.isEmpty()){
        UndirectedGraphNode u = queue.poll();
        row.add(u.label);    
        for (UndirectedGraphNode v : u.neighbors){
            if (visited.get(v) == false){
                visited.put(v, true);
                queue.offer(v);
            }
        }
    }
    Collections.sort(row);
    result.add(row);
    
}
}

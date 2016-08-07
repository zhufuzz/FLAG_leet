package facebook.leetcode;
//DFS, BFS, Graph, Union Find
import java.util.*;
/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes),
 *  write a function to check whether these edges make up a valid tree.*/
//https://leetcode.com/discuss/82861/share-my-line-dfs-line-bfs-and-clean-union-find-java-solutions

public class F_261_Graph_Valid_Tree_BFS {
  public boolean validTree(int n, int[][] edges) {
    
    int[] visited = new int[n];
    List<List<Integer>> adjList = new ArrayList<>();
    
    for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
    
    for (int[] edge: edges) {
        adjList.get(edge[0]).add(edge[1]);
        adjList.get(edge[1]).add(edge[0]);
    }
    
    Deque<Integer> q = new ArrayDeque<>();
    // vertex 0 is in the queue, being visited
    q.addLast(0); visited[0] = 1;  
    
    while (!q.isEmpty()) {
        Integer cur = q.removeFirst();
        
        for (Integer succ: adjList.get(cur)) {
            // loop detected
            if (visited[succ] == 1) { return false; }  
            if (visited[succ] == 0) { q.addLast(succ); visited[succ] = 1; }
        }
        // visit completed
        visited[cur] = 2;  
    }
    
    // # of connected components is not 1
    for (int v: visited) { if (v == 0) { return false; } }  
    
    return true;
  }
}

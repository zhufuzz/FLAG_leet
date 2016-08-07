package facebook.leetcode;
//DFS, BFS, Graph, Union Find
import java.util.*;
/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes),
 *  write a function to check whether these edges make up a valid tree.*/
//https://leetcode.com/discuss/82861/share-my-line-dfs-line-bfs-and-clean-union-find-java-solutions

public class F_261_Graph_Valid_Tree_DFS {
  
  public boolean validTree(int n, int[][] edges) {    
    int[] visited = new int[n];
    List<List<Integer>> adjList = new ArrayList<>();
    
    for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
    
    for (int[] edge: edges) {
        adjList.get(edge[0]).add(edge[1]);
        adjList.get(edge[1]).add(edge[0]);
    }
    
    // has cycle
    if (hasCycle(-1, 0, visited, adjList)) { return false; }
    
    // not 1 single connected component
    for (int v: visited) { if (v == 0) { return false; } }  
    
    return true;
  }

  private boolean hasCycle(int pred, int vertex, int[] visited, List<List<Integer>> adjList) {
    // current vertex is being visited
    visited[vertex] = 1;  
    
    // successors of current vertex
    for (Integer succ: adjList.get(vertex)) {  
      
      // exclude current vertex's predecessor  
      if (succ != pred) {  
            // back edge/loop detected!
            if (visited[succ] == 1) { return true; }  
            else if (visited[succ] == 0) {
                if (hasCycle(vertex, succ, visited, adjList)) { return true; }
            }
        }
    }
    
    visited[vertex] = 2;
    return false;
  }
}
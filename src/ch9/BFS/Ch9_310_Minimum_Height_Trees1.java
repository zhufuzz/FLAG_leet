package ch9.BFS;
import java.util.*;
/*For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
Example 1:  Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3
return [1]
Example 2: Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]*/
//http://buttercola.blogspot.com/2016/01/leetcode-minimum-height-trees.html
public class Ch9_310_Minimum_Height_Trees1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0 || edges == null || edges.length == 0) {
            return result;
        }
         
        // Step 1: construct the adjList
        Map<Integer, List<Integer>> adjList = new HashMap<>();
         
        for (int[] edge : edges) {
            // add forward edge
            int from = edge[0];
            int to = edge[1];
             
            if (!adjList.containsKey(from)) {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(to);
                adjList.put(from, neighbors); 
            } else {
                List<Integer> neighbors = adjList.get(from);
                neighbors.add(to);
                adjList.put(from, neighbors);
            }
             
            // Add the reverse edge
            if (!adjList.containsKey(to)) {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(from);
                adjList.put(to, neighbors);
            } else {
                List<Integer> neighbors = adjList.get(to);
                neighbors.add(from);
                adjList.put(to, neighbors);
            }
        }
         
        // Step 2: iterate each vertex as the root and get the height
        boolean[] visited = new boolean[n];
        int minHeight = Integer.MAX_VALUE;
         
        for (int i = 0; i < n; i++) {
            int height = getHeightOfTree(i, adjList, visited);
            if (height < minHeight) {
                result.clear();
                result.add(i);
                minHeight = height;
            } else if (height == minHeight) {
                result.add(i);
            }
        }
         
        return result;
    }
     
    private int getHeightOfTree(int root, Map<Integer, List<Integer>> adjList, 
                                boolean[] visited) {
        List<Integer> neighbors = adjList.get(root);
        visited[root] = true;         
        int maxHeight = 0;
         
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                maxHeight = Math.max(maxHeight, 
                  getHeightOfTree(neighbor, adjList, visited));
            }
        }
         
        visited[root] = false;         
        return maxHeight + 1;
    }
}

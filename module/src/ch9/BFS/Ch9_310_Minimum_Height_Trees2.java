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
public class Ch9_310_Minimum_Height_Trees2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            return result;
        }
         
        // Corner case: there is a single node and no edge at all
        if (n == 1 && edges.length == 0) {
            result.add(0);
            return result;
        }
         
        // Step 1: construct the graph
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());//这到底应该用什么方法？
        }
         
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
         
        // Remove leaf nodes
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }
         
        while (n > 2) {
            // identify and remove all leaf nodes
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int leaf : leaves) {
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                 
                if (adjList.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
             
            leaves = newLeaves;
        }
         
        return leaves;
    }
}
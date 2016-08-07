package ch9.DFS;

/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
For example:Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
Hint:Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: ¡°a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.¡±
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.*/
public class Ch9_261_Graph_Valid_Tree {
    private int[] father;
    /** @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false */
    public boolean validTree(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }        
        // union-find is a data structure that can union two sets and check 
        // whether two element in the same set.
        // search it on google for more information
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }        
        for (int i = 0; i < edges.length; i++) {
            if (find(edges[i][0]) == find(edges[i][1])) {
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }        
        return true;
    }
    
    int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    
    void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
}
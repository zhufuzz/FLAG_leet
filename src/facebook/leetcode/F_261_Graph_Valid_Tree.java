package facebook.leetcode;
//DFS, BFS, Graph, Union Find

/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: 鈥渁 tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.鈥�*/
/*题解：
最简便的写法是Quick-Union，参见Coursera Algorithm Part I.

但效率未必是最高的，因为如果数据量很大的时候，寻找parent会很费时。*/


//http://blog.csdn.net/pointbreak1/article/details/48796691

public class F_261_Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
         int[] root = new int[n];  
        for(int i = 0; i < n; i++)  
            root[i] = i;  
        for(int i = 0; i < edges.length; i++) {  
            int root1 = find(root, edges[i][0]);  
            int root2 = find(root, edges[i][1]);  
            if(root1 == root2)  
                return false;  
            root[root2] = root1;  
        }  
        return edges.length == n - 1;  
    }  
      
    private int find(int[] root, int e) {  
        if(root[e] == e)  
            return e;  
        else  
            return find(root, root[e]);  
    }
}
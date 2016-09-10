package ch9S.chapter2_DataStructure1;

import java.util.*;

public class _02the_Weak_Connected_Component_in_the_Directed_Graph {
class UnionFind{
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    UnionFind(HashSet<Integer> hashSet){
      for(Integer now : hashSet) {
        father.put(now, now);
      }
    }
  int find(int x){
    int parent =  father.get(x);
    while(parent!=father.get(parent)) {
      parent = father.get(parent);
    }
    return parent;
  }
  int compressed_find(int x){
    int parent =  father.get(x);
    while(parent!=father.get(parent)) {
      parent = father.get(parent);
    }
    int temp = -1;
    int fa = father.get(x);
    while(fa!=father.get(fa)) {
      temp = father.get(fa);
      father.put(fa, parent) ;
      fa = temp;
    }
    return parent;
      
  }
  
  void union(int x, int y){
    int fa_x = find(x);
    int fa_y = find(y);
    if(fa_x != fa_y)
      father.put(fa_x, fa_y);
  }
  }
  List<List<Integer> >  print(HashSet<Integer> hashSet, UnionFind uf, int n) {
    List<List <Integer> > ans = new ArrayList<List<Integer>>();
  HashMap<Integer, List <Integer>> hashMap = new HashMap<Integer, List <Integer>>();
  for(int i : hashSet){
    int fa = uf.find(i);
    if(!hashMap.containsKey(fa)) {
      hashMap.put(fa,  new ArrayList<Integer>() );
    }
    List <Integer> now =  hashMap.get(fa);
    now.add(i);
    hashMap.put(fa, now);
  }
  for( List <Integer> now: hashMap.values()) {
  Collections.sort(now);
    ans.add(now);
  }
    return ans;
  }
  
  public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes){
  // Write your code here
  
    HashSet<Integer> hashSet = new HashSet<Integer>(); 
    for(DirectedGraphNode now : nodes){
      hashSet.add(now.label);
      for(DirectedGraphNode neighbour : now.neighbors) {
        hashSet.add(neighbour.label);
      }
    }
    UnionFind uf = new UnionFind(hashSet);

  
    for(DirectedGraphNode now : nodes){
      
      for(DirectedGraphNode neighbour : now.neighbors) {
        int fnow = uf.find(now.label);
      int fneighbour = uf.find(neighbour.label);
      if(fnow!=fneighbour) {
        uf.union(now.label, neighbour.label);
      }
      }
    }
  
  
  return print(hashSet , uf, nodes.size());
  }
}

/*Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected set of a directed graph is a subgraph in which any 
 * two vertices are connected by direct edge path.)
 

 Notice

Sort the element in the set in increasing order

Have you met this question in a real interview? Yes
Example
Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected 
component which are {A,B,D} and {C,E,F}

Tags 
Union Find
Related Problems 
Hard Number of Islands II 15 %
Medium Find the Weak Connected Component in the Directed Graph 22 %
Medium Find the Connected Component in the Undirected Graph 21 %*/
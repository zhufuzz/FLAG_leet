package ch9.DFS;

import java.util.ArrayList;
import java.util.HashMap;

//  http://blog.csdn.net/ljiabin/article/details/45846837
// http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
/*There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.*/
public class Ch9_207_Course_Schedule{
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      if(prerequisites == null){ throw new IllegalArgumentException("illegal prerequisites array");}   
      int len = prerequisites.length;   
      if(numCourses == 0 || len == 0){ return true; }   
      //track visited courses
      int[] visit = new int[numCourses];   
      // use the map to store what courses depend on a course 
      HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
      for(int[] a: prerequisites){
          if(map.containsKey(a[1])){
              map.get(a[1]).add(a[0]);
          }else{
              ArrayList<Integer> l = new ArrayList<Integer>();
              l.add(a[0]);            map.put(a[1], l);
          }
      }   
      for(int i=0; i<numCourses; i++){
          if(!canFinishDFS(map, visit, i)) return false;
      }   
      return true;
  }   
  private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
      if(visit[i]==-1)           return false;
      if(visit[i]==1)           return true;   
      visit[i]=-1;
      if(map.containsKey(i)){
          for(int j: map.get(i)){
              if(!canFinishDFS(map, visit, j)) return false;
          }
      }   
      visit[i]=1;   
      return true;
  }
}
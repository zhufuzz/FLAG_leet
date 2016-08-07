package facebook.leetcode;
//Hash Table, String
import java.util.*;

/*Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:[  ["ate", "eat","tea"],  ["nat","tan"],  ["bat"]]
Note:For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.*/
//http://www.cnblogs.com/springfor/p/3874667.html
//http://www.programcreek.com/2014/04/leetcode-anagrams-java/

public class F_49_Group_Anagrams2{ 
  
   public List<String> anagrams(String[] strs) {
      ArrayList<String> result = new ArrayList<String>();
      if(strs == null || strs.length == 0) return result;
   
      HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
     
      for(int i=0; i<strs.length; i++){
          char[] arr = strs[i].toCharArray();
          Arrays.sort(arr);
          String t = String.valueOf(arr);
          if(map.get(t) == null){
              ArrayList<Integer> l = new ArrayList<Integer>();
              l.add(i);
              map.put(t, l);
          }else{
              map.get(t).add(i);
          }
      }
      
      for(ArrayList<Integer> l: map.values()){
          if(l.size() > 1){
              for(Integer i: l){
                  result.add(strs[i]);
              }
          }
      }   
      return result;
  }
}
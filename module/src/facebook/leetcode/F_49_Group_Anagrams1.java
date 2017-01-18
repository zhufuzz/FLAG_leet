package facebook.leetcode;
//Hash Table, String    
import java.util.*;
/*Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.*/
//http://www.cnblogs.com/springfor/p/3874667.html
//https://leetcode.com/discuss/84756/share-my-20-line-java-code

public class F_49_Group_Anagrams1{
  public List<List<String>> groupAnagrams(String[] strs) {
    
      List<List<String>> ans = new ArrayList<List<String>>();
      if (strs==null || strs.length==0) { return ans; }
      
      Arrays.sort(strs);
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      
      for (String s: strs) {
        
         char[] sCharArr = s.toCharArray();
         Arrays.sort(sCharArr);
         String key = new String(sCharArr);
         List<String> list = map.get(key);
         
         if (list == null) {
             List<String> temp = new ArrayList<String>();
             temp.add(s);
             map.put(key, temp);
         } else {
           list.add(s);
         }
      }
      
      ans.addAll(map.values());
      return ans;
  }
}
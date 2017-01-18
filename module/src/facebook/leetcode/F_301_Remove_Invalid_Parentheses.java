package facebook.leetcode;
//DFS, BFS
import java.util.*;
/*Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).
Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]*/

public class F_301_Remove_Invalid_Parentheses {    
  public List<String> removeInvalidParentheses(String s) {
      int numl=0;
      int numr=0;
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='(') numl++;
          if(s.charAt(i)==')'&&numr<numl) numr++;
      }
      int numvalid=Math.min(numl,numr); //get valid length of parentheses.
      List<String> ans=new ArrayList<String>();
      re(s,"",0,0,0,numvalid,ans);
      return ans;
  }

  public void re(String s,String tmp,int numl,int numr,int i, int limit,List<String> ans){
      if(limit-numl+limit-numr>s.length()-i) return; // if the remaining string does not contain enough character then return;
      if(i==s.length()&&numl==limit&&numr==limit){
          ans.add(tmp);
          return;
      }
      if(i==s.length()) return;
      char cur=s.charAt(i);
      if(cur=='('||cur==')'){
          int a=i;
          while(a+1<s.length()&&s.charAt(a)==s.charAt(a+1)) a++;
          re(s,tmp,numl,numr,a+1,limit,ans); //leave it;
          if(cur=='(') numl++;
          if(cur==')') numr++;
          if(numl>=numr&&numl<=limit)
          re(s,tmp+cur,numl,numr,i+1,limit,ans); //keep it;
      }
      else 
      re(s,tmp+cur,numl,numr,i+1,limit,ans); //ignore the other character;
  }
}
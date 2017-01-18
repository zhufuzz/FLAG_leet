package facebook.leetcode;
//Hash Table Two Pointers String

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
Note:If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/

//https://leetcode.com/discuss/83594/java-n-solution-without-hashmap-beats-90%25-with-explanation

public class F_76_Minimum_Window_Substring_v3 {
  public String minWindow(String s, String t) {
    if(s.length()==0 || t.length()==0) return "";

    int[] table = new int[256];
    for(char c: s.toCharArray()) {
        ++table[c];
    }
    for(char c: t.toCharArray()) {
        if(--table[c]<0) return "";
    }

    int start=0, end=s.length()-1;
    while(--table[s.charAt(end)]>=0) --end;
    ++table[s.charAt(end)];
    while(--table[s.charAt(start)]>=0) ++start;
    ++table[s.charAt(start)];
    int min = end-start+1;
    String result = s.substring(start, end+1);

    while(++end<s.length()) {
        ++table[s.charAt(end)];
        while(--table[s.charAt(start)]>=0) ++start;
        ++table[s.charAt(start)];
        if(end-start+1<min) {
            min = end-start+1;
            result = s.substring(start, end+1);
        }
    }
    return result;
  }
}

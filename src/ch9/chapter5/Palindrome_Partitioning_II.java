package ch9.chapter5;
/*
 * Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 24 %
Medium Palindrome Partitioning 23 %
Medium Longest Palindromic Substring
 */
public class Palindrome_Partitioning_II {

}
/*
 * ￼￼Palindrome Partitioning II
• state: f[i]表示前i个字符组成的子串能被分割为最少多少个回文串 
• function: f[i] = MIN{f[j]+1}, j < i && j+1 ~ i这一段是一个回文串
• initialize: f[i] = i (f[0] = 0)
• answer: f[n] – 1
为什么-1? 分为x个串需要x-1刀
￼￼￼￼￼￼￼￼￼￼￼
 * */

//version 1
//f[i] 表示前i个字母，最少可以被分割为多少个回文串
//最后return f[n] - 1
class Palindrome_Partitioning_II1 {
 private boolean[][] getIsPalindrome(String s) {
     boolean[][] isPalindrome = new boolean[s.length()][s.length()];

     for (int i = 0; i < s.length(); i++) {
         isPalindrome[i][i] = true;
     }
     for (int i = 0; i < s.length() - 1; i++) {
         isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
     }

     for (int length = 2; length < s.length(); length++) {
         for (int start = 0; start + length < s.length(); start++) {
             isPalindrome[start][start + length]
                 = isPalindrome[start + 1][start + length - 1] 
                		 && s.charAt(start) == s.charAt(start + length);
         }
     }

     return isPalindrome;
 }

 public int minCut(String s) {
     if (s == null || s.length() == 0) {
         return 0;
     }

     // preparation
     boolean[][] isPalindrome = getIsPalindrome(s);
     
     // initialize
     int[] f = new int[s.length() + 1];
     f[0] = 0;
     
     // main
     for (int i = 1; i <= s.length(); i++) {
         f[i] = Integer.MAX_VALUE; // or f[i] = i
         for (int j = 0; j < i; j++) {
             if (isPalindrome[j][i - 1]) {
                 f[i] = Math.min(f[i], f[j] + 1);
             }
         }
     }

     return f[s.length()] - 1;
 }
}

//version 2
//9CH summer 2016 too
//f[i] 表示前i个字母，最少被切割几次可以切割为都是回文串。
//最后return f[n]
/*
 * state:
 * 1, f[i] 表示前i个字符组成的前缀，最少切割几次，能切成全部是回文串
 * 比如："aab" f[3] = f["aab"] = 1
 *            f[2] = f["aa"] = 0
 *            f[1] = f["a"] = 0
 *            f[0] = f[""] = -1
 *            f[i] = min{f[j] + 1}
 *            
 *            ""|aa
 *            f[""] + 1 = f["aa"]
 *            f[""] = f["aa"] - 1
 *            f[""] = 0 - 1 = -1
 * 2, f[i] 表示第i个字符，组成的前缀，最少能分割为几个回文串
 * 		return f[n] - 1
 */
class Palindrome_Partitioning_II2 {
//O(n)
 private boolean isPalindrome(String s, int start, int end) {
     for (int i = start, j = end; i < j; i++, j--) {
         if (s.charAt(i) != s.charAt(j)) {
             return false;
         }
     }
     return true;
 }

 private boolean[][] getIsPalindrome(String s) {
     boolean[][] isPalindrome = new boolean[s.length()][s.length()];

     for (int i = 0; i < s.length(); i++) {
         isPalindrome[i][i] = true;
     }
     for (int i = 0; i < s.length() - 1; i++) {
         isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
     }

     for (int length = 2; length < s.length(); length++) {
         for (int start = 0; start + length < s.length(); start++) {
             isPalindrome[start][start + length]
                 = isPalindrome[start + 1][start + length - 1] 
                		 && s.charAt(start) == s.charAt(start + length);
         }
     }

     return isPalindrome;
 }

 public int minCut(String s) {
     if (s == null || s.length() == 0) {
         return 0;
     }

     // preparation
     boolean[][] isPalindrome = getIsPalindrome(s);
     
     // initialize
     int[] f = new int[s.length() + 1];
     for (int i = 0; i <= s.length(); i++) {
         f[i] = i - 1;
     }
     
     // main
     for (int i = 1; i <= s.length(); i++) {
         for (int j = 0; j < i; j++) {
             if (isPalindrome[j][i - 1]) {
                 f[i] = Math.min(f[i], f[j] + 1);
             }
         }
     }

     return f[s.length()];
 }
}

//9Ch summer 2016
class Solution{
	public int minCut(String s){
		//
		for(int i = n - 1; i >= 0; i--){
			for(int j = i + 1; j < n; j++){
				f[i][j] = f[i + 1][j - 1] && s[i] == s[j];
			}
		}
	
		//f[i][j] <- f[i + 1][j - 1];
		//(0, n - 1)
		for(int delta = 1; delta < n; delta++){
			for(int i = 0; i < n; i++){
				int j = i + delta;
				f[i][j] = f[i + 1][j - 1] && s[i] == s[j];
			}
		}
	}
}
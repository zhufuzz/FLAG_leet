package ch9J.chapter5_DP2;
//version 1
//f[i] 表示前i个字母，最少可以被分割为多少个回文串
//最后return f[n] - 1

public class _2Palindrome_Partitioning_II_1 {
 private boolean[][] getIsPalindrome(String s) {
     boolean[][] isPalindrome = new boolean[s.length()][s.length()];

     for (int i = 0; i < s.length(); i++) {
         isPalindrome[i][i] = true;
     }
     for (int i = 0; i < s.length() - 1; i++) {
         isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
     }

     for (int length = 2; length < s.length(); length++) {
    	 	//start end, 而非i j 这是区间型动态规划的特点
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
 //下标j到i - 1的String是否为回文字符串， 也就是第j＋1个字符到第i个字符的string
             if (isPalindrome[j][i - 1]) {
                 f[i] = Math.min(f[i], f[j] + 1);
             }
         }
     }

     return f[s.length()] - 1;
 }
}
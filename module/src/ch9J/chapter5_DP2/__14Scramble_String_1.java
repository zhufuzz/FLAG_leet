package ch9J.chapter5_DP2;//区间类

import java.util.Arrays;

//普通搜索
public class __14Scramble_String_1 {
 /**
  * @param s1 A string
  * @param s2 Another string
  * @return whether s2 is a scrambled string of s1
  */
 public boolean isScramble(String s1, String s2) {
     // Write your code here
     if (s1.length() != s2.length()) {
         return false;
     }
     
     if (s1.length() == 0 || s1.equals(s2)) {
         return true;
     }
     
     if (!isValid(s1, s2)) {
         return false;
     }// Base Cases
     
     for (int i = 1; i < s1.length(); i++) {
         String s11 = s1.substring(0, i);
         String s12 = s1.substring(i, s1.length());
         String s21 = s2.substring(0, i);
         String s22 = s2.substring(i, s2.length());
         String s23 = s2.substring(0, s2.length() - i);
         String s24 = s2.substring(s2.length() - i, s2.length());
         
         if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
         if (isScramble(s11, s24) && isScramble(s12, s23)) return true;// cut 
     }
     return false;
 }
 
 private boolean isValid(String s1, String s2) {
     char[] arr1 = s1.toCharArray();
     char[] arr2 = s2.toCharArray();
     Arrays.sort(arr1);
     Arrays.sort(arr2);
     if (!(new String(arr1)).equals(new String(arr2))) {
         return false;
     }
     return true;
 }
}


/*
 * Given a string s1, we may represent it as a binary tree by 
 * partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and 
swap its two children.

For example, if we choose the node "gr" and swap its two children,
 it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" 
and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, 
determine if s2 is a scrambled string of s1.

Have you met this question in a real interview? Yes
Example
Challenge 
O(n3) time

Tags 
String Dynamic Programming
 */

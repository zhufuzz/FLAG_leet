package ch9S.chapter6_DP2;

import java.util.Arrays;

public class _04ScrambleString_MemorizeSearch {
	/**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
     
     private boolean checkScramble(String s1,int start1, String s2, int start2, int k, int [][][]visit) {
		if(visit[start1][start2][k] == 1)
            return true;
        if(visit[start1][start2][k] ==-1)
            return false;
        
        
        if (s1.length() != s2.length()) {
            visit[start1][start2][k] = -1;
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            visit[start1][start2][k] = 1;
            return true;
        }
        
        if (!isValid(s1, s2)) {
            visit[start1][start2][k] = -1;
            return false;
        }// Base Cases
        
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());
            
            if (checkScramble(s11,start1, s21, start2, i, visit) && checkScramble(s12, start1+i, s22, start2+i,k-i, visit))  {
                visit[start1][start2][k] = 1;
                return true;
            }
            
            if (checkScramble(s11,start1, s24, start2+k-i, i, visit) && checkScramble(s12,start1+i, s23,start2, k-i, visit))
            {
                visit[start1][start2][k] = 1;
                return true;
            }
        }
        visit[start1][start2][k] = -1;
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int [][][] visit = new int[len][len][len + 1];
        return checkScramble(s1,0,s2,0, len, visit);
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

/*Given a string s1, we may represent it as a binary tree by partitioning 
 * it to two non-empty substrings recursively.
 

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its 
two children.

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

Similarly, if we continue to swap the children of nodes "eat" and 
"at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 
is a scrambled string of s1.*/
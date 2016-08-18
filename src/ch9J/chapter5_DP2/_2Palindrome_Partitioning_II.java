package ch9J.chapter5_DP2;
/*
 * Given a string s, cut s into some substrings such that every 
 * substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be
 produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 24 %
Medium Palindrome Partitioning 23 %
Medium Longest Palindromic Substring
 */

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




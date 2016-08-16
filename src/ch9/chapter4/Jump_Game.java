package ch9.chapter4;
/*
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. 
This is just to let you learn how to use this problem in dynamic programming ways. 
If you finish it in dynamic programming ways, you can try greedy method to make 
it accept again.

Have you met this question in a real interview? Yes
Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Tags 
Greedy Dynamic Programming Array
Related Problems 
Medium Jump Game II
 */
public class Jump_Game {

}
/*
 * Jump Game
￼￼• 最优算法:贪心法,时间复杂度 O(n)
• 次优算法:动态规划,时间复杂度 O(n^2) 
• state: f[i]代表我能否跳到第i个位置
• function: f[i] = OR{f[j]} 其中 j < i && j能够跳到i 
• 解释:什么是 OR 运算?
• 比如满足 j < i && j 能够跳到 i 的 j 有 0, 1, 4, 7 
• 那么 f[i] 
 */
//version 1: Dynamic Programming
class Jump_Game1 {
 public boolean canJump(int[] A) {
     boolean[] can = new boolean[A.length];
     can[0] = true;
//1. state
//f[i] = 能不能根从index = 0跳到index =i
//2.function
//f[i] = OR(f[j]) (0 <= j <= i - 1 并且j能跳到 i: j + A[j] >= i)
//3.initialize
//f[0] = true;
//f[...] = false;
//4.answer
//f[n - 1]
//第n个数的坐标是 n － 1 ！！！！！
     
     //OR: &&
     //只考虑倒数第一步，就是i之前的那步
     for (int i = 1; i < A.length; i++) {
         for (int j = 0; j < i; j++) {
             if (can[j] && j + A[j] >= i) {
                 can[i] = true;
                 break;
             }
         }
     }
     
     return can[A.length - 1];
 }
}

//version 2: Greedy
class Jump_Game2 {
 public boolean canJump(int[] A) {
     // think it as merging n intervals
     if (A == null || A.length == 0) {
         return false;
     }
     int farthest = A[0];
     for (int i = 1; i < A.length; i++) {
         if (i <= farthest && A[i] + i >= farthest) {
             farthest = A[i] + i;
         }
     }
     return farthest >= A.length - 1;
 }
}
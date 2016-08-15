package ch9.chapter4;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

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

//version 1: Dynamic Programming
class Jump_Game1 {
 public boolean canJump(int[] A) {
     boolean[] can = new boolean[A.length];
     can[0] = true;
     
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
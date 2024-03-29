package ch9J.chapter8_DataStructure;

import java.util.Stack;

public class _02Largest_Rectangle_in_Histogram {
public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i <= height.length; i++) {
        int curt = (i == height.length) ? -1 : height[i];
        while (!stack.isEmpty() && curt <= height[stack.peek()]) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }
        stack.push(i);
    }
    
    return max;
}
}
/*Given n non-negative integers representing the histogram's bar 
 * height where the width of each bar is 1, find the area of largest 
 * rectangle in the histogram.
 



Above is a histogram where width of each bar is 1, given height = 
[2,1,5,6,2,3].



The largest rectangle is shown in the shaded area,
 which has area = 10 unit.

Have you met this question in a real interview? Yes
Example
Given height = [2,1,5,6,2,3],
return 10.

Tags 
Array Stack
Related Problems 
Hard Maximal Rectangle 24 %
Hard Max Tree 29 %*/
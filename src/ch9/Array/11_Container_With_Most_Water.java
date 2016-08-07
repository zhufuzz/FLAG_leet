package leet_Array;
/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.*/

public class 11_Container_With_Most_Water {
    /*** @param heights: an array of integers
     * @return: an integer*/
    int computeArea(int left, int right,  int[] heights) {
        return (right-left)*Math.min(heights[left], heights[right]);
    }    
    public int maxArea1(int[] heights) {
        // write your code here
        int left = 0, ans=  0 ; 
        int right = heights.length - 1;
        while(left <= right) {
            ans = Math.max(ans,computeArea(left, right, heights));
            if(heights[left]<=heights[right])
                left++;
            else
                right--;
        }
        return ans;
    }
	
// for any i, the maxium area will be the farthest j that has a[j] > a[i];
    public int maxArea2(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right) {
            max = Math.max( max, (right - left) 
            * Math.min(height[left], height[right]));
            	
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;        
    }
}
package ch9S.chapter4_TwoPointer;
import java.util.Arrays;

public class _02Triangle_Count {
	 /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        int left = 0, right = S.length - 1;
        int ans = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while(left < right) {
                if(S[left] + S[right] > S[i]) {
                    ans = ans + (right - left);
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }
}
/*Given an array of integers, how many three numbers can be found 
 * in the array, so that we can build an triangle whose three edges
 *  length is the three numbers that we find?
 

Have you met this question in a real interview? Yes
Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
Tags 
Two Pointers LintCode Copyright
Related Problems 
Medium 3Sum 19 %
Medium Two Sum 28 %*/
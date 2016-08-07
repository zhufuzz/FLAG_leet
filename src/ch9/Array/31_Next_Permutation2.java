package leet_Array;
/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2  3,2,1 ¡ú 1,2,3   1,1,5 ¡ú 1,5,1*/
// version 2
public class 31_Next_Permutation2 {
    /** * @param num: an array of integers
     * @return: return nothing (void), do not return anything, modify num in-place instead    */
    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }
    
    public void nextPermutation(int[] num) {
        // find the last increase index
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }        
        // find the first bigger one
        int biggerIndex = index + 1;
        for (int i = num.length - 1; i > index; i--) {
            if (num[i] > num[index]) {
                biggerIndex = i;
                break;
            }
        }        
        // swap them to make the permutation bigger
        int temp = num[index];
        num[index] = num[biggerIndex];
        num[biggerIndex] = temp;        
        // reverse the last part
        reverse(num, index + 1, num.length - 1);
    }
}
package ch9J.chapter5_DP2;

public class Decode_Ways {
 public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int[] nums = new int[s.length() + 1];
    nums[0] = 1;
    nums[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= s.length(); i++) {
        if (s.charAt(i - 1) != '0') {
            nums[i] = nums[i - 1];
        }
        
        int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
        if (twoDigits >= 10 && twoDigits <= 26) {
            nums[i] += nums[i - 2];
        }
    }
    return nums[s.length()];
 }
}

/*
 * A message containing letters from A-Z is being encoded to 
 * numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number 
of ways to decode it.

Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.

Tags : String Dynamic Programming
 */
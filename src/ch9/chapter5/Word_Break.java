package ch9.chapter5;

import java.util.Set;
/*
 * Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Tags 
String Dynamic Programming
 */

/*单序列动态规划
￼￼￼• state: f[i]表示前i个位置/数字/字符,第i个... 
• function: f[i] = f[j] ... j 是i之前的一个位置 
• initialize: f[0]..
• answer: f[n]..
• 一般answer是f(n)而不是f(n-1)
//最大的特点就是数组要开n + 1个，结果取第n个
 * 
 */

/*
 * ￼￼Word Break
• state: f[i]表示“前i”个字符能否被完美切分
• function: f[i] = OR{f[j]} 其中 j < i && j+1~i is a word 
	• OR 运算的意思
	• 假如j=0,1,3,5时满足j<i&&j+1~iisaword 
	• 那么 f[i] = f[0] || f[1] || f[3] || f[5]
• initialize: f[0] = true 
• answer: f[n]

• 注意:切分位置的枚举->单词长度枚举 O(NL2) 
	• N: 字符串长度
	• L: 最长的单词的长度
 */
public class Word_Break {
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        //这个确保了不会去找太长的string当作单词
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
}
// 9CH summer 2016
//这个超时
class Word_Break_2016 {
	public boolean wordBreak(String s, Set<String> dict){
		int n = s.length();
		
		boolean[] f = new boolean[n + 1];
		
		//empty string is valid
		f[0] = true;
		
		//s = "abcde";
		//from "a" "ab" . to .. "abcde"
		for(int i = 1; i <= n; i++){
			//f[i] is false by default
			for(int j = 0; j < i; j++){
				if(f[j] == false){
					continue;
				}
				String sub = s.substring(i, j);
				if(dict.contains(sub)){
					f[i] = true;
					break;
				}
			}
		}
		return f[n];
	}
}
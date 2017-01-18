package facebook.leetcode;
//String
//Given two strings S and T, determine if they are both one edit distance apart.
//https://segmentfault.com/a/1190000003906621
/*
复杂度 时间 O(N) 空间 O(1)
思路 虽然我们可以用Edit Distance的解法，看distance是否为1，但Leetcode中会超时。这里我们可以利用只有一个不同的特点在O(N)时间内完成。如果两个字符串只有一个编辑距离，则只有两种情况：
两个字符串一样长的时候，说明有一个替换操作，我们只要看对应位置是不是只有一个字符不一样就行了
一个字符串比另一个长1，说明有个增加或删除操作，我们就找到第一个对应位置不一样的那个字符，如果较长字符串在那个字符之后的部分和较短字符串那个字符及之后的部分是一样的，则符合要求
如果两个字符串长度差距大于1，肯定不对
*/
public class F_161_One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == n) return isOneModified(s, t);
        if(m - n == 1) return isOneDeleted(s, t);
        if(n - m == 1) return isOneDeleted(t, s);
        // 长度差距大于2直接返回false
        return false;
    }
    
    private boolean isOneModified(String s, String t){
        boolean modified = false;
        // 看是否只修改了一个字符
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(modified) return false;
                modified = true;
            }
        }
        return modified;
    }
    
    public boolean isOneDeleted(String longer, String shorter){
        // 找到第一组不一样的字符，看后面是否一样
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i) != shorter.charAt(i)){
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}
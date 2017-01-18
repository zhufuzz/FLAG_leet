package OA1_xiaoyucool;

public class LongestPalinString{

	 public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        String max = "";
        for(int i = 0;i < 2 * s.length()-1; i++){
            int left = i/2;
            int right = i/2;
            if(i % 2 == 1){
                right++;
            }        
         String str = longestPalindromeString(s, left, right);
         if(str.length() > max.length()){
                max = str;
            }
      }
      return max;
  }
    
    private String longestPalindromeString(String s, int left, int right){
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    //DP
    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        boolean[][] res = new boolean[s.length()][s.length()];
        int start = -1;
        int maxLen = 0;
        for(int i = s.length()-1; i>=0; i--){
            for(int j = i; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || res[i+1][j-1])){
                    res[i][j] = true;
                    if(j-i+1 > maxLen){
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return start == -1 ? "" : s.substring(start, start + maxLen);        
    }
}
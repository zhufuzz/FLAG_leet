package amazonInter;
//String
public class A_5_Longest_Palindromic_Substring {
  //Java Short and Clean (13 line two pointer solution)
  public String longestPalindrome(String s) {
    String ret = "";
    for (int i = 0; i < s.length(); i++) {
        int p = i, q = i;
        while (q < s.length() - 1 && s.charAt(q + 1) == s.charAt(q)) {
            q++;
        }
        while (p >= 0 && q <= s.length() - 1 && s.charAt(p) == s.charAt(q)) {
            if (q - p + 1 > ret.length()) ret = s.substring(p, q + 1);
            p--;
            q++;
        }
    }
    return ret;
  }
  
  //jiuzhang
  public String longestPalindrome2(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }    
    int length = s.length();    
    int max = 0;
    String result = "";
    for(int i = 1; i <= 2 * length - 1; i++){
        int count = 1;
        while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
            count++;
        }
        count--; // there will be one extra count for the outbound #
        if(count > max) {
            result = s.substring((i - count) / 2, (i + count) / 2);
            max = count;
        }
    }    
    return result;
  }
  
  private char get(String s, int i) {
      if(i % 2 == 0)
          return '#';
      else 
          return s.charAt(i / 2);
  }  
}
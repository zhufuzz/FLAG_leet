package chea_sheet_oa1;
/*
 * 
 * */
public class longest_palindromic_substring {
  
  //SOL 2
  public static String longestSubstr2(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    int len = s.length();
    int max = 0;
    String rst = "";
    //expand string to 2 times length
    //assume there is one more char '#' adjacent to every char in the string
    for (int i = 1; i <= 2 * len - 1; i++) {
      int cnt = 1;
      //consider every char in the string as center and check whether its neighbors equal
      //palindrome check
      while (i - cnt >= 0 && i + cnt <= 2 * len && get(s, i - cnt) == get(s, i + cnt)) {
        cnt++;
      }
      //there will be one extra cnt for the outbound
      cnt--;
      if (cnt > max) {
        rst = s.substring((i - cnt) / 2, (i + cnt) / 2);
        max = cnt;
      }
    }
    return rst;
  }

  
  private static char get(String s, int i) {
    if (i % 2 == 0) {
      return '#';
    } else {
      return s.charAt(i / 2);
    }
  }

  
  public static void main(String[] args) {
    System.out.print(longestSubstr2("xyyxabcdcba"));
  }
} 

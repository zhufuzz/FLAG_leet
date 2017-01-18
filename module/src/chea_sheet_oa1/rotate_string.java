package chea_sheet_oa1;

public class rotate_string {
  //SOL 1
  public static int isRotation2(String word1, String word2) {
  if (word1 == null || word2 == null || word1.length() == 0
      || word2.length() == 0 || word1.length() != word2.length()) {
    return -1;
  }
  String str = word1+word2;
  return str.contains(word2) ? 1 : -1;
  // return str.indexOf(word2) ? 1 : -1;
  }

  //SOL 2
  public static boolean isRotation1(String s1, String s2) {
    int len = s1.length();
    if (len == s2.length() && len > 0) {
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
    }
  
  private static boolean isSubstring(String big, String small) {
    if (big.indexOf(small) >= 0) {
      return true;
    } else {
      return false;
    }
  }
}

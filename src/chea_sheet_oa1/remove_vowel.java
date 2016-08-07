package chea_sheet_oa1;
/*indexOf Returns the index within this string of the first occurrence
 *  of the specified character or -1 if the character does not occur*/
import java.util.Arrays;
import java.util.HashSet;
public class remove_vowel {
  public static String remove1(String s) {
    StringBuilder sb = new StringBuilder();
    HashSet<Character> hash = new HashSet<Character>(
        Arrays.asList( new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
    for (Character c : s.toCharArray()) {
      if (hash.contains(c)) {
        continue;
      }
      sb.append(Character.toString(c));
    }
    return sb.toString();
  }
  
  public static String remove2(String s) {
    StringBuilder sb = new StringBuilder();
    String vowel = "aeiouAEIOU";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (vowel.indexOf(c) == -1) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

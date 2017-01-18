package amazonInter;
//Binary Recursion
import java.util.ArrayList;

/*The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, find the sequence of gray code. 
A gray code sequence must begin with 0 and with cover all 2n integers.*/

public class lint_411_Gray_Code {
  public ArrayList<Integer> grayCode(int n) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      if (n <= 1) {
          for (int i = 0; i <= n; i++){
              result.add(i);
          }
          return result;
      }
      result = grayCode(n - 1);
      ArrayList<Integer> r1 = reverse(result);
      int x = 1 << (n-1);
      for (int i = 0; i < r1.size(); i++) {
          r1.set(i, r1.get(i) + x);
      }
      result.addAll(r1);
      return result;
  }
  
  public ArrayList<Integer> reverse (ArrayList<Integer> r) {
      ArrayList<Integer> rev = new ArrayList<Integer>();
      for (int i = r.size() - 1; i >= 0; i--) {
          rev.add(r.get(i));
      }
      return rev;
  }
}
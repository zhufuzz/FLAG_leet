package amazonInter;
import java.util.*;
//backtracking
/*The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0    01 - 1      11 - 3    10 - 2
Note:For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/

public class A_89_Gray_Code {  
  //few lines of Java code 1ms no recursion
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<Integer>();
    result.add(0);    
    for(int i=1; i<=n; i++){
        int size = result.size()-1;
        for(int j=size; j>=0; j--){
            result.add(result.get(j) | 1<<i-1);
        }
    }
    return result;
  }
  
  //All we need to do is to add an '1' to the top digit of the binary string and reversely added the new number to the list.
  public List<Integer> grayCode2(int n) {
    List<Integer> ans = new ArrayList<>();
    ans.add(0);
    for(int i = 0; i < n ; i++)
        for(int j = ans.size()-1; j>=0; j--)
            ans.add(ans.get(j)+(1<<i));
    return ans;
  }
  
  //JAVA-----------Easy Version To Understand!!!!!!
  public static List<Integer> grayCode3(int n) {
    if (n < 0)
        return new ArrayList<Integer>();
    if (n == 0) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        return list;
    }
    List<Integer> tmp = grayCode3(n - 1);
    List<Integer> result = new ArrayList<Integer>(tmp);
    int addNumber = 1 << (n - 1);
    for (int i = tmp.size() - 1; i >= 0; i--) {
        result.add(addNumber + tmp.get(i));
    }
    return result;
  }  
}
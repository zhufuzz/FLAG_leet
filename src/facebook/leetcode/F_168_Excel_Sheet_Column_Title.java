package facebook.leetcode;
//Math

/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */

//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
//http://www.danielbit.com/blog/puzzle/leetcode/leetcode-excel-sheet-column-title

/*[分析]
10进制转26进制

[注意事项]
1）注意while循环里面的n–，因为26进制里最小对应的是10进制里面的1，不是0*/
public class F_168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
      if(n <= 0){
        throw new IllegalArgumentException("Input is not valid!");
    }
 
    StringBuilder sb = new StringBuilder();
 
    while(n > 0){
        n--;
        char ch = (char) (n % 26 + 'A');
        n /= 26;
        sb.append(ch);
    }
 
    sb.reverse();
    return sb.toString();
    }
}
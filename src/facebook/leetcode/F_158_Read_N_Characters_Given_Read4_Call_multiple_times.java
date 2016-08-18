package facebook.leetcode;
import java.util.*;//String
/*The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n)
 *  that reads n characters from the file.
 *  
Note:The read function may be called multiple times.*/
//https://segmentfault.com/a/1190000003794420
/* The read4 API is defined in the parent class Reader4. int read4(char[] buf); */

/*复杂度  时间 O(N) 空间 O(1) 思路
用一个临时数组，存放每次read4读到字符，再用一个指针标记buf数组目前存储到的位置，
然后将这个临时数组的内容存到buf相应的位置就行了。这里需要注意两个corner case：
如果本次读到多个字符，但是我们只需要其中一部分就能完成读取任务时，
我们要拷贝的长度是本次读到的个数和剩余所需个数中较小的. 如果read4没有读满4个，说明数据已经读完，
这时候对于读到的数据长度，因为也可能存在我们只需要其中一部分的情况，
所以要返回总所需长度和目前已经读到的长度的较小的*/
class Reader4{
	
}

public class F_158_Read_N_Characters_Given_Read4_Call_multiple_times extends Reader4 {
  Queue<Character> remain = new LinkedList<Character>();  
  
  public int read(char[] buf, int n) {
      int i = 0;
      // 队列不为空时，先读取队列中的暂存字符
      while(i < n && !remain.isEmpty()){
          buf[i] = remain.poll();
          i++;
      }
      for(; i < n; i += 4){
          char[] tmp = new char[4];
          int len = read4(tmp);
          // 如果读到字符多于我们需要的字符，需要暂存这些多余字符
          if(len > n - i){
              System.arraycopy(tmp, 0, buf, i, n - i);
              // 把多余的字符存入队列中
              for(int j = n - i; j < len; j++){
                  remain.offer(tmp[j]);
              }
          // 如果读到的字符少于我们需要的字符，直接拷贝
          } else {
              System.arraycopy(tmp, 0, buf, i, len);
          }
          // 同样的，如果读不满4个，说明数据已经读完，返回总所需长度和目前已经读到的长度的较小的
          if(len < 4) return Math.min(i + len, n);
      }
      // 如果到这里，说明都是完美读取，直接返回n
      return n;
    }

private int read4(char[] tmp) {
	// TODO Auto-generated method stub
	return 0;
}
}
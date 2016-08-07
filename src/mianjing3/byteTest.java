package mianjing3;
//term1和term2是题目给的两个BYTE
public class byteTest {
  int solution(byte term1, byte term2){
    byte x = (byte)(term1 ^ term2);
    int total = 0;
    while(x != 0){
      x = (byte) (x & (x - 1));  total++;
    }
    if(total == 1) return 1;
    else return 0;
    }
}

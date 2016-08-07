package mianjing3;

public class greyCode {
  public  int solution(byte element1, byte element2) {
    byte res = (byte) (element1 ^ element2);
    for (int i = 0; i <= 7; i++) {
      byte temp = (byte)(1 << i);
      if (temp == res) {
        return 1;
      }
    }
    System.out.println("No");
    return 0;
  }
}

package chea_sheet_oa1;

public class gray_code {
  //if can be placed successively in a gray code sequence return 1 else 0
  public static int grayCheck(byte term1, byte term2) {
  //XOR operation by bit
  //for gray code there is only one diff between two terms
  byte rst = (byte)(term1 ^ term2);
  for (int i = 0; i <= 7; i++) {
    byte tmp = (byte)(1 << i);
    if (tmp == rst) {
      return 1;
    }
  }
  return 0;
  }
  
  public static void main(String[] args) {
    byte term1 = (byte)0x0a, term2 = (byte)0x80;
    int out;
    out = grayCheck(term1, term2);
    System.out.println(out);
  }
}

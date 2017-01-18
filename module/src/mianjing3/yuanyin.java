package mianjing3;
//string 是题目给的字符串
public class yuanyin {
  public String soluction(String string){
  StringBuffer sb = new StringBuffer();
  String v = "aeiouAEIOU";
  for(int i = 0; i < string.length(); i++){
    if(v.indexOf(string.charAt(i)) > -1) continue;
    sb.append(string.charAt(i));
  }
  return sb.toString();
  }
}

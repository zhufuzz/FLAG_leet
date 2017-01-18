package chea_sheet_oa1;
import java.util.HashMap;
import java.util.Stack;
//Valid Parentheses
// time O(n), space O(n / 2)

public class Valid_Parentheses {
  public boolean isValid1(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty()) {
        stack.push(s.charAt(i));
      } else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2) {
        stack.pop();
      } else {
        stack.push(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }
  
  //isValid2
  public boolean isValid2(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack<Character>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (stack.isEmpty()) {
      if (c == ')' || c == ']' || c == '}') {
        return false;
      }
      stack.push(c);
      continue;
      }
      if (c == ')' && stack.peek() == '('
      || c == ']' && stack.peek() == '['
      || c == '}' && stack.peek() == '{') {
        stack.pop();
      } else if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }
  
  //isValid3
  public boolean isValid3(String s) {
    if (s == null || s.length() % 2 == 1) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    /*
    map.put('a', '1');
    map.put('b', '2');
    */
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        stack.push(c);
      } else if (map.containsValue(c)) {
        if (!stack.isEmpty() && map.get(stack.peek()) == c) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
    };
}


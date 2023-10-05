package main.java.com.uin.day;

import java.util.ArrayDeque;
import java.util.Deque;

public class Int1626 {

  public static void main(String[] args) {
    calculate("3+5 / 2");
  }
  public static int calculate(String s) {
    char[] cs = s.trim().toCharArray();
    Deque<Integer> stack = new ArrayDeque<>();
    int ans = 0;
    int i = 0;
    while (i < cs.length) {
      if (cs[i] == ' ') {
        i++;
        // 直接找下一个数字
        continue;
      }
      char tmp = cs[i];
      if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
        i++;
        while (i < cs.length && cs[i] == ' ') {
          i++;
        }
      }
      int num = 0;
      while (i < cs.length && Character.isDigit(cs[i])) {
        num = num * 10 + cs[i] - '0';
        i++;
      }
      switch (tmp) {
        case '-':
          num = -num;
          break;
        case '*':
          num = stack.pop() * num;
          break;
        case '/':
          num = stack.pop() / num;
          break;
        default:
          break;
      }
      stack.push(num);
    }
    while (!stack.isEmpty()) {
      ans += stack.pop();
    }
    return ans;
  }
}

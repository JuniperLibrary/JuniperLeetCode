package main.java.com.uin.day;

import java.util.ArrayList;
import java.util.List;

/**
 * 722 删除注释
 * <p>
 * https://leetcode.cn/problems/remove-comments/description/
 *
 * @author dingchuan
 */
public class LeetCode722 {

  public List<String> removeComments(String[] source) {
    // 每一行的代码为一个string[]的下标
    // true 表示在注视内 false表示不再注释内
    List<String> res = new ArrayList<>();
    StringBuilder newLine = new StringBuilder();
    boolean inBlock = false;
    // 如果不在注释内，会有三种情况
    // 1. 块代码注释 /* 则将状态改为在注释内，继续便利后面的第三个字符
    // 2. 行代码注释 // 直接忽略行代码注释后面的代码
    // 3. 其他字符 将该字符记录
    // 如果遇到 */ 则将状态改为不在注释内，继续便利后面的第三个字符

    for (String s : source) {
      for (int i = 0; i < s.length(); i++) {
        if (inBlock) {
          if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
            inBlock = false;
            i++;
          }
        } else {
          if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
            break;
          } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
            inBlock = true;
            i++;
          } else {
            newLine.append(s.charAt(i));
          }
        }
      }
      if (!inBlock && newLine.length() > 0) {
        res.add(newLine.toString());
        newLine.setLength(0);
      }
    }
    return res;
  }
}

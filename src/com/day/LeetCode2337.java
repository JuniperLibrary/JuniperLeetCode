package com.day;

public class LeetCode2337 {

  public static void main(String[] args) {
    canChange("_L__R__R_", "L____RR");
  }

  public static boolean canChange(String start, String target) {
    // 2337. 移动片段得到字符串
    // L 只有在左侧直接存在一个空位时才能向左移动
    // R 只有在其左侧直接存在一个 空位 才能向右移动
    if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
      return false;
    }
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (start.charAt(i) == '_') {
        continue;
      }
      while (target.charAt(j) == '_') {
        j++;
      }
      if (i != j && (start.charAt(i) == 'L') == (i < j)) {
        return false;
      }
      ++j;
    }
    return true;
  }
}

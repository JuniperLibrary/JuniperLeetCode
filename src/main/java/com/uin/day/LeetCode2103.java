package com.uin.day;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode2103 {

  /**
   * 2103 环和杆
   * <p>
   * 总计有n个环 环的颜色可以是红 绿 蓝 中的一种 这些环分别穿在10 根编号为 0 到 9 的杆上。
   * <p>
   * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
   * <p>
   * 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
   * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
   * <p>
   * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量
   */

  public static void main(String[] args) {
    log.info("环和杆：{}",countPoints("B0R0G0R9R0B0G0"));
  }

  static final int POLE_NUM = 10;
  static final int COLOR_NUM = 3;

  public static int countPoints(String rings) {
    int[][] state = new int[POLE_NUM][COLOR_NUM];
    int n = rings.length();
    for (int i = 0; i < n; i += 2) {
      char color = rings.charAt(i);
      int poleIndex = rings.charAt(i + 1) - '0';
      state[poleIndex][getColorId(color)] = 1;
    }
    int res = 0;
    for (int i = 0; i < POLE_NUM; i++) {
      boolean flag = true;
      for (int j = 0; j < COLOR_NUM; j++) {
        if (state[i][j] == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        res++;
      }
    }
    return res;
  }

  private static int getColorId(char color) {
    if (color == 'R') {
      return 0;
    } else if (color == 'G') {
      return 1;
    }
    return 2;
  }
}

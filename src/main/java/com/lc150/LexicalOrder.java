package com.lc150;

import java.util.*;

public class LexicalOrder {

  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>(n);
    int curr = 1;
    for (int i = 0; i < n; i++) {
      result.add(curr);
      System.out.println("访问: " + curr);
      if (curr * 10 <= n) {
        System.out.println(" → 向下进入子节点: " + (curr * 10));
        curr *= 10;
      } else {
        while (curr % 10 == 9 || curr + 1 > n) {
          System.out.println(" ↩ 回退，从 " + curr + " 回到父节点: " + (curr / 10));
          curr /= 10;
        }
        System.out.println(" → 移动到下一个兄弟节点: " + (curr + 1));
        curr += 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LexicalOrder l = new LexicalOrder();
    System.out.println(l.lexicalOrder(13));
  }
}

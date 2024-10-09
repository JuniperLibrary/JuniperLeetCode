package com.dingchuan;

import java.util.Deque;
import java.util.LinkedList;

public class Lc42 {

  public int trap(int[] height) {
    int n = height.length;
    if (n == 0) {
      return 0;
    }
    int[] leftMax = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; ++i) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    int[] rightMax = new int[n];
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Lc42().trap(height));
  }

  public int trap2(int[] height) {
    int ans = 0;
    Deque<Integer> stack = new LinkedList<>();
    int n = height.length;
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        int left = stack.peek();
        int curWidth = i - left - 1;
        int curHeight = Math.min(height[left], height[i]) - height[top];
        ans += curWidth * curHeight;
      }
      stack.push(i);
    }
    return ans;
  }
}

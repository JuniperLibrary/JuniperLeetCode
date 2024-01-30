package com.uin.day;



import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author dingchuan
 */
public class LC365 {
  public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
    // 确定是否有可能使用这两个水壶准确得到targetCapacity升。
    // 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一个或两个来盛放取得的 targetCapacity升水
    // - 你可以任意装满一个水壶
    // - 清空任意一个水壶
    // - 从一个水壶向另外一个水壶倒水，直到装满或者倒空
    Deque<int[]> stack = new LinkedList<>();
    stack.push(new int[]{0,0});
    Set<Long> seen = new HashSet<>();

    while (!stack.isEmpty()){
      if (seen.contains(hash(stack.peek()))){
        stack.pop();
        continue;
      }
      seen.add(hash(stack.peek()));

      int[] state = stack.pop();
      int remain_x = state[0] ,remain_y = state[1];
      if (remain_x == targetCapacity || remain_y == targetCapacity){
        return true;
      }

      stack.push(new int[]{jug1Capacity,remain_y});
      stack.push(new int[]{remain_x,jug2Capacity});
      stack.push(new int[]{0,remain_y});
      stack.push(new int[]{remain_x,0});
      stack.push(new int[]{remain_x-Math.min(remain_x,jug2Capacity-remain_y),remain_y+Math.min(remain_x,jug2Capacity-remain_y)});
      stack.push(new int[]{remain_x + Math.min(remain_y, jug1Capacity - remain_x), remain_y - Math.min(remain_y, jug1Capacity - remain_x)});
    }
    return false;
  }

  public long hash(int[] state){
    return state[0] * 1000001L + state[1];
  }

  public boolean canMeasureWater2(int x ,int y,int k){
    if (x+y < k){
      return false;
    }
    if (x==0 || y==0){
      return k ==0 || x+y ==k;
    }
    return k % gcd(x,y) == 0;
  }

  private int gcd(int x, int y) {

    int remainder = x % y;
    while (remainder !=0){
      x =y;
      y = remainder;
      remainder= x%y;
    }
    return y;
  }
}

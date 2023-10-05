package main.java.com.uin.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {

  public static void print(){
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    for (int i = 0; i < intervals.length; i++) {
      System.out.print("[");
      for (int j = 0; j < intervals[i].length; j++) {
        System.out.print(intervals[i][j]);
        if (j < intervals[i].length - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < intervals.length - 1) {
        System.out.print(", ");
      }
    }
  }

  public static void main(String[] args) {
//    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//    int[][] mergedIntervals = merge(intervals);
//    for (int[] interval : mergedIntervals) {
//      System.out.println(Arrays.toString(interval));
//    }

    print();
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    // 先按照区间起始位置进行排序
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merge = new ArrayList<>();
    merge.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      // 如果当前区间与合并后的最后一个区间有重叠
      if (intervals[i][0] <= merge.get(merge.size() - 1)[1]) {
        // 合并区间
        merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], intervals[i][1]);
      } else {
        // 否则将当前区间添加到合并列表中
        merge.add(intervals[i]);
      }
    }
    return merge.toArray(new int[merge.size()][]);
  }
}

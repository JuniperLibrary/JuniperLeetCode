package main.java.com.uin.xiaomi;
/*
在一个优化项中，为了尽可能提升用户白天使用手机的体验和续航，某些已经在系统中注册过的任务会被设置为空调务，
仅在手机空用时运行(比如教据备份或4相册整理)，现在系统中注册了若干组空闲任务，每个任务有各自的耗电量以及允许任务运行的最低初始电量，
需要计算手机能够串行完成全部任务的最低初始电量。

注意点1:所有电量以mAh(毫安时)计，Xiaomi MIX Fold 3的大电池容量是4800mAh。
注意点2:本题目假设手机在运行空闲任务期间，不处于充电状态，也没有额外耗电行为。
注意点3:智能应用引擎会以最合适的顺序串行运行任务,

输入描述
一个描述了所有任务的长字符串。任务与任务之间用逗号隔开，每组任务由耗电量及最低初始电量组成，用冒号隔开。
输出描述
一个数字，代表依次完成全部任务的最低初始电量，如果最低初始电量超过手机电池容量，则返回-1.

输入 ： 1:10,2:12,3:10
输出 ： 13

在样例中，手机至少需要有13mAh的初始电量，在运行任务2后剩余电量11mAh、运行任务1后剩余电量10mAh、运行任务3后剩余7Ah
 */

import java.util.*;

public class Main1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
//    String s = "1:10,2:12,3:10";
    int minInitialBattery = solution(s);
    System.out.println(minInitialBattery);
  }

  public static int solution(String input) {
    String[] taskStrings = input.split(",");
    List<Task> tasks = new ArrayList<>();

    for (String taskString : taskStrings) {
      String[] parts = taskString.split(":");
      if (parts.length == 2) {
        int powerRequired = Integer.parseInt(parts[0]);
        int initialBatteryRequired = Integer.parseInt(parts[1]);
        tasks.add(new Task(powerRequired, initialBatteryRequired));
      }
    }
    tasks.sort((a, b) -> (b.getInitialBatteryRequired() - b.getPowerRequired()) -
        (a.getInitialBatteryRequired() - a.getPowerRequired()));
    int currentBattery = 0;
    int minInitialBattery = 0;

    for (Task task : tasks) {
      int powerRequired = task.getPowerRequired();
      int initialBatteryRequired = task.getInitialBatteryRequired();

      if (currentBattery < initialBatteryRequired) {
        int requiredCharge = initialBatteryRequired - currentBattery;
        minInitialBattery += requiredCharge;
        currentBattery += requiredCharge;
      }
      currentBattery -= powerRequired;
      if (currentBattery < 0) {
        return -1;
      }
    }
    return minInitialBattery;
  }

  static class Task {

    /**
     * 每个任务有各自的耗电量
     */
    private int powerRequired;
    /**
     * 允许任务运行的最低初始电量
     */
    private int initialBatteryRequired;

    public Task(int powerRequired, int initialBatteryRequired) {
      this.powerRequired = powerRequired;
      this.initialBatteryRequired = initialBatteryRequired;
    }

    public int getPowerRequired() {
      return powerRequired;
    }

    public int getInitialBatteryRequired() {
      return initialBatteryRequired;
    }
  }
}

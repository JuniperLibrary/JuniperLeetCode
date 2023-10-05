package com.uin.xiaomi;
/*

小米手机生产过程中会经过严苛的测试环节，其中包括手机通讯功能中的的频校准，射频校佳会打点教据上报到云端，其中包含两组教据:第一组数据中会包含次校的频道号(eg信息;第二组会上传一批数据，包含一组频道号(freq)和其对应的损失值(oss)，其中这一组频道号(freq)不会重复，且是有序的。现在需要根据第一组数据中的频道号(freg)，找到离第二组中频道号(freg)最近的那一个freq对应的loss值，如果两边一样近，则取两边loss的平均,(注:输入为int，输出为double类型四舍五入保留1位小数)
输入描述
包含两组数据:
第一组数据中会包含此次校准的频道号(freq)信息。第二组会上传一批数据，包含一组频道号(freg)和其对应的损失值(loss)，其中这一组频道号(freg)不会重复，且是有序的
输出描述
离频道号(freq)最近的freq对应的loss值，如果两边一样近，则取两边loss的平均。
输入
2800
1950:10 2000:15 3000:9
择例输出
9.0
 */

import java.util.Scanner;

public class Main2 {

  public final void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int freq = scanner.nextInt();
    scanner.nextLine();
    String lossData = scanner.nextLine();

    double nearestLoss = findNearestLoss(freq, lossData);
    System.out.println(String.format("%.1f", nearestLoss));
  }

  public static double findNearestLoss(int freq, String lossData) {
    String[] lossItems = lossData.split(" ");
    double nearestLoss = Double.MAX_VALUE;

    for (String lossItem : lossItems) {
      String[] parts = lossItem.split(":");
      if (parts.length == 2) {
        int freg = Integer.parseInt(parts[0]);
        double loss = Double.parseDouble(parts[1]);
        double distance = Math.abs(freq - freg);

        if (distance < nearestLoss) {
          nearestLoss = loss;
        } else if (distance == nearestLoss) {
          nearestLoss = (nearestLoss + loss) / 2.0;
        }
      }
    }

    return nearestLoss;
  }
}

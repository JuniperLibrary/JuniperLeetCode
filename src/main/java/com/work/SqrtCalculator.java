package com.work;

import java.math.*;
import java.util.*;

public class SqrtCalculator {

  // 计算列表中所有数字的和的开方（x^(1/n)），并返回结果
  public static BigDecimal sqrt(List<BigDecimal> list, int constant, int scale) {
    if (constant == 0) {
      throw new IllegalArgumentException("开方指数不能为 0");
    }
    // 求和
    BigDecimal sum = BigDecimal.ZERO;
    for (BigDecimal number : list) {
      sum = sum.add(number);
    }

    // 创建 MathContext 对象，指定精度（即保留的小数位数）
    MathContext mathContext = new MathContext(scale);

    // 计算开方：sum^(1/n) 即是求 n 次方根
    double resultDouble = Math.pow(sum.doubleValue(), 1.0 / constant); // 使用 Math.pow 来计算 1/n 次方
    BigDecimal result = new BigDecimal(resultDouble, mathContext); // 根据精度构造 BigDecimal

    return result;
  }

  public static void main(String[] args) {
    // 创建 BigDecimal 列表
    List<BigDecimal> list = new ArrayList<>();
    list.add(new BigDecimal("25"));
    list.add(new BigDecimal("49"));
    list.add(new BigDecimal("100"));

    // 计算和的平方根（n=2），保留 2 位小数
    BigDecimal sqrtResult = sqrt(list, 2, 2);
    System.out.println("和的平方根是: " + sqrtResult);

    // 计算和的立方根（n=3），保留 2 位小数
    BigDecimal cubeRootResult = sqrt(list, 3, 2);
    System.out.println("和的立方根是: " + cubeRootResult);
  }
}

package com.work.indicator;

import java.math.*;
import java.util.*;

public class IndicatorCalculatorUtil {

  public static BigDecimal add(BigDecimal a, BigDecimal b) {
    if (a == null || b == null) {
      return null;
    }
    return a.add(b);
  }

  public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
    if (a == null || b == null) {
      return null;
    }
    return a.subtract(b);
  }

  public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
    if (a == null || b == null) {
      return null;
    }
    return a.multiply(b);
  }

  public static BigDecimal divide(BigDecimal a, BigDecimal b) {
    if (a == null || b == null) {
      return null;
    }
    return a.divideToIntegralValue(b);
  }

  public static BigDecimal mod(BigDecimal a, BigDecimal b, int scale) {
    if (a == null || b == null) {
      return null;
    }
    return a.divide(b, scale, RoundingMode.HALF_UP);
  }

  public static BigDecimal pow(BigDecimal base, BigDecimal exponent, int scale) {
    // 检查特殊情况
    if (base.compareTo(BigDecimal.ZERO) < 0 && exponent.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0) {
      throw new IllegalArgumentException("Negative base with a non-integer exponent is not supported");
    }
    if (base.compareTo(BigDecimal.ZERO) == 0) {
      if (exponent.compareTo(BigDecimal.ZERO) > 0) {
        return BigDecimal.ZERO;
      } else {
        throw new ArithmeticException("Zero base with a non-positive exponent is undefined");
      }
    }

    // 转换为对数计算：base^exponent = exp(exponent * ln(base))
    MathContext mc = new MathContext(scale + 5, RoundingMode.HALF_UP); // 提高精度以减少误差
    double baseDouble = base.doubleValue();
    double exponentDouble = exponent.doubleValue();

    // 使用 Math.log 和 Math.pow 计算
    double result = Math.pow(baseDouble, exponentDouble);

    // 转回 BigDecimal 并设置精度
    return new BigDecimal(result, mc).setScale(scale, RoundingMode.HALF_UP);
  }

  public static BigDecimal avg(List<BigDecimal> list, int scale) {
    if (list.isEmpty()) {
      return null;
    }
    return list.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(list.size()), scale, RoundingMode.HALF_UP);
  }


  public static BigDecimal variance(List<BigDecimal> list, int scale) {
    BigDecimal mean = avg(list, scale);
    BigDecimal variance = BigDecimal.ZERO;
    for (BigDecimal num : list) {
      BigDecimal diff = num.subtract(mean);
      variance = variance.add(diff.pow(2));
    }
    return variance.divide(BigDecimal.valueOf(list.size()), scale, RoundingMode.HALF_UP);
  }
}

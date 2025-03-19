package com.work;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueExtractor {

  /**
   * 从输入字符串中提取 price 值
   *
   * @param input 格式示例: [MdEntry(...price=122.4245...)]
   * @return BigDecimal类型的price值，若不存在或为null则返回null
   */
  public static BigDecimal extractPrice(String input) {
    return extractValue(input, "price");
  }

  /**
   * 从输入字符串中提取 yield 值
   *
   * @param input 格式示例: [MdEntry(...yield=3.1228...)]
   * @return BigDecimal类型的yield值，若不存在或为null则返回null
   */
  public static BigDecimal extractYield(String input) {
    return extractValue(input, "yield");
  }

  /**
   * 通用值提取方法
   *
   * @param input 输入字符串
   * @param key   要提取的键名（如"price"或"yield"）
   */
  private static BigDecimal extractValue(String input, String key) {
    // 处理输入边界条件
    if (input == null || input.isEmpty()) {
      return null;
    }

    // 1. 提取括号内的内容（移除外层[MdEntry(...)]）
    String content = input.replaceAll(".*?\\((.*)\\).*", "$1");

    // 2. 构造正则表达式，匹配键值对（支持空格和null）
    String regex = key + "\\s*=\\s*(-?\\d+\\.?\\d*|null)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(content);

    // 3. 查找匹配项
    if (matcher.find()) {
      String valueStr = matcher.group(1).trim();
      if ("null".equalsIgnoreCase(valueStr)) {
        return null;
      }
      try {
        return new BigDecimal(valueStr);
      } catch (NumberFormatException e) {
        System.err.println("数值格式错误: " + valueStr);
        return null;
      }
    }

    return null; // 未找到匹配项
  }

  public static void main(String[] args) {
    String input = "[MdEntry(size=900000000, totalSize=null, price=122.4245, " +
        "quotePrcType=null, provider=100008, providerName=招商银行, " +
        "quoteId=250306020410000042, quoteTime=2025-03-06T01:04:11.998Z, " +
        "settleType=T1, realTimeTakeOver=null, yield=3.1228, " +
        "clearMethod=FULL, deliveryType=DVP, dataSource=FIESP, " +
        "sourceTime=2025-03-06T01:04:11.998Z, orgPriceLevel=1)]";

    BigDecimal price = extractPrice(input);
    BigDecimal yield = extractYield(input);

    System.out.println("提取结果:");
    System.out.println("price = " + price); // 输出: 122.4245
    System.out.println("yield = " + yield); // 输出: 3.1228
  }
}

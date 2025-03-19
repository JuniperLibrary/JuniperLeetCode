package com.work;

import com.fasterxml.jackson.databind.*;
import java.util.*;

public class MdEntryParser {
  public static void main(String[] args) throws Exception {
    String data = "[MdEntry(size=30000000, totalSize=null, price=108.6737, quotePrcType=null, " +
        "provider=100066, providerName=国泰君安证券, quoteId=250304020410017621, " +
        "quoteTime=2025-03-04T08:14:35.658Z, settleType=T1, realTimeTakeOver=null, " +
        "yield=1.9244, clearMethod=FULL, deliveryType=DVP, dataSource=FIESP, " +
        "sourceTime=2025-03-04T08:14:35.658Z, orgPriceLevel=1)]";

    String json = convertToJson(data);
    System.out.println("转换后的 JSON：\n" + json);

    // 解析 JSON
    ObjectMapper objectMapper = new ObjectMapper();
    MdEntry entry = objectMapper.readValue(json, MdEntry.class);
    System.out.println("解析后的 Java 对象：\n" + entry);
  }

  public static String convertToJson(String data) {
    data = data.replace("[MdEntry(", "").replace(")]", ""); // 去掉外层
    String[] pairs = data.split(", ");

    Map<String, String> jsonMap = new HashMap<>();
    for (String pair : pairs) {
      String[] keyValue = pair.split("=", 2);
      String key = keyValue[0];
      String value = keyValue[1].trim();

      // 处理 null、数字、字符串
      if ("null".equals(value)) {
        jsonMap.put(key, "null");
      } else if (value.matches("^[0-9.]+$")) {
        jsonMap.put(key, value);
      } else {
        jsonMap.put(key, "\"" + value + "\"");
      }
    }

    // 转换为 JSON 格式字符串
    StringBuilder jsonBuilder = new StringBuilder("{");
    for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
      jsonBuilder.append("\"").append(entry.getKey()).append("\":").append(entry.getValue()).append(",");
    }
    jsonBuilder.deleteCharAt(jsonBuilder.length() - 1).append("}");

    return jsonBuilder.toString();
  }
}

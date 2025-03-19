package com.work;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;


public class StringToJson {
  public static void main(String[] args) throws Exception {
    String input = "[MdEntry(size=900000000, totalSize=null, price=122.4293, quotePrcType=null, " +
        "provider=100008, providerName=招商银行, quoteId=250305020410000059, " +
        "quoteTime=2025-03-05T01:02:06.837Z, settleType=T0, realTimeTakeOver=null, " +
        "yield=3.1228, clearMethod=FULL, deliveryType=DVP, dataSource=FIESP, " +
        "sourceTime=2025-03-05T01:02:06.837Z, orgPriceLevel=1)]";

    // 去除外部的 [MdEntry( )]
    input = input.replaceAll("^\\[MdEntry\\(|\\)]$", "");

    // 解析 key-value
    Map<String, Object> jsonMap = new LinkedHashMap<>();
    for (String pair : input.split(", ")) {
      String[] keyValue = pair.split("=", 2);
      String key = keyValue[0].trim();
      String value = keyValue.length > 1 ? keyValue[1].trim() : "null";

      if ("null".equals(value)) {
        jsonMap.put(key, null);
      } else if (value.matches("^-?\\d+(\\.\\d+)?$")) {
        jsonMap.put(key, value.contains(".") ? Double.parseDouble(value) : Long.parseLong(value));
      } else {
        jsonMap.put(key, value);
      }
    }

    // 创建 ObjectMapper
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    // 转 JSON
    String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
    System.out.println(jsonOutput);

    // JSON 反序列化为 MdEntry 对象
    MdEntry mdEntry = objectMapper.readValue(jsonOutput, MdEntry.class);

    // 输出对象
    System.out.println("MdEntry对象:"+mdEntry);
  }
}




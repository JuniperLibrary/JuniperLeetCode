package com.work.indicator;

import static cn.hutool.core.date.DateUtil.parseDate;

import cn.hutool.json.*;
import java.math.*;
import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class AddPreValueTest {

  public static void main(String[] args) {
    // 创建一个示例数据Map，日期作为Key，数据列表作为Value
    Map<Date, List<BigDecimal>> dataMap = new TreeMap<>();

    // 添加一些示例数据
    dataMap.put(parseDate("2023-01-01"), Collections.singletonList(BigDecimal.valueOf(10)));
    dataMap.put(parseDate("2023-01-02"), Collections.singletonList(null));  // 数据缺失
    dataMap.put(parseDate("2023-01-03"), Collections.singletonList(BigDecimal.valueOf(15)));
    dataMap.put(parseDate("2023-01-04"), Collections.singletonList(null));  // 数据缺失
    dataMap.put(parseDate("2023-01-05"), Collections.singletonList(null));  // 数据缺失
    dataMap.put(parseDate("2023-01-06"), Collections.singletonList(BigDecimal.valueOf(20)));

    // 创建结果列表，用于存储处理结果
    List<IndicatorHistoryDataResponseVO> result = new ArrayList<>();

    // 调用处理函数
    processSampleData(result, dataMap, 1, SampleTypeEnum.ADD_PRE_VALUE);

    // 打印处理后的数据
    for (IndicatorHistoryDataResponseVO vo : result) {
      System.out.println("Date: " + vo.getDate() + " Value: " + vo.getValue());
    }
  }

  // 处理数据的方法，模拟ADD_PRE_VALUE的逻辑
  private static void processSampleData(List<IndicatorHistoryDataResponseVO> result,
      Map<Date, List<BigDecimal>> dataMap,
      Integer observationCount,
      SampleTypeEnum sampleType) {
    List<Date> dateList = new ArrayList<>(dataMap.keySet());

    if (SampleTypeEnum.ADD_PRE_VALUE.equals(sampleType)) {
      BigDecimal lastValidValue = null;
      for (int i = 0; i < dateList.size(); i++) {
        Date currentDate = dateList.get(i);
        List<BigDecimal> currentData = dataMap.get(currentDate);

        if (currentData != null && !currentData.isEmpty() && currentData.get(0) != null) {
          // 如果当前日期的数据不为空，更新 lastValidValue
          lastValidValue = currentData.get(0); // 假设每个日期只有一个数据
        } else {
          // 如果当前数据为空，填充前一个有效的值
          if (lastValidValue != null) {
            List<BigDecimal> filledData = new ArrayList<>();
            filledData.add(lastValidValue);
            dataMap.put(currentDate, filledData);
          }
        }


      }
    }

    log.info(JSONUtil.toJsonStr(dataMap));
  }
}

package com.work.ohlc;

import cn.hutool.json.*;
import java.time.*;
import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class IntervalSessionLIst {

  public static List<TradeSectionTimeFrame> generateTradeTimeFrames(
      List<Map<String, Object>> rawTimeSlots, LocalDate currentTradeDate, ZoneId zoneId) {

    List<TradeSectionTimeFrame> result = new ArrayList<>();

    for (Map<String, Object> slot : rawTimeSlots) {
      int shift = ((Number) slot.get("shift")).intValue();
      String beginTimeStr = (String) slot.get("beginTime");
      String endTimeStr = (String) slot.get("endTime");

      // 处理起始日期
      LocalDate beginDate = currentTradeDate.plusDays(shift);
      LocalDate endDate = beginDate;
      LocalTime beginTime = LocalTime.parse(beginTimeStr);
      LocalTime endTime = LocalTime.parse(endTimeStr);

      // 如果结束时间小于开始时间，说明跨天，需要加一天
      if (endTime.isBefore(beginTime)) {
        endDate = endDate.plusDays(1);
      }

      // 拼接为 ZonedDateTime -> Instant
      Instant beginInstant = ZonedDateTime.of(beginDate, beginTime, zoneId).toInstant();
      Instant endInstant = ZonedDateTime.of(endDate, endTime, zoneId).toInstant();

      TradeSectionTimeFrame frame = new TradeSectionTimeFrame();
      frame.setBeginTime(beginInstant);
      frame.setEndTime(endInstant);
      result.add(frame);
    }

    return result;
  }

  public static void main(String[] args) {
    List<Map<String, Object>> rawSlots = new ArrayList<>();
    rawSlots.add(Map.of("shift", -1, "beginTime", "20:00:00", "endTime", "02:30:00"));
    rawSlots.add(Map.of("shift", 0, "beginTime", "09:00:00", "endTime", "15:29:59"));

    LocalDate tradeDate = LocalDate.of(2025, 5, 17);
    ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    List<TradeSectionTimeFrame> frames = generateTradeTimeFrames(rawSlots, tradeDate, zoneId);
    log.info(JSONUtil.toJsonStr(frames));
  }
}

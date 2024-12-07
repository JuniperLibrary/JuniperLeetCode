package com.dingchuan;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * 要求设计一个日志系统，每个日志有一个时间戳和id，时间戳的格式为Year:Month:Day:Hour:Minute:Second，
 * <p>
 * 每个项长度为4 , 2 , 2 , 2 , 2 , 2 4,2,2,2,2,24,2,2,2,2,2。
 * <p>
 * 要求可以做如下操作： 1、加入一个日志；
 * <p>
 * 2、给定一个时间段[s,e] [s,e][s,e]，以时间戳形式给出，再给定一个精细度，精细度是"Year", ..., "Second"之一，
 * <p>
 * 其含义是查询的精度，即，以"Month"为例，那么查询的时候，只查询同一年的两个月之间的所有日志，忽略日、时、分、秒的分界线。
 * <p>
 * 返回所有范围内的日志的id。
 */
@Slf4j
public class DesignLogStorageSystem {

  private List<LogEntry> logs;

  private static class LogEntry {

    int id;
    String timestamp;

    public LogEntry(int id, String timestamp) {
      this.id = id;
      this.timestamp = timestamp;
    }
  }

  public DesignLogStorageSystem() {
    logs = new ArrayList<>();
  }

  /**
   * This function takes a log entry's unique ID and its timestamp, then stores it in the system.
   *
   * @param id
   * @param timestamp
   */
  public void put(int id, String timestamp) {
    logs.add(new LogEntry(id, timestamp));
  }

  /**
   * his method returns the list of log IDs that have timestamps within the inclusive range
   * specified by start and end.
   * <p>
   * The granularity parameter determines how precise the time range should be, ranging from the
   * year down to the second.
   * <p>
   * The granularity truncates the timestamp to the specified level of detail, and only that level
   * of detail is considered when filtering logs.
   *
   * @param start
   * @param end
   * @param granularity
   * @return
   */
  public List<Integer> retrieve(String start, String end, String granularity) {
    List<Integer> result = new ArrayList<>();
    String truncatedStart = truncate(start, granularity);
    String truncatedEnd = truncate(end, granularity);

    // 遍历所有日志记录，根据粒度和时间范围筛选日志
    for (LogEntry log : logs) {
      String truncatedTimestamp = truncate(log.timestamp, granularity);
      if (truncatedTimestamp.compareTo(truncatedStart) >= 0 && truncatedTimestamp.compareTo(truncatedEnd) <= 0) {
        result.add(log.id);
      }
    }

    return result;
  }

  private String truncate(String timestamp, String granularity) {
    switch (granularity) {
      case "Year":
        return timestamp.substring(0, 4); // 截取年
      case "Month":
        return timestamp.substring(0, 7); // 截取年-月
      case "Day":
        return timestamp.substring(0, 10); // 截取年-月-日
      case "Hour":
        return timestamp.substring(0, 13); // 截取年-月-日-小时
      case "Minute":
        return timestamp.substring(0, 16); // 截取年-月-日-小时-分钟
      case "Second":
        return timestamp;
      default:
        throw new IllegalArgumentException("Invalid granularity");
    }
  }

  public static void main(String[] args) {
    DesignLogStorageSystem logSystem = new DesignLogStorageSystem();

    // 插入日志记录
    logSystem.put(1, "2017:01:01:23:59:59");
    logSystem.put(2, "2017:01:01:22:59:59");
    logSystem.put(3, "2016:01:01:00:00:00");

    // 查询范围为 2016:01:01 到 2017:01:01，粒度为 "Year"
    List<Integer> result1 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
    log.info("result:{}", result1);

    // 查询范围为 2016:01:01 到 2017:01:01，粒度为 "Hour"
    List<Integer> result2 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
    log.info("result2:{}", result2);
  }
}

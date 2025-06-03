//package com.work.ohlc;
//
//import cn.hutool.core.collection.*;
//import cn.hutool.core.date.*;
//import com.work.*;
//import java.text.*;
//import java.util.*;
//import java.util.Map.*;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.*;
//import java.util.stream.*;
//import lombok.*;
//import lombok.extern.slf4j.*;
//
//
//@Slf4j
//@RequiredArgsConstructor
//public class TradeCalendarCache implements ITradeCalendarCache {
//
//  private final AtomicBoolean available = new AtomicBoolean(false);
//
//  /**
//   * 当天
//   */
//  private static final int TODAY = 0;
//
//  private final ITradeVenueCache tradeVenueCache;
//
//  /**
//   * key:交易日历名称 value:交易日历详情信息集合
//   */
//  public Map<String, List<TradeCalendarDetail>> calendarNameCalendarsMap = new ConcurrentHashMap<>();
//
//  /**
//   * key:交易日历ID value:交易日历详情信息集合
//   */
//  private Map<Integer, TradeCalendar> tradeCalendarMap = new ConcurrentHashMap<>();
//
//  public TradeCalendarCache() {
//
//  }
//
//  @Override
//  public TradeCalendar getTradeCalendar(Integer calendarId) {
//    if (!available.get()) {
//      log.warn("getTradeCalendar failed! tradeCalendarCache loading data is abnormal...");
//      return null;
//    }
//    return tradeCalendarMap.get(calendarId);
//  }
//
//  @Override
//  public List<TradeCalendarDetail> getTradeCalendarDetailList(String name) {
//    if (!available.get()) {
//      log.warn(
//          "getTradeCalendarDetailList(name) failed! tradeCalendarCache loading data is abnormal...");
//      return Collections.emptyList();
//    }
//    return calendarNameCalendarsMap.get(name);
//  }
//
//  /**
//   * 获取交易日详情列表
//   *
//   * @param name 交易日历名称
//   * @param year 年份
//   * @return 交易日历详情列表
//   */
//  public List<TradeCalendarDetail> getTradeCalendarDetailList(String name, Integer year) {
//    if (!available.get()) {
//      log.warn(
//          "getTradeCalendarDetailList(name, year) failed! tradeCalendarCache loading data is abnormal...");
//      return Collections.emptyList();
//    }
//    List<TradeCalendarDetail> calendarList = calendarNameCalendarsMap.get(name);
//    if (CollUtil.isEmpty(calendarList)) {
//      log.warn("calendarList is empty, name={}, year={}", name, year);
//      return Collections.emptyList();
//    }
//    return calendarList.stream()
//        .filter(calendar -> DateUtil.year(calendar.getTradeDate()) == year)
//        .collect(Collectors.toList());
//  }
//
//  /**
//   * 获取交易日历详情
//   *
//   * @param name 交易日历名称
//   * @param date 日期
//   * @return 交易日历详情
//   */
//  public TradeCalendarDetail getTradeCalendarDetail(String name, Date date) {
//    if (!available.get()) {
//      log.warn(
//          "getTradeCalendarDetail(name, date) failed! tradeCalendarCache loading data is abnormal...");
//      return null;
//    }
//    List<TradeCalendarDetail> calendarList = calendarNameCalendarsMap.get(name);
//    if (CollUtil.isEmpty(calendarList)) {
//      log.warn("calendarList is empty, name={}, date={}", name, date);
//      return null;
//    }
//    calendarList = calendarList.stream()
//        .filter(calendar -> DateUtil.isSameDay(calendar.getTradeDate(), date))
//        .collect(Collectors.toList());
//    if (CollUtil.isEmpty(calendarList)) {
//      log.debug("tradeCalendarDetail not fount, name={}, date={}", name, date);
//      return null;
//    }
//    return calendarList.get(0);
//  }
//
//  /**
//   * 是否交易日
//   * @param name 交易日历名称
//   * @param date 日期
//   * @return 是否交易日
//   */
//  public Boolean isTradingDay(String name, Date date) {
//    return this.getTradeCalendarDetail(name, date) != null;
//  }
//
//  /**
//   * 获取交易日历详情
//   *
//   * @param tradeVenueCode 交易场所代码
//   * @param date           日期
//   * @return 交易日历详情
//   */
//  @Override
//  public TradeCalendarDetail getTradeCalendarDetail(TradeVenueCode tradeVenueCode, Date date) {
//    if (!available.get()) {
//      log.warn(
//          "getTradeCalendarDetail(tradeVenueCode, date) failed! tradeCalendarCache loading data is abnormal...");
//      return null;
//    }
//    TradeVenue tradeVenue = tradeVenueCache.getTradeVenue(tradeVenueCode);
//    if (tradeVenue == null) {
//      log.warn("tradeVenue is null, tradeVenueCode={}, date={}", tradeVenueCode, date);
//      return null;
//    }
//    return getTradingCalendar(tradeVenueCode, date, TODAY);
//  }
//
//  /**
//   * 获取交易日
//   *
//   * @param tradeVenueCode 交易场所
//   * @param date           当前时间
//   * @param days           往前往后的天数,正数表示往后，负数往前，0当前是否是交易日
//   * @return 交易日
//   */
//  @Override
//  public Date getTradeDate(TradeVenueCode tradeVenueCode, Date date, int days) {
//    if (!available.get()) {
//      log.warn("getTradeDate failed! tradeCalendarCache loading data is abnormal...");
//      return null;
//    }
//    TradeCalendarDetail tradeCalendarDetail = getTradingCalendar(tradeVenueCode, date, days);
//    if (tradeCalendarDetail == null) {
//      log.warn("tradeCalendarDetail is null, tradeVenueCode={}, date={}, days={}",
//          tradeVenueCode, date, days);
//      return null;
//    }
//    return tradeCalendarDetail.getTradeDate();
//  }
//
//  @Override
//  public Date getTradeDate(TradeVenueCode venueCode, Date date, SettleType settleType) {
//    int days = 0;
//    switch (settleType) {
//      case T1:
//        days = 1;
//        break;
//      case T2:
//        days = 2;
//        break;
//      case T3:
//        days = 3;
//        break;
//      case T4:
//        days = 4;
//        break;
//      default:
//        break;
//    }
//    return getTradeDate(venueCode, date, days);
//  }
//
//  @Override
//  public Date getPreTradingDay(Date date) {
//    List<TradeCalendarDetail> calendarList = this.calendarNameCalendarsMap
//        .getOrDefault(TradeVenueCode.XBOND, new ArrayList<>());
//    Date preDate = SystemTime.now();
//    if (CollUtil.isNotEmpty(calendarList)) {
//      preDate = calendarList.get(0).getTradeDate();
//      for (TradeCalendarDetail calendar : calendarList) {
//        if (date.compareTo(calendar.getTradeDate()) <= 0) {
//          return preDate;
//        } else {
//          preDate = calendar.getTradeDate();
//        }
//      }
//    } else {
//      log.warn("TradingCalendarStorage.latestVenueCodeCalendarsMap is empty");
//    }
//    return preDate;
//  }
//
//  /**
//   * 获取T+N日或者T-N日
//   *
//   * @param tradeVenueCode 交易场所
//   * @param date           当前时间
//   * @param days           往前往后的天数,正数表示往后，负数往前，0当前交易日
//   * @return 交易日历详情
//   */
//  public TradeCalendarDetail getTradingCalendar(TradeVenueCode tradeVenueCode, Date date, int days) {
//    TradeVenue tradeVenue = tradeVenueCache.getTradeVenue(tradeVenueCode);
//    if (tradeVenue == null) {
//      log.warn("tradeVenue is null, tradeVenueCode={}, date={}, days={}", tradeVenueCode, date, days);
//      return null;
//    }
//    String calendarName = tradeCalendarMap.get(tradeVenue.getCalendarId()).getName();
//    List<TradeCalendarDetail> calendarList = calendarNameCalendarsMap.get(calendarName);
//    if (CollUtil.isEmpty(calendarList)) {
//      return null;
//    }
//    List<Date> dateList = calendarList.stream()
//        .map(TradeCalendarDetail::getTradeDate)
//        .collect(Collectors.toList());
//    int index = indexedBinarySearch(dateList, DateUtil.beginOfDay(date), days);
//    if (index >= 0 && index <= (dateList.size() - 1)) {
//      return calendarList.get(index);
//    }
//    log.warn("未找到对应的交易日信息, tradeVenueCode={}, date={}, days={}", tradeVenueCode, date, days);
//    return null;
//  }
//
///*  public static void main(String[] args) {
//    List<TradeCalendarDetail> tradeCalendarDetailList = new ArrayList<>();
//
//    TradeCalendarDetail tradeCalendarDetail = new TradeCalendarDetail();
//    tradeCalendarDetail.setId(1);
//    tradeCalendarDetail.setCalendarId(1);
//    tradeCalendarDetail.setTradeDate(java.sql.Date.valueOf("2024-12-29"));
//    tradeCalendarDetail.setNightTrade(false);
//
//
////    TradeCalendarDetail tradeCalendarDetail = new TradeCalendarDetail();
////    tradeCalendarDetail.setId(1);
////    tradeCalendarDetail.setCalendarId(1);
////    tradeCalendarDetail.setTradeDate(java.sql.Date.valueOf("2024-12-29"));
////    tradeCalendarDetail.setNightTrade(false);
////
////
////
////
////
////    TradeCalendarDetail tradeCalendarDetail = new TradeCalendarDetail();
////    tradeCalendarDetail.setId(1);
////    tradeCalendarDetail.setCalendarId(1);
////    tradeCalendarDetail.setTradeDate(java.sql.Date.valueOf("2024-12-29"));
////    tradeCalendarDetail.setNightTrade(false);
//
//    TradeCalendarDetail tradeCalendarDetail2 = new TradeCalendarDetail();
//    tradeCalendarDetail2.setId(1);
//    tradeCalendarDetail2.setCalendarId(1);
//    tradeCalendarDetail2.setTradeDate(java.sql.Date.valueOf("2024-12-30"));
//    tradeCalendarDetail2.setNightTrade(false);
//
//
//    TradeCalendarDetail tradeCalendarDetail3 = new TradeCalendarDetail();
//    tradeCalendarDetail3.setId(1);
//    tradeCalendarDetail3.setCalendarId(1);
//    tradeCalendarDetail3.setTradeDate(java.sql.Date.valueOf("2024-12-31"));
//    tradeCalendarDetail3.setNightTrade(false);
//
//    tradeCalendarDetailList.add(tradeCalendarDetail);
//    tradeCalendarDetailList.add(tradeCalendarDetail2);
//    tradeCalendarDetailList.add(tradeCalendarDetail3);
//
//    String dateStr = "2025-05-10";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    Date date = sdf.parse(dateStr);
//
//    indexedBinarySearch(tradeCalendarDetailList,DateUtil.beginOfDay(Da))
//
//
//  }*/
//
//  /**
//   * 二分法查找目标下标
//   *
//   * @param list  顺序递增的集合
//   * @param key   查找对象
//   * @param shift 偏移值
//   * @return 目标下标
//   */
//  public static  <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key, int shift) {
//    int shiftTemp = shift;
//    int index = Collections.binarySearch(list, key);
//    //查询到的下标为负，说明对应目标不在列表里
//    //需对目标不在列表里的情况支持向上或向下偏移
//    //处理偏移值
//    if (index < 0) {
//      if (shift > 0) {
//        shiftTemp = shiftTemp - 2;
//      } else if (shift < 0) {
//        shiftTemp = shiftTemp - 1;
//      } else {
//        //偏移值为0,则不需要向上或向下再次查找
//        return index;
//      }
//    }
//    index = Math.abs(index) + shiftTemp;
//    return index;
//  }
//
//  @Override
//  public void loadData(List<TradeCalendar> tradeCalendarList, List<TradeCalendarDetail> tradeCalendarDetailList) {
//    available.set(false);
//
//    Map<Integer, TradeCalendar> tradeCalendarMapTmp = this.tradeCalendarMap;
//    Map<Integer, TradeCalendar> tradeCalendarMapNew = new ConcurrentHashMap<>();
//    Map<String, List<TradeCalendarDetail>> calendarNameCalendarsMapTmp = this.calendarNameCalendarsMap;
//    Map<String, List<TradeCalendarDetail>> calendarNameCalendarsMapNew = new ConcurrentHashMap<>();
//
//    for (TradeCalendar tradeCalendar : tradeCalendarList) {
//      tradeCalendarMapNew.put(tradeCalendar.getId(), tradeCalendar);
//      List<TradeCalendarDetail> tradeCalendarDetails = new ArrayList<>();
//      for (TradeCalendarDetail tradeCalendarDetail : tradeCalendarDetailList) {
//        if (tradeCalendarDetail.getCalendarId().equals(tradeCalendar.getId())) {
//          tradeCalendarDetails.add(tradeCalendarDetail);
//        }
//      }
//      //按照交易日排序
//      tradeCalendarDetails = tradeCalendarDetails.stream()
//          .sorted(Comparator.comparing(TradeCalendarDetail::getTradeDate))
//          .collect(Collectors.toList());
//      calendarNameCalendarsMapNew.put(tradeCalendar.getName(), tradeCalendarDetails);
//    }
////    log.info("loadData tradeCalendarMapNew={}", JSON.toJSONString(tradeCalendarMapNew));
//
//    synchronized (this) {
//      this.tradeCalendarMap = tradeCalendarMapNew;
//      this.calendarNameCalendarsMap = calendarNameCalendarsMapNew;
//      tradeCalendarMapTmp.clear();
//      calendarNameCalendarsMapTmp.clear();
//    }
//
//    available.set(true);
//    //打印日志
//    Set<Entry<String, List<TradeCalendarDetail>>> entries = calendarNameCalendarsMap.entrySet();
//    StringBuilder tradeCalendarDetailLog = new StringBuilder("交易日历解析条数:");
//    for (Entry<String, List<TradeCalendarDetail>> entry : entries) {
//      tradeCalendarDetailLog.append(entry.getKey()).append(":")
//          .append(entry.getValue().size()).append("条; ");
//    }
//    log.info(tradeCalendarDetailLog.toString());
//    log.info("解析 交易日历元数据 并存入内存 成功 交易日历({})  交易日历详情({})", tradeCalendarList.size(), tradeCalendarDetailList.size());
//  }
//
//  @Override
//  public Map<Integer, TradeCalendar> getTradeCalendarMap() {
//    return this.tradeCalendarMap;
//  }
//
//  @Override
//  public Map<String, List<TradeCalendarDetail>> getCalendarNameCalendarsMap() {
//    return this.calendarNameCalendarsMap;
//  }
//}

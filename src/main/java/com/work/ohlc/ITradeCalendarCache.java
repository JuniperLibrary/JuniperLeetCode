package com.work.ohlc;


import com.work.*;
import java.util.*;

/**
 * @Author: rainbow
 * @Date: 2022/8/23
 * @Desc: 交易日历缓存接口
 */
public interface ITradeCalendarCache {

  /**
   * 获取交易日历信息
   *
   * @param calendarId 交易日历ID
   * @return 交易日历信息
   */
  TradeCalendar getTradeCalendar(Integer calendarId);

  /**
   * 获取交易日详情列表
   *
   * @param name 交易日历名称
   * @return 交易日历详情列表
   */
  List<TradeCalendarDetail> getTradeCalendarDetailList(String name);

  /**
   * 获取交易日详情列表
   *
   * @param name 交易日历名称
   * @param year 年份
   * @return 交易日历详情列表
   */
  List<TradeCalendarDetail> getTradeCalendarDetailList(String name, Integer year);

  /**
   * 获取交易日历详情
   *
   * @param name 交易日历名称
   * @param date 日期
   * @return 交易日历详情
   */
  TradeCalendarDetail getTradeCalendarDetail(String name, Date date);

  /**
   * 是否交易日
   * @param name 交易日历名称
   * @param date 日期
   * @return 是否交易日
   */
  Boolean isTradingDay(String name, Date date);

  /**
   * 获取交易日历详情
   *
   * @param tradeVenueCode 交易场所代码
   * @param date           日期
   * @return 交易日历详情
   */
  TradeCalendarDetail getTradeCalendarDetail(TradeVenueCode tradeVenueCode, Date date);

  /**
   * 获取交易日
   *
   * @param tradeVenueCode 交易场所
   * @param date           当前时间
   * @param days           往前往后的天数,正数表示往后，负数往前，0当前是否是交易日
   * @return 交易日
   */
  Date getTradeDate(TradeVenueCode tradeVenueCode, Date date, int days);

  /**
   * 获取SettleType对应的交易日
   *
   * @param venueCode  交易场所
   * @param date       当前时间
   * @param settleType 清算速度
   * @return 交易日
   */
  Date getTradeDate(TradeVenueCode venueCode, Date date, SettleType settleType);

  /**
   * 获取前一个交易日
   *
   * @param date 当前时间
   * @return 前一个交易日
   */
  Date getPreTradingDay(Date date);

  /**
   * 加载交易日历信息到内存
   *
   * @param tradeCalendarList       交易日历信息集合
   * @param tradeCalendarDetailList 交易日历详情集合
   */
  void loadData(List<TradeCalendar> tradeCalendarList,
      List<TradeCalendarDetail> tradeCalendarDetailList);

  /**
   * 获取所有交易日历内存信息
   *
   * @return 交易日历内存信息
   */
  Map<Integer, TradeCalendar> getTradeCalendarMap();

  /**
   * 获取所有交易日历详情内存信息
   *
   * @return 交易日历详情内存信息
   */
  Map<String, List<TradeCalendarDetail>> getCalendarNameCalendarsMap();
}

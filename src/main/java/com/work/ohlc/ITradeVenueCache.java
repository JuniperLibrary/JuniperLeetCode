package com.work.ohlc;


import java.util.*;

/**
 * @Author: rainbow
 * @Date: 2022/8/23
 * @Desc: 交易场所缓存接口
 */
public interface ITradeVenueCache {

  /**
   * 获取对应的交易场所信息
   * @param tradeVenueCode 交易场所代码
   * @return 交易场所信息
   */
  TradeVenue getTradeVenue(TradeVenueCode tradeVenueCode);

  /**
   * 加载交易场所信息到内存
   * @param tradeVenueList 交易场所集合
   */
  void loadData(List<TradeVenue> tradeVenueList);

  /**
   * 获取所有交易场所内存信息
   * @return 交易场所内存信息
   */
  Map<TradeVenueCode, TradeVenue> getTradeVenueCodeMap();

}

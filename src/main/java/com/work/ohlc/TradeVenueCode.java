package com.work.ohlc;

import java.util.*;

/**
 * 交易场所代码 generate with jinja2
 */
public enum TradeVenueCode {
  /**
   * X-Bond
   */
  XBOND,
  /**
   * 利率互换-Xswap
   */
  XSWAP,
  /**
   * 标债远期-Xswap
   */
  SBF,
  /**
   * 请求报价
   */
  FIRFQ,
  /**
   * 现券-对话报价
   */
  FIRFT,
  /**
   * 利率互换-对话报价
   */
  FIRFTSWAP,
  /**
   * 双边做市
   */
  FIESP,
  /**
   * 指示性报价
   */
  FIIND,
  /**
   * 中金所
   */
  CFFEX,
  /**
   * CFETS FX SPOT ODM
   */
  FXODM,
  /**
   * CFETS FX CSWAP
   */
  CSWAP,
  /**
   * CFETS FX RFQ
   */
  FXRFQ,
  /**
   * CFETS FX ESP
   */
  FXESP,
  /**
   * 金交所
   */
  SGE,
  /**
   * 上期所
   */
  SHFE,
  /**
   * FXALL
   */
  FXALL,
  /**
   * UBS
   */
  UBS,
  /**
   * QB 国利
   */
  TP,
  /**
   * QB 平安
   */
  PA,
  /**
   * QB 中诚
   */
  BGC,
  /**
   * QB 国际
   */
  ICAP,
  /**
   * QB 信唐
   */
  TJ,
  /**
   * 融合行情
   */
  AGG,
  /**
   * 银行间债券
   */
  IB,
  /**
   * 银行间利率互换
   */
  IBSWAP,
  /**
   * 标准债券远期(每日结算价)
   */
  SBFDP,
  /**
   * 匿名拍卖
   */
  AUCTION,
  /**
   * 中国外汇交易中心
   */
  CFETS,
  ;

  public static Map<TradeVenueCode, String> valueMap = new HashMap<>();
  static {
    valueMap.put(XBOND, "X-Bond");
    valueMap.put(XSWAP, "利率互换-Xswap");
    valueMap.put(SBF, "标债远期-Xswap");
    valueMap.put(FIRFQ, "请求报价");
    valueMap.put(FIRFT, "现券-对话报价");
    valueMap.put(FIRFTSWAP, "利率互换-对话报价");
    valueMap.put(FIESP, "双边做市");
    valueMap.put(FIIND, "指示性报价");
    valueMap.put(CFFEX, "中金所");
    valueMap.put(FXODM, "CFETS FX SPOT ODM");
    valueMap.put(CSWAP, "CFETS FX CSWAP");
    valueMap.put(FXRFQ, "CFETS FX RFQ");
    valueMap.put(FXESP, "CFETS FX ESP");
    valueMap.put(SGE, "金交所");
    valueMap.put(SHFE, "上期所");
    valueMap.put(FXALL, "FXALL");
    valueMap.put(UBS, "UBS");
    valueMap.put(TP, "QB 国利");
    valueMap.put(PA, "QB 平安");
    valueMap.put(BGC, "QB 中诚");
    valueMap.put(ICAP, "QB 国际");
    valueMap.put(TJ, "QB 信唐");
    valueMap.put(AGG, "融合行情");
    valueMap.put(IB, "银行间债券");
    valueMap.put(IBSWAP, "银行间利率互换");
    valueMap.put(SBFDP, "标准债券远期(每日结算价)");
    valueMap.put(AUCTION, "匿名拍卖");
    valueMap.put(CFETS, "中国外汇交易中心");
  }

  public static Map<TradeVenueCode, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(TradeVenueCode value) {
    return valueMap.get(value);
  }
}
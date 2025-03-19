package com.work;

import java.util.*;

/**
 * 报价方式 generate with jinja2
 */
public enum QuotePrcType {
  /**
   * outright
   */
  outright,
  /**
   * spread
   */
  spread,
  /**
   * basis
   */
  basis,
  /**
   * xbasis
   */
  xbasis,
  /**
   * butterfly
   */
  butterfly,
  /**
   * box
   */
  box,
  /**
   * ndd
   */
  ndd,
  /**
   * other
   */
  other,
  ;

  public static Map<QuotePrcType, String> valueMap = new HashMap<>();
  static {
    valueMap.put(outright, "outright");
    valueMap.put(spread, "spread");
    valueMap.put(basis, "basis");
    valueMap.put(xbasis, "xbasis");
    valueMap.put(butterfly, "butterfly");
    valueMap.put(box, "box");
    valueMap.put(ndd, "ndd");
    valueMap.put(other, "other");
  }

  public static Map<QuotePrcType, String> getValueMap() {
    return valueMap;
  }

  public static String getLabel(QuotePrcType value) {
    return valueMap.get(value);
  }
}
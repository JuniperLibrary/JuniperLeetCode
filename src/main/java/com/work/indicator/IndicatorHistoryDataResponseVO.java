package com.work.indicator;

import java.math.*;
import java.util.*;
import lombok.*;

@Data
public class IndicatorHistoryDataResponseVO {

  private Date date;
  private BigDecimal value;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }
}

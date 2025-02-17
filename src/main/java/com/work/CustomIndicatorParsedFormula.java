package com.work;

import com.work.indicator.*;
import lombok.*;

@Data
public class CustomIndicatorParsedFormula {

  private OperatorEnum operator;

  private String selectedIndicatorName;

  private String targetIndicatorName;

  private String priceType;

  private Integer constantValue;
}

package com.dingchuan;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TradeProcessor {


  // Use ConcurrentMap for thread safety
  private final ConcurrentMap<String, BigDecimal> codeWithPreVolume = new ConcurrentHashMap<>();

  public BigDecimal getLastTradeQty(String code, BigDecimal volume) {
    BigDecimal lastTradeQty = BigDecimal.ZERO;

    try {
      lastTradeQty = Stream.of(code)
          .parallel()
          .map(c -> {
            BigDecimal preVolume = codeWithPreVolume.getOrDefault(c, BigDecimal.ZERO);
            BigDecimal currentLastTradeQty =
                volume.compareTo(preVolume) >= 0 ? volume.subtract(preVolume) : BigDecimal.ZERO;

            codeWithPreVolume.put(c, volume);

            if (currentLastTradeQty.compareTo(BigDecimal.ZERO) > 0) {
              log.info("code is {}, lastTradeQty is {}", c, currentLastTradeQty);
            }
            return currentLastTradeQty;
          })
          .findFirst()
          .orElse(BigDecimal.ZERO);
    } catch (Exception e) {
      log.info("current mp volume is {}", volume);
      log.info("pre volume is {}", codeWithPreVolume.getOrDefault(code, BigDecimal.ZERO));
      log.warn(e.getMessage(), e);
    }
    return lastTradeQty;
  }

  public static void main(String[] args) {
    final int ITERATIONS = 10000;
    final long NUMBER = 3000000L;

    long totalSum = 0;
    long totalTime = 0;

    for (int i = 0; i < ITERATIONS; i++) {
      long startTime = System.nanoTime();
      long sum = calculate(NUMBER);
      long endTime = System.nanoTime();
      long duration = endTime - startTime;
      totalTime += duration;
      totalSum += sum;
    }

    long averageTime = totalTime / ITERATIONS;

    System.out.println("Total sum after " + ITERATIONS + " iterations: " + totalSum);
    System.out.println("Average time per iteration: " + averageTime + " nanoseconds");
  }

  private static long calculate(long number) {
    // 这里只是一个简单的示例操作，你可以根据你的需求修改这个方法
    long sum = 0;
    for (long i = 0; i <= number; i++) {
      sum += i;
    }
    return sum;
  }
}

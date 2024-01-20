package com.uin.day;

import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LC2788 {

  public static List<String> spiltWordsBySeparator(List<String> words, char separator) {
    List<String> str = new ArrayList<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      int len = word.length();
      for (int i = 0; i < len; i++) {
        char c = word.charAt(i);
        if (c == separator) {
          if (sb.length() > 0) {
            str.add(sb.toString());
            sb.setLength(0);
          }
        }else {
          sb.append(c);
        }
      }
      if (sb.length()>0){
        str.add(sb.toString());
      }
    }
    return str;
  }

    public static void main (String[]args){
      List<String> words = new ArrayList<>();
      words.add("one.two.three,four.five");
      words.add("six");
      log.info("res={}", JSONUtil.toJsonStr(spiltWordsBySeparator(words, '.')));
    }
  }

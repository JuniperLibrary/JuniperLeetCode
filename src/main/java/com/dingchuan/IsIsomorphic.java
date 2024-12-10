package com.dingchuan;

import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class IsIsomorphic {
  public boolean isIsomorphic(String s, String t) {
    if (s==null || t==null || s.length() != t.length()){
      return false;
    }
    Map<Character,Character> map  = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char a = s.charAt(i);
      char b = t.charAt(i);

      if (map.containsKey(a)){
        if (map.get(a) ==b){
          continue;
        }else {
          return false;
        }
      }else {
        if (map.containsValue(b)){
          return false;
        }else {
          map.put(a,b);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsIsomorphic isIsomorphic = new IsIsomorphic();
    String s = "foo";
    String t = "bar";
    log.info("isIsomorphic :{}",isIsomorphic.isIsomorphic(s, t));
  }
}

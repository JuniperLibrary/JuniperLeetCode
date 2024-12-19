package com.work;

import cn.hutool.core.collection.*;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.*;

@Slf4j
public class TestAssign {

  // 处理用户授权列表的逻辑
  public static String updateAuthUsers(String existingAuthUsers, List<Integer> userIds, boolean isDelete) {
    if (existingAuthUsers == null || existingAuthUsers.isEmpty()) {
      return "";
    }

    List<Integer> currentAuthUserIds = Arrays.stream(existingAuthUsers.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    if (CollUtil.isNotEmpty(userIds)) {
      if (isDelete) {
        // 删除场景：从现有用户中移除 userIds 中的用户
        currentAuthUserIds.removeAll(userIds);
      } else {
        // 新增场景：将 userIds 中的用户添加到现有用户中
        currentAuthUserIds.addAll(userIds);
      }

      // 移除重复的用户ID
      currentAuthUserIds = currentAuthUserIds.stream().distinct().collect(Collectors.toList());
    }

    return currentAuthUserIds.isEmpty() ? "" : currentAuthUserIds.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
  }

  public static void main(String[] args) {
    // 第一种场景：给 existingAuthUsers 新增 2,3
    String existingAuthUsers = "1";
    List<Integer> userIds = List.of(2, 3);
    log.info("join:{}", CollUtil.join(userIds, ","));
    String updatedAuthUsers = updateAuthUsers(existingAuthUsers, userIds, false);  // isDelete 为 false，执行添加操作
    log.info("编辑 updatedAuthUsers: {}", updatedAuthUsers);  // 输出: 1,2,3

    // 第二种场景：把 1,3 移除
    String existingAuthUsers2 = "1,2,3";
    List<Integer> userIds2 = List.of(1);
    String updatedAuthUsers2 = updateAuthUsers(existingAuthUsers2, userIds2, true);  // isDelete 为 true，执行删除操作
    log.info("删除 updatedAuthUsers: {}", updatedAuthUsers2);  // 输出: 1
  }
}


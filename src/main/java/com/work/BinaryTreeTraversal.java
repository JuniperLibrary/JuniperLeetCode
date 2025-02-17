package com.work;


import cn.hutool.json.*;
import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class BinaryTreeTraversal {

  public static List<CustomIndicatorInfo> postOrderCustomIndicator(CustomIndicatorInfo root) {
    List<CustomIndicatorInfo> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    // 先递归遍历左子节点
    if (root.getLeftNode() != null) {
      result.addAll(postOrderCustomIndicator(root.getLeftNode()));
    }

    // 然后递归遍历右子节点
    if (root.getRightNode() != null) {
      result.addAll(postOrderCustomIndicator(root.getRightNode()));
    }

//     最后访问当前节点，将当前节点添加到结果列表
    result.add(root);

    return result;
  }

  public static void main(String[] args) {
    // 创建示例 CustomIndicatorInfo 对象

    CustomIndicatorInfo R1 = new CustomIndicatorInfo();
    R1.setIndicatorName("R1");

    CustomIndicatorInfo R2 = new CustomIndicatorInfo();
    R2.setIndicatorName("R2");

    CustomIndicatorInfo R3 = new CustomIndicatorInfo();
    R3.setIndicatorName("R3");

    R3.setLeftNode(R1);
    R3.setRightNode(R2);

    // 后序遍历获取所有节点
    List<CustomIndicatorInfo> allNodes = postOrderCustomIndicator(R3).subList(0,postOrderCustomIndicator(R3).size()-1);

    // 输出每个节点的指标名称
    for (CustomIndicatorInfo allNode : allNodes) {
      log.info(allNode.getIndicatorName());
    }
  }
}

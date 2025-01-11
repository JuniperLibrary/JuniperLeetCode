package com.lc150;

import java.util.*;
import lombok.extern.slf4j.*;

@Slf4j
public class InvertedIndex {

  // 倒排索引数据结构：Map<单词, Set<文档ID>>
  private final Map<String, Set<Integer>> invertedIndex;

  public InvertedIndex() {
    invertedIndex = new HashMap<>();
  }

  /**
   * 添加文档到倒排索引
   *
   * @param docId   文档ID
   * @param content 文档内容
   */
  public void addDocument(int docId, String content) {
    // 分词：将内容拆分为单词
    String[] words = content.split("\\s+"); // 按空格分词

    for (String word : words) {
      // 将单词转为小写（可选，根据需求）
      word = word.toLowerCase();

      // 如果单词不存在于索引中，初始化一个空的文档ID集合
      invertedIndex.putIfAbsent(word, new HashSet<>());

      // 将当前文档ID添加到单词对应的集合中
      invertedIndex.get(word).add(docId);
    }
  }

  /**
   * 查询包含某个单词的文档ID列表
   *
   * @param word 查询的单词
   * @return 包含该单词的文档ID集合
   */
  public Set<Integer> search(String word) {
    // 将单词转为小写（与添加时一致）
    word = word.toLowerCase();

    // 返回单词对应的文档ID集合，如果单词不存在则返回空集合
    return invertedIndex.getOrDefault(word, Collections.emptySet());
  }

  /**
   * 打印倒排索引（用于调试）
   */
  public void printInvertedIndex() {
    for (Map.Entry<String, Set<Integer>> entry : invertedIndex.entrySet()) {
      log.info("单词: {}  -> 文档ID: {}" ,entry.getKey(), entry.getValue());
    }
  }

  public static void main(String[] args) {
    // 创建倒排索引实例
    InvertedIndex index = new InvertedIndex();

    // 添加文档
    index.addDocument(1, "苹果 香蕉 橙子");
    index.addDocument(2, "苹果 葡萄");
    index.addDocument(3, "香蕉 葡萄 西瓜");

    // 打印倒排索引
    index.printInvertedIndex();

    // 查询
    String query = "苹果";
    Set<Integer> result = index.search(query);
    log.info("查询单词 : {}, 的文档ID:{}" ,query , result);
  }
}
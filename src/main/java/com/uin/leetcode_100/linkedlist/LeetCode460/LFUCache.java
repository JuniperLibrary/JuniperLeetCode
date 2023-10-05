package main.java.com.uin.leetcode_100.linkedlist.LeetCode460;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.lin
 */
public class LFUCache {

  /**
   * 如果 key 已存在，则变更其值；
   * 如果 key 不存在，请插入键值对。
   * 当缓存达到其容量 capacity 时，则应该在插入新的node之前，移除最不经常使用的node
   * 在此问题中，当存在平局 （两个或多个key具有相同的使用频率） 应该去除 最近最久未使用 的key
   */
  private static class Node {
    int key, value, freq = 1; // 新书只读了一次
    Node prev, next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Node> freqToDummy = new HashMap<>();
  private int minFreq;

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    Node node = getNode(key);
    return node != null ? node.value : -1;
  }

  public void put(int key, int value) {
    Node node = getNode(key);
    if (node != null) { // 有这本书
      node.value = value; // 更新 value
      return;
    }
    if (keyToNode.size() == capacity) { // 书太多了
      Node dummy = freqToDummy.get(minFreq);
      Node backNode = dummy.prev; // 最左边那摞书的最下面的书
      keyToNode.remove(backNode.key);
      remove(backNode); // 移除
      if (dummy.prev == dummy) { // 这摞书是空的
        freqToDummy.remove(minFreq); // 移除空链表
      }
    }
    node = new Node(key, value); // 新书
    keyToNode.put(key, node);
    pushFront(1, node); // 放在「看过 1 次」的最上面
    minFreq = 1;
  }

  private Node getNode(int key) {
    if (!keyToNode.containsKey(key)) { // 没有这本书
      return null;
    }
    Node node = keyToNode.get(key); // 有这本书
    remove(node); // 把这本书抽出来
    Node dummy = freqToDummy.get(node.freq);
    if (dummy.prev == dummy) { // 抽出来后，这摞书是空的
      freqToDummy.remove(node.freq); // 移除空链表
      if (minFreq == node.freq) {
        minFreq++;
      }
    }
    pushFront(++node.freq, node); // 放在右边这摞书的最上面
    return node;
  }

  // 创建一个新的双向链表
  private Node newList() {
    Node dummy = new Node(0, 0); // 哨兵节点
    dummy.prev = dummy;
    dummy.next = dummy;
    return dummy;
  }

  // 在链表头添加一个节点（把一本书放在最上面）
  private void pushFront(int freq, Node x) {
    Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
    x.prev = dummy;
    x.next = dummy.next;
    x.prev.next = x;
    x.next.prev = x;
  }

  // 删除一个节点（抽出一本书）
  private void remove(Node x) {
    x.prev.next = x.next;
    x.next.prev = x.prev;
  }
}

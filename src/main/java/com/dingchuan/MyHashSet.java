package com.dingchuan;



import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author dingchuan
 */
public class MyHashSet {

  private static final int BASE = 769;
  private final LinkedList[] data;

  public MyHashSet() {
    data = new LinkedList[BASE];
    for (int i = 0; i < BASE; i++) {
      data[i] = new LinkedList<Integer>();
    }
  }

  public void add(int key) {
    int h = hash(key);
    Iterator iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer next = (Integer) iterator.next();
      if (next == key) {
        return;
      }
    }
    data[h].offerLast(key);
  }

  public void remove(int key) {
    int h = hash(key);
    Iterator iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer next = (Integer) iterator.next();
      if (next == key) {
        data[h].remove(next);
        return;
      }
    }
  }

  public boolean contains(int key) {
    int h = hash(key);
    Iterator iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer next = (Integer) iterator.next();
      if (next == key) {
        return true;
      }
    }
    return false;
  }

  private int hash(int key) {
    return key % BASE;
  }

  public static void main(String[] args) {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);
    myHashSet.add(2);
    myHashSet.add(3);
    myHashSet.remove(2);
    System.out.println(myHashSet.contains(1));
    System.out.println(myHashSet.contains(2));
    System.out.println(myHashSet.contains(3));
    System.out.println(myHashSet.contains(4));
    System.out.println(myHashSet.contains(1));
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * <p>
 * MyHashSet obj = new MyHashSet();
 * <p>
 * obj.add(key);
 * <p>
 * obj.remove(key);
 * <p>
 * boolean param_3 = obj.contains(key);
 */

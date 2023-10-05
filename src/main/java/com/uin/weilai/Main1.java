package main.java.com.uin.weilai;


import java.util.*;

public class Main1 {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();
    Map<String, Integer> f = new HashMap<>();
    for (int i = 0; i <= str.length() - k; i++) {
      String word = str.substring(i, i + k);
      f.put(word, f.getOrDefault(word, 0) + 1);
    }
    int maxF = -1;
    String word = "";
    for (Map.Entry<String, Integer> entry : f.entrySet()) {
      if (entry.getValue() > maxF) {
        maxF = entry.getValue();
        word = entry.getKey();
      } else if (entry.getValue() == maxF) {
        if (entry.getKey().compareTo(word) < 0) {
          word = entry.getKey();
        }
      }
    }
    if (maxF >= 1) {
      System.out.println(word);
    } else {
      System.out.println("-1");
    }
  }

//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int k = scanner.nextInt();
//    scanner.nextLine();
//    String inputStr = scanner.nextLine();
//    String[] split = inputStr.split("");
//    List<String> solution = solution(split, k);
//    StringBuilder ans = new StringBuilder();
//    if (solution.isEmpty() || solution.size() < k) {
//      System.out.println("-1");
//    } else {
//      for (String s : solution) {
//        System.out.print(s);
//      }
//    }
//  }
//
//  public static List<String> solution(String[] words, int k) {
//    Map<String, Integer> map = new HashMap<>(words.length);
//    for (String word : words) {
//      map.put(word, map.getOrDefault(word, 0) + 1);
//    }
//    PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
//      Integer o1Count = map.get(o1);
//      Integer o2Count = map.get(o2);
//      if (o1Count.equals(o2Count)) {
//        return o2.compareTo(o1);
//      } else {
//        return o1Count - o2Count;
//      }
//    });
//    for (String word : map.keySet()) {
//      queue.offer(word);
//      if (queue.size() > k) {
//        queue.poll();
//      }
//    }
//    LinkedList<String> stack = new LinkedList<>();
//    while (!queue.isEmpty()) {
//      stack.push(queue.poll());
//    }
//    return stack;
//  }
}

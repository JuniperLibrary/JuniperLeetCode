package com.T;

import java.util.*;

/**
  5
  ranko mt
  ranko op
  ranko op
  Ranko ok
  red ok
 */
public class Main1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine(); // Consume the newline
    HashMap<String, Business> businesses = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] input = scanner.nextLine().split(" ");
      String name = input[0];
      String address = input[1];
      if (!isValidInput(name) || !isValidInput(address)) {
        continue;
      }
      if (!businesses.containsKey(name)) {
        businesses.put(name, new Business(name, address));
      } else {
        Business existingBusiness = businesses.get(name);
        if (existingBusiness.mainStoreAddress.equals(address)) {
          continue;
        } else {
          existingBusiness.numBranches++;
        }
      }
    }
    List<Business> sortedBusinesses = new ArrayList<>(businesses.values());
    sortedBusinesses.sort(Comparator.comparing(business -> business.name));
    for (Business business : sortedBusinesses) {
      System.out.println(
          business.name + " " + business.mainStoreAddress + " " + business.numBranches
      );
    }
  }

  public static boolean isValidInput(String input) {
    return input.matches("^[a-z]+$");
  }

  static class Business {

    String name;
    String mainStoreAddress;
    int numBranches;

    Business(String name, String mainStoreAddress) {
      this.name = name;
      this.mainStoreAddress = mainStoreAddress;
      this.numBranches = 0;
    }
  }
}

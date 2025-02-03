package org.example.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task346 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader("src/main/resources/task346/input.txt"));
    String[] parts = reader.readLine().trim().split(" ");
    long a = Long.parseLong(parts[0]);
    long b = Long.parseLong(parts[1]);
    long c = Long.parseLong(parts[2]);
    reader.close();

    String sortedA = getSortedDigits(a);
    Set<Long> permutationsB = generatePermutations(b);

    List<Pair> candidates = new ArrayList<>();

    for (long y : permutationsB) {
      if (y > c) {
        continue;
      }
      long x = c - y;
      if (x < 0) {
        continue;
      }
      if (isValidX(x, sortedA)) {
        candidates.add(new Pair(x, y));
      }
    }
    BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/resources/task346/output.txt"));
    if (!candidates.isEmpty()) {
      candidates.sort(Comparator.comparingLong(Pair::getX).thenComparingLong(Pair::getY));
      Pair best = candidates.get(0);
      writer.write("YES\n");
      writer.write(best.x + " " + best.y);
    } else {
      writer.write("NO");
    }
    writer.close();
  }

  private static String getSortedDigits(long number) {
    String numStr = Long.toString(number);
    char[] digits = numStr.toCharArray();
    Arrays.sort(digits);
    return new String(digits);
  }

  private static boolean isValidX(long x, String sortedA) {
    if (x == 0) {
      return sortedA.equals("0");
    }
    String xStr = Long.toString(x);
    if (xStr.charAt(0) == '0') {
      return false;
    }
    char[] xDigits = xStr.toCharArray();
    Arrays.sort(xDigits);
    return Arrays.equals(xDigits, sortedA.toCharArray());
  }

  private static Set<Long> generatePermutations(long number) {
    if (number == 0) {
      return new HashSet<>(Collections.singletonList(0L));
    }
    String numStr = Long.toString(number);
    char[] digits = numStr.toCharArray();
    Arrays.sort(digits);
    Set<Long> permutations = new HashSet<>();
    backtrack(digits, new boolean[digits.length], new StringBuilder(), permutations);
    return permutations;
  }

  private static void backtrack(char[] digits, boolean[] used, StringBuilder sb, Set<Long> result) {
    if (sb.length() == digits.length) {
      String s = sb.toString();
      if (s.charAt(0) == '0') {
        return;
      }
      result.add(Long.parseLong(s));
      return;
    }
    for (int i = 0; i < digits.length; i++) {
      if (used[i]) {
        continue;
      }
      if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      sb.append(digits[i]);
      backtrack(digits, used, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      used[i] = false;
    }
  }

  static class Pair {

    long x, y;

    Pair(long x, long y) {
      this.x = x;
      this.y = y;
    }

    long getX() {
      return x;
    }

    long getY() {
      return y;
    }
  }
}

package org.example.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task109 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader("src/main/resources/task109/input.txt"));
    String line = reader.readLine().trim();
    reader.close();

    String[] parts = line.split("/");
    int A = Integer.parseInt(parts[0]);
    int B = Integer.parseInt(parts[1]);

    StringBuilder result = new StringBuilder();
    int integerPart = A / B;
    int remainder = A % B;

    result.append(integerPart);

    if (remainder != 0) {
      result.append(".");
      Map<Integer, Integer> remainderMap = new HashMap<>();
      StringBuilder decimalPart = new StringBuilder();
      int index = 0;

      while (remainder != 0) {
        if (remainderMap.containsKey(remainder)) {
          int start = remainderMap.get(remainder);
          String nonRepeating = decimalPart.substring(0, start);
          String repeating = decimalPart.substring(start);
          decimalPart = new StringBuilder(nonRepeating + "(" + repeating + ")");
          break;
        }
        remainderMap.put(remainder, index++);
        remainder *= 10;
        int digit = remainder / B;
        decimalPart.append(digit);
        remainder %= B;
      }

      result.append(decimalPart);
    }

    String output = result.toString()
        .replaceAll("\\.$", "")
        .replaceAll("\\(0\\)", "")
        .replaceAll("0+\\)", ")");

    BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/task109/output.txt"));
    writer.write(output);
    writer.close();
  }
}

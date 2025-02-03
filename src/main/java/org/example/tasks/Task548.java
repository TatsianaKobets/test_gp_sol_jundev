package org.example.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task548 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/task548/input.txt"));
    String num1 = reader.readLine();
    String num2 = reader.readLine();
    reader.close();

    int len1 = num1.length();
    int len2 = num2.length();

    // Оптимизация: используем StringBuffer для эффективной конкатенации
    String[][] memo = new String[len1 + 1][len2 + 1];

    for (int i = len1; i >= 0; i--) {
      for (int j = len2; j >= 0; j--) {
        if (i == len1 && j == len2) {
          memo[i][j] = "";
        } else if (i == len1) {
          memo[i][j] = num2.substring(j);
        } else if (j == len2) {
          memo[i][j] = num1.substring(i);
        } else {
          // Сравниваем посимвольно для оптимизации
          char c1 = num1.charAt(i);
          char c2 = num2.charAt(j);

          if (c1 < c2) {
            memo[i][j] = c1 + memo[i + 1][j];
          } else if (c2 < c1) {
            memo[i][j] = c2 + memo[i][j + 1];
          } else {// Если символы равны, выбираем вариант с минимальным продолжением
            String take1 = c1 + memo[i + 1][j];
            String take2 = c2 + memo[i][j + 1];
            memo[i][j] = take1.compareTo(take2) < 0 ? take1 : take2;
          }
        }
      }
    }

    BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/task548/output.txt"));
    writer.write(memo[0][0]);
    writer.close();
  }
}

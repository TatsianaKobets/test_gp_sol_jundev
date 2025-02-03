package org.example.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task193 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader("src/main/resources/task193/input.txt"));
    String[] firstLine = reader.readLine().trim().split("\\s+");
    int N = Integer.parseInt(firstLine[0]);
    int M = Integer.parseInt(firstLine[1]);
    int K = Integer.parseInt(firstLine[2]);

    int[][] grid = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] line = reader.readLine().trim().split("\\s+");
      for (int j = 0; j < M; j++) {
        grid[i][j] = Integer.parseInt(line[j]);
      }
    }
    reader.close();

    boolean[][] covered = new boolean[N][M];
    int[][] rectangles = new int[K + 1][4];

    for (int k = K; k >= 1; k--) {
      List<int[]> cells = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (grid[i][j] == k && !covered[i][j]) {
            cells.add(new int[]{i, j});
          }
        }
      }

      if (cells.isEmpty()) {
        continue;
      }

      int minX = M, maxX = -1;
      int minY = N, maxY = -1;
      for (int[] cell : cells) {
        int j = cell[1];
        int i = cell[0];
        int X = j;
        int Y = (N - 1) - i;
        minX = Math.min(minX, X);
        maxX = Math.max(maxX, X);
        minY = Math.min(minY, Y);
        maxY = Math.max(maxY, Y);
      }

      rectangles[k] = new int[]{minX, minY, maxX + 1, maxY + 1};

      for (int x = minX; x <= maxX; x++) {
        for (int y = minY; y <= maxY; y++) {
          int i = (N - 1) - y;
          int j = x;
          if (i >= 0 && i < N && j >= 0 && j < M) {
            covered[i][j] = true;
          }
        }
      }
    }

    BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/resources/task193/output.txt"));
    for (int k = 1; k <= K; k++) {
      writer.write(String.format("%d %d %d %d\n",
          rectangles[k][0],
          rectangles[k][1],
          rectangles[k][2],
          rectangles[k][3]));
    }
    writer.close();
  }
}

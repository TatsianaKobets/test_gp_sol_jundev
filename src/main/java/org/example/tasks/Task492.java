package org.example.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Task492 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader("src/main/resources/task492/input.txt"));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    long x0 = Long.parseLong(st.nextToken());
    long y0 = Long.parseLong(st.nextToken());

    st = new StringTokenizer(reader.readLine());
    long Vx = Long.parseLong(st.nextToken());
    long Vy = Long.parseLong(st.nextToken());

    st = new StringTokenizer(reader.readLine());
    long V = Long.parseLong(st.nextToken());
    long t = Long.parseLong(st.nextToken());
    long d = Long.parseLong(st.nextToken());
    reader.close();

    // Вычисление позиции цели через t секунд
    long xTarget = x0 + Vx * t;
    long yTarget = y0 + Vy * t;

    // Квадрат расстояния до цели
    long D_sq = xTarget * xTarget + yTarget * yTarget;

    // Максимальное расстояние корабля
    long R = V * t;
    long minDistSq = (R - d) * (R - d);
    long maxDistSq = (R + d) * (R + d);

    // Проверка условий
    boolean possible = (D_sq >= minDistSq) && (D_sq <= maxDistSq);

    BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/resources/task492/output.txt"));
    writer.write(possible ? "YES" : "NO");
    writer.close();
  }
}

/* JG-33
 Есть набор домов, каждый дом может быть окрашен одним из трех цветов: красным, синим или зеленым.
 Стоимость покраски каждого дома определенным цветом отличается.
 Вы должны покрасить все дома, чтобы соседние дома не имели одинакового цвета.
 Стоимость покраски каждого дома с определенным цветом представлена матрицей стоимости n x 3.
 Например, costs[0][0] - стоимость покраски дома №0 красным цветом; costs[1][2] - это стоимость покраски
 дома №1 зеленым цветом и т. д. ...

 Найдите минимальное значение затрат на покраску всех домов.
 метод будет иметь сигнатуру типа:  public int minCost(int[][] costs)*/

package com.hillel.elementary.javageeks.dir.homework3.paint_houses;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PaintHousesForCheapProcessor {
  private static String[] colours = {"red", "blue", "green"};
  private int[] houses;
  private int[] housesForCheap;
  private int minCost;
  private int housePointer;
  private boolean debugMode = false;

  public static void main(String[] args) {
    int houseQuantity = askAboutQuantity();
    int[][] costs = getCosts(houseQuantity);
    PaintHousesForCheapProcessor paintHousesProcessor = new PaintHousesForCheapProcessor();
    int minimalCost = paintHousesProcessor.minCost(costs);
    System.out.println("THE MINIMAL COST: " + minimalCost);

    String housesForCheapStr = Arrays.toString(paintHousesProcessor.getHousesForCheap());
    for (int i = 0; i < colours.length; i++) {
      housesForCheapStr = housesForCheapStr.replace(Integer.toString(i), colours[i]);
    }
    System.out.println("THE CHEAPEST COMBINATION: " + housesForCheapStr);
  }

  private static int askAboutQuantity() {
    Scanner scanner = new Scanner(System.in);
    boolean needToExit = false;
    int houseQuantity = 0;
    try {
      System.out.print("How many houses do you want to paint(1-20)?");
      if (scanner.hasNextInt()) {
        houseQuantity = scanner.nextInt();
        if (houseQuantity <= 0) {
          needToExit = true;
        }
      } else {
        needToExit = true;
      }
    } finally {
      scanner.close();
    }

    if (needToExit) {
      System.out.println("It's too complicated.");
      System.exit(1);
    }
    final int maxHouseQuantity = 100;
    if (houseQuantity > maxHouseQuantity) {
      System.out.println("You have not so much paint.");
      //It will take too much time
      System.exit(0);
    }

    return houseQuantity;
  }

  public static int[][] getCosts(int houseQuantity) {
    final int seed = 1984;
    Random random = new Random(seed);
    int[][] costs = new int[houseQuantity][colours.length];
    final int step = 100;
    final int bound = 9;
    for (int houseIndex = 0; houseIndex < houseQuantity; houseIndex++) {
      for (int colourIndex = 0; colourIndex < colours.length; colourIndex++) {
        costs[houseIndex][colourIndex] = step + random.nextInt(bound) * step; //100, 200, 300...900
      }
    }
    return costs;
  }

  public final int minCost(int[][] costs) {
    calculateHouses(costs);
    return minCost;
  }

  public final int[] calculateHouses(int[][] costs) {
    minCost = Integer.MAX_VALUE;
    int housesCount = costs.length;
    houses = new int[housesCount];
    housesForCheap = new int[housesCount];
    for (int colourIndex = 0; colourIndex < colours.length; colourIndex++) {
      paintAHouse(colourIndex, costs);
    }
    return housesForCheap; //for testing purposes
  }

  private void paintAHouse(int colourIndex, int[][] costs) {
    houses[housePointer] = colourIndex;
    if (housePointer == houses.length - 1) {
      //It's the last house in current paint combination
      calculateSequence(costs);
    } else {
      housePointer++;
      for (int newColourIndex = 0; newColourIndex < colours.length; newColourIndex++) {
        if (colourIndex != newColourIndex) { //It's forbidden to paint the next house in the same colour
          paintAHouse(newColourIndex, costs);
        }
      }
      housePointer--;
    }
  }

  private void calculateSequence(int[][] costs) {
    int currCost = 0;
    for (int i = 0; i < houses.length; i++) {
      currCost += costs[i][houses[i]];
    }

    int prevMinCost = minCost;
    if (currCost < minCost) {
      minCost = currCost;
      System.arraycopy(houses, 0, housesForCheap, 0, houses.length);
    }

    if (debugMode) {
      System.out.println("-----------");
      if (currCost < prevMinCost) {
        System.out.print("Less then current min (" + prevMinCost + "): ");
      } else {
        System.out.print("Too big or equal: ");
      }
      System.out.println(currCost);
      System.out.println(Arrays.toString(houses));
    }
  }

  final int[] getHousesForCheap() {
    return housesForCheap;
  }
}

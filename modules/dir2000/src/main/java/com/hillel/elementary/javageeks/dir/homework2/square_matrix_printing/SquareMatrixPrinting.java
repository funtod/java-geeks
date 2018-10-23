package com.hillel.elementary.javageeks.dir.homework2.square_matrix_printing;

/*Ввести n чисел с консоли.
Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
*/

import java.util.Scanner;

public class SquareMatrixPrinting {
  public static void main(String[] args) {
    long input = 0;
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("Input a sequence of figures:");
      if (scanner.hasNextLong()) {
        input = scanner.nextLong();
      } else {
        System.out.println("Invalid sequence of figures");
        System.exit(1);
      }
    } finally {
      scanner.close();
    }

    if (input < 0) input = -input;

    System.out.println("Result:");

    char [] charArray = Long.toString(input).toCharArray();
    if (charArray.length < 3) {
      System.out.println(input);
      return;
    }

    int length = charArray.length;
    int sideSize = (int) Math.sqrt(length);
    if ((sideSize * sideSize) < length) {
      sideSize++;
    }

    for (int i = 0; i < length; i++) {
      if (i != 0 && i % sideSize == 0)
        System.out.println();
      System.out.print(charArray[i]);
    }
  }
}

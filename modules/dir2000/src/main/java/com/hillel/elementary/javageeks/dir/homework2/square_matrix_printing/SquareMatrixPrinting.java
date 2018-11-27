package com.hillel.elementary.javageeks.dir.homework2.square_matrix_printing;

/*Ввести n чисел с консоли.
Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
*/
/* As the teacher explained to me, the task is simple - to request a sequence of numbers from the user
 and output them in the form of a square matrix.*/

import java.util.Scanner;

public class SquareMatrixPrinting {
  protected SquareMatrixPrinting() {
  }

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

    if (input < 0) {
      input = -input;
    }

    System.out.println("Result:");

    char[] charArray = Long.toString(input).toCharArray();
    final int minLenghToTransform = 3;
    if (charArray.length < minLenghToTransform) {
      //no need to transform something if input data is too small
      System.out.println(input);
      return;
    }

    int length = charArray.length;
    //determining the size of the future matrix
    int sideSize = (int) Math.sqrt(length);
    if ((sideSize * sideSize) < length) {
      //if input data doesn't fit the matrix of such size - increasing the size by 1
      sideSize++;
    }

    for (int i = 0; i < length; i++) {
      if (i != 0 && i % sideSize == 0) {
        //output line ending after every sideSize values
        System.out.println();
      }
      System.out.print(charArray[i]);
    }
  }
}

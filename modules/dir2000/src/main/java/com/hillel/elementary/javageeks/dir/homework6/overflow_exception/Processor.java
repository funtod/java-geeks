/* JG-64
 Напишите метод сложения чисел массива
 Метод calculateSum(int[] numbers) должен принимать массив типа int, и, если произошло переполнение
 int, бросать исключение. Метод, который вызывает calculateSun(), дожен перехватывать исключение,
 и писать в консоль об ошибке.
*/

package com.hillel.elementary.javageeks.dir.homework6.overflow_exception;

public class Processor {
  protected Processor() {
  }

  public static int calculateSum(int[] numbers) {
    int sum = 0;
    for (int value : numbers) {
      sum = Math.addExact(value, sum); //throws ArithmeticException if the result overflows an int
    }
    return sum;
  }

  public static int calculateSumExcessLayer(int[] numbers) {
    int sum = 0;
    try {
      sum = Processor.calculateSum(numbers);
    } catch (ArithmeticException e) {
      System.out.println("An ArithmeticException is detected.");
      throw e;
    }
    return sum;
  }
}

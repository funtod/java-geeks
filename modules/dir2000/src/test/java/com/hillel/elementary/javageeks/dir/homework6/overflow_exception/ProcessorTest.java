package com.hillel.elementary.javageeks.dir.homework6.overflow_exception;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProcessorTest {
  @Test
  public void shouldThrowExceptionInCaseOfOverflow(){
    //when
    int [] array = {1, Integer.MAX_VALUE};

    ThrowableAssert.ThrowingCallable callable = new ThrowableAssert.ThrowingCallable(){
      @Override
      public void call() throws Throwable {
        //...Метод, который вызывает calculateSum(), дожен перехватывать исключение,
        // и писать в консоль об ошибке.
        try {
          Processor.calculateSum(array);
        } catch (ArithmeticException e){
          System.out.println("An ArithmeticException is detected.");
          throw e;
        }
      }
    };

    //then
    assertThatThrownBy(callable).isInstanceOf(ArithmeticException.class);
  }

  @Test
  public void shouldNotThrowAnExceptionUnderNormalConditions(){
    //when
    int [] array = {1, 2};

    //then
    assertThat(Processor.calculateSum(array)).isEqualTo(3);
  }
}

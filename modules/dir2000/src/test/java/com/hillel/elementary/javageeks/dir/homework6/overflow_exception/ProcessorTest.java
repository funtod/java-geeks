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
        Processor.calculateSumExcessLayer(array);
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
    assertThat(Processor.calculateSumExcessLayer(array)).isEqualTo(3);
  }
}

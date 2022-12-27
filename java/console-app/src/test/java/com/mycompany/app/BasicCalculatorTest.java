package com.mycompany.app;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorTest {

  private final BasicCalculator calculator = new BasicCalculator();

  @Test
  public void shouldAddTwoIntegersTest() {
    //given
    int firstInteger = 1;
    int secondInteger = 3;

    //when
    int actual = calculator.addTwoIntegers(firstInteger, secondInteger);

    //then
    int expected = 4;
    Assert.assertEquals(expected, actual);
  }

  @Test(expected = ArithmeticException.class)
  public void shouldThrowArithmeticExceptionInCaseOverflow() {
    //given
    int firstInteger = Integer.MAX_VALUE;
    int secondInteger = Integer.MAX_VALUE / 2;

    //when
    calculator.addTwoIntegers(firstInteger, secondInteger);
  }

}

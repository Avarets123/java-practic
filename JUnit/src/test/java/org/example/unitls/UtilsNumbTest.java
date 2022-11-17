package org.example.unitls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class UtilsNumbTest {

  private final UtilsNumb utilsNumb = new UtilsNumb();


  @DisplayName( "isPrime")
  @Nested
  class ForIsPrime {

    @ParameterizedTest(name = "return <true> on {0}")
    @ValueSource(ints = {2, 3, 7, 113, 31, 41})
    public void on_prime_numbers_return_true(int numbers) {
      assertTrue(utilsNumb.isPrime(numbers));
    }

    @ParameterizedTest(name = "throws exception on {0}")
    @ValueSource(ints = {0, 1})
    public void on_problems_numbers_throws_exception(int problemNumbers) {
      assertThrows(IllegalArgumentException.class, () -> utilsNumb.isPrime(problemNumbers));
    }

    @ParameterizedTest(name = "return <false> on {0}")
    @ValueSource(ints = {121, 169})
    public void  on_square_number_return_false(int numbers) {
      assertFalse(utilsNumb.isPrime(numbers));
    }

  }

}
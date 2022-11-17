package org.example.unitls;

public class UtilsNumb {

  public boolean isPrime(int numb) {
    if (numb == 0 || numb == 1) {
      throw new IllegalArgumentException("Incorrect number");
    }

    if (numb == 2 || numb == 3) {
      return true;
    }

    for (int i = 2; i * i <= numb; i++) {
      if (numb % i == 0) {
        return false;
      }
    }
    return true;
  }
}

package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hamming {

  private static boolean isPowerOfTwo(int number) {
    return Math.ceil(Math.log(number) / Math.log(2)) == Math.log(number) / Math.log(2);
  }

  public static int check(String binaryString) {
    boolean errorOccurred = false;
    String errorBit = "";
    int numberOfOnes;
    boolean isParityBitWithinOwnScope ;

    for (int i = binaryString.length() - 1; i >= 0; i--) {
      if (isPowerOfTwo(binaryString.length() - i)) {
        numberOfOnes = 0;
        isParityBitWithinOwnScope = false;
        for (int k = binaryString.length() - 1; k >= 0; k--) {
          if ((binaryString.length() - i & binaryString.length() - k) != 0 && binaryString.charAt(k) == '1') {
            numberOfOnes++;
            if (k == i) {
              isParityBitWithinOwnScope = true;
            }
          }
        }
        errorBit += numberOfOnes % 2;
        if (isParityBitWithinOwnScope) {
          numberOfOnes--;
        }
        if ((numberOfOnes % 2 == 0 && binaryString.charAt(i) != '0') || (numberOfOnes % 2 != 0 && binaryString.charAt(i) != '1')) {
          errorOccurred = true;
        }
      }
    }
    if (errorOccurred) {
      log.error("Parity check failed - there is an error in bit number {}", Integer.parseInt(errorBit, 2));
      return Integer.parseInt(errorBit, 2);
    } else {
      log.info("Parity bits check succeeded for String: {}", binaryString);
      return -1;
    }
  }

}


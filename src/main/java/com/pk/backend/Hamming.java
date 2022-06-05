package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hamming {

  private static boolean isPowerOfTwo(int number) {
    return Math.ceil(Math.log(number) / Math.log(2)) == Math.log(number) / Math.log(2);
  }

  public static boolean check(String binaryString) {

    int numberOfOnes;

    for (int i = binaryString.length() - 1; i >= 0; i--) {
      if (isPowerOfTwo(binaryString.length() - i)) {
        numberOfOnes = 0;
        for (int k = binaryString.length() - 1; k >= 0; k--) {
          if (!isPowerOfTwo(binaryString.length() - k) && (binaryString.length() - i & binaryString.length() - k) != 0 && binaryString.charAt(k) == '1') {
            numberOfOnes++;
          }
        }
        if ((numberOfOnes % 2 == 0 && binaryString.charAt(i) != '0') || (numberOfOnes % 2 != 0 && binaryString.charAt(i) != '1')) {
          log.error("Parity bit check failed for bit number {}", binaryString.length() - i);
          return false;
        }
      }
    }
    log.info("Parity bits check succeeded for String: {}", binaryString);
    return true;
  }

}


package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CRC {

  public static boolean check(String binaryString, String polynomial) {
    String originalString = binaryString;
    String tmp;
    while (true) {
      tmp = "";
      while (binaryString.length() > 0 && binaryString.charAt(0) == '0') {
        if (binaryString.length() > 1) {
          binaryString = binaryString.substring(1);
        } else {
          log.info("CRC check succeeded for binary string: {}", originalString);
          return true;
        }
      }
      if (binaryString.length() < polynomial.length()) {
        log.error("CRC check failed for binary string: {}", originalString);
        return false;
      }
      for (int i = 0; i < polynomial.length(); i++) {
        tmp += xor(binaryString.charAt(i), polynomial.charAt(i));
      }
      binaryString = tmp + binaryString.substring(tmp.length());
    }
  }

  private static char xor(char a, char b) {
    if (a == b)
      return '0';
    else
      return '1';
  }
}

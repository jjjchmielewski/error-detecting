package com.pk.backend;

public class CRC {

  public static boolean check(String binaryString, String polynomial) {
    String tmp;
    while (true) {
      tmp = "";
      while (binaryString.length() > 0 && binaryString.charAt(0) == '0') {
        if (binaryString.length() > 1) {
          binaryString = binaryString.substring(1);
        } else {
          return true;
        }
      }
      if (binaryString.length() < polynomial.length()) {
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

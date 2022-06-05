package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Berger {


  public static boolean check(String binaryString) {
    int controlBitsLength = (int) Math.ceil((Math.log(binaryString.length() - 1.0) / Math.log(2)));
    int infoBitsLength = binaryString.length() - controlBitsLength;
    int controlBitsDecimal = Integer.parseInt(binaryString.substring(infoBitsLength), 2);

    int numberOfZerosInInfoBits = 0;

    for (char x : binaryString.substring(0, infoBitsLength).toCharArray()) {
      if (x == '0') {
        numberOfZerosInInfoBits++;
      }
    }

    if (numberOfZerosInInfoBits > controlBitsDecimal) {
      log.error("Berger code check failed - some 1s have changed to 0s");
      return false;
    } else if (numberOfZerosInInfoBits < controlBitsDecimal) {
      log.error("Berger code check failed - some 0s have changed to 1s");
      return false;
    } else {
      log.info("Berger code check succeeded for String: {}", binaryString);
      return true;
    }

  }
}

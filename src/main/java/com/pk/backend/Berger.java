package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Berger {


  public static boolean check(String binaryString) {
    int controlBitsLength = (int) Math.ceil((Math.log(binaryString.length() - 1.0) / Math.log(2)));
    int infoBitsLength = binaryString.length() - controlBitsLength;
    //int infoBitsDecimal = Integer.parseInt(binaryString.substring(0, infoBitsLength), 2);
    int controlBitsDecimal = Integer.parseInt(binaryString.substring(infoBitsLength), 2);
    log.info("control bits length " + controlBitsLength);
    log.info("info bits length " + infoBitsLength);
    log.info("control bits decimal " + controlBitsDecimal);
    //log.info("info bits decimal " + infoBitsDecimal);

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
      return true;
    }

  }
}

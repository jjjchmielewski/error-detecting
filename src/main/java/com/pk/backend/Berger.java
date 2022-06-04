package com.pk.backend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Berger {


  public static void check(String binaryString) {
    int controlBitsLength = (int) Math.ceil((Math.log(binaryString.length() - 1.0) / Math.log(2)));
    int infoBitsLength = binaryString.length() - controlBitsLength;
    //int infoBitsDecimal = Integer.parseInt(binaryString.substring(0, infoBitsLength), 2);
    int controlBitsDecimal = Integer.parseInt(binaryString.substring(infoBitsLength), 2);
    log.info("control bits length " + controlBitsLength);
    log.info("info bits length " + infoBitsLength);
    log.info("control bits decimal " + controlBitsDecimal);
    //log.info("info bits decimal " + infoBitsDecimal);

    int numberOfOnesInInfoBits = 0;

    for(char x : binaryString.substring(0, infoBitsLength).toCharArray()) {
      if(x == '1') {
        numberOfOnesInInfoBits++;
      }
    }

    if(numberOfOnesInInfoBits != controlBitsDecimal) {
      log.error("Number of ones is not valid with control bits");
    }

  }
}

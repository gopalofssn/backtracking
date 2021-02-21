package com.gs.algorithms.backtracking.ip;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateValidIPTest {

  private GenerateValidIP generateValidIP = new GenerateValidIP();

  @Test
  public void testGenerateBigRange() {
    List<String> actualIps = generateValidIP.generate("25525511135");
    List<String> expectedIps = Arrays.asList("255.255.11.135", "255.255.111.35");
    assertEquals(actualIps, expectedIps);
  }


  @Test
  public void testGenerateNone() {
    List<String> actualIps = generateValidIP.generate("0000");
   
    List<String> expectedIps = Collections.emptyList();
    assertEquals(actualIps, expectedIps);
  }

  @Test
  public void testGenerateBigFew() {
    List<String> actualIps = generateValidIP.generate("010010");
    List<String> expectedIps = Collections.emptyList();
    assertEquals(actualIps, expectedIps);
  }

  @Test
  public void testGenerateLot() {
    List<String> actualIps = generateValidIP.generate("101023");
    System.err.println(actualIps);
    List<String> expectedIps = Arrays.asList("1.0.1.023", "1.0.10.23", "1.0.102.3", "1.01.0.23", "1.01.02.3", "1.010.2.3", "10.1.0.23", "10.1.02.3", "10.10.2.3", "101.0.2.3");
    assertEquals(actualIps, expectedIps);
  }


}

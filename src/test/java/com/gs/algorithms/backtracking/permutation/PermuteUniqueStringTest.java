package com.gs.algorithms.backtracking.permutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PermuteUniqueStringTest {
 private PermuteUniqueString permute = new PermuteUniqueString();
  
  @Test
  public void testEmptyAndNull() {
    assertEquals(permute.permute(null), Collections.emptyList());
    assertEquals(permute.permute(""), Collections.emptyList());
  }
  
  @Test
  public void testUniqueChars() {
    List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
    assertEquals(permute.permute("ABC"), expected);
  }
  
  @Test
  public void testDuplicate() {
    List<String> expected = Arrays.asList("AAB", "ABA", "BAA");
    assertEquals(permute.permute("ABA"), expected);
  }
  
}

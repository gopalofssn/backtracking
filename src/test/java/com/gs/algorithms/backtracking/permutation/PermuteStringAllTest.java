package com.gs.algorithms.backtracking.permutation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class PermuteStringAllTest {

  private PermuteStringAll permuteStringAll = new PermuteStringAll();
  
  @Test
  public void testEmptyAndNull() {
    assertEquals(permuteStringAll.permute(null), Collections.emptyList());
    assertEquals(permuteStringAll.permute(""), Collections.emptyList());
  }
  
  @Test
  public void testUniqueChars() {
    List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
    assertEquals(permuteStringAll.permute("ABC"), expected);
  }
  
  @Test
  public void testDuplicate() {
    List<String> expected = Arrays.asList("AAC", "ACA", "AAC", "ACA", "CAA", "CAA");
    assertEquals(permuteStringAll.permute("AAC"), expected);
  }
  
}

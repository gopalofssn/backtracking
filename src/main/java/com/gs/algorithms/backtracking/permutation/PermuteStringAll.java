package com.gs.algorithms.backtracking.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * i/p : ABC 
 * o/p : ABC, ACB, BAC, BCA, CAB, CBA
 * 
 * i/p : AAC 
 * o/p : AAC, ACA, AAC, ACA, CAA, CAA
 * 
 * Condition : no duplicate allowed in the output
 * 
 * approach : duplicate is ok
 */
public class PermuteStringAll {

  public List<String> permute(String str) {
    if(str == null || str.length() == 0) {
      return Collections.emptyList();
    }
    
    List<String> result = new ArrayList<String>();
    permuteUtil("", str, result);
    return result;
  }


  private void permuteUtil(String prefix, String remaining, List<String> result) { // 0 :("",AB)  1: (A,B) (B,A) 2 : (AB,"") (BA "")
    if (remaining.length() == 0) {
      result.add(prefix); // 
      return;
    }

    for(int index = 0; index < remaining.length(); index++) { 
      char ch = remaining.charAt(index); // 0 : A B 1.1: B  1.2 A
      String newRemaining = remaining.substring(0, index) + remaining.substring(index + 1); // 0: B A 1.1 AB 1.2 BA
      permuteUtil(prefix + ch, newRemaining, result); // 0 : (A,B) (B,A) 1.1 (AB "") 1.2 (BA "")
    }
    
  }


  public static void main(String[] args) {
    String str = "ABC";
    System.out.println(new PermuteStringAll().permute(str));
  }

}

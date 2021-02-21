package com.gs.algorithms.backtracking.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * i/p : ABA
 * o/p : AAB, ABA, BAA
 * condition : no duplicate
 * 
 * backtracking is best approach to generate all permutation
 * 
 *  approach 1: have SET and put unique elements in there
 *              but take more time and we ended up going all possible for dup
 *              
 *  approach 2: have count of each char
 *              iterate over chars
 *              do placing char based on element count
 *              this wont produce dup and still we can use LIST
 */
public class PermuteUniqueString {

  public List<String> permute(String str) {
    
    if(str == null || str.length() == 0) {
      return Collections.emptyList();
    }
    
    Map<Character, Integer> charCountMap = buildCharCountMap(str);

    int sz = charCountMap.size();
    char[] chars = new char[sz];
    int[] counts = new int[sz];
    buildCharsAndCountsArraysUsingMap(charCountMap, chars, counts);
    
    List<String> result = new ArrayList<String>();
    permuteUtil(chars, counts, "", result, str.length());
    return result;

  }

  private void buildCharsAndCountsArraysUsingMap(Map<Character, Integer> charCountMap, char[] chars,
      int[] counts) {
    int counter = 0;
    for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
      chars[counter] = entry.getKey();
      counts[counter] = entry.getValue();
      counter++;          
    }
  }

  private Map<Character, Integer> buildCharCountMap(String str) {
    Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
    for(char c : str.toCharArray()) {
      charCountMap.merge(c, 1,  (a, b) -> a + b);
    }
    return charCountMap;
  }

  private void permuteUtil(char[] chars, int[] counts, String permute, List<String> result, final int LEN) {
    
     if(permute.length() == LEN) {
       result.add(permute);
       return;
     }
     
     for(int i = 0; i < chars.length; i++) {
       if(counts[i] == 0) continue;
       char c = chars[i];
       counts[i]--;
       permuteUtil(chars, counts, permute + c, result, LEN);
       counts[i]++;
     }
     
  }

  public static void main(String[] args) {
    String str = "ABA";
    System.out.println(new PermuteUniqueString().permute(str));
  }

}

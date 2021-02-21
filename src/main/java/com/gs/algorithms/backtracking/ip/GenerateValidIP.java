package com.gs.algorithms.backtracking.ip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateValidIP {

  public List<String> generate(String str) {
    if (isNullOrEmpty(str) || str.startsWith("0")) { // content should not be empty/null or start with 0
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<String>();
    generateUtil(str, new LinkedList<String>(), result);
    return result;
  }

  private void generateUtil(String str, LinkedList<String> current, List<String> result) {
    if (isNullOrEmpty(str) && current.size() == 4) {
      result.add(convertAsIP(current));
      return;
    }

    if (isNullOrEmpty(str)) {
      return;
    }

    int ipSegmentLength = possibleLength(3, str.length()); // upto 3 digit or whatever remaining's length

    for (int len = 1; len <= ipSegmentLength; len++) {
      String segment = str.substring(0, len);
      if (isValidSegment(segment)) {
        current.addLast(segment);
        String remainingStr = str.substring(len);
        generateUtil(remainingStr, current, result);
        current.removeLast();
      }
    }

  }

  private boolean isValidSegment(String segment) {
    int num = Integer.parseInt(segment);
    return num <= 255;
  }

  private int possibleLength(int len1, int len2) {
    if (len1 < len2)
      return len1;
    else
      return len2;
  }

  private String convertAsIP(LinkedList<String> segments) {
    StringBuilder sb = new StringBuilder();
    for (String segment : segments) {
      sb.append(segment).append(".");
    }
    return sb.substring(0, sb.length() - 1);
  }

  private boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

}

package com.gs.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllPossibleIPAddress {

	private static List<String> restore(String s) {
		List<String> result = new ArrayList<String>();
		helper(s, new LinkedList<Integer>(), result);
		return result;
	}

	private static void helper(String s, LinkedList<Integer> current, List<String> result) {
		//System.out.println(s);
		if(s.isEmpty()){
			if(current.size() == 4) result.add(convertAsIP(current));
			return;
		}
			char c = s.charAt(0);
			if(c == '0'){
				current.addLast(c - '0');
				helper(s.substring(1), current, result);
				current.removeLast();
			}else{
				int len = s.length() > 3 ? 3 : s.length();
				for(int j = 1; j <= len; j++){
					int segment = Integer.parseInt(s.substring(0, j));
					if(segment <= 255){
						current.addLast(segment);
						helper(s.substring(j), current, result);
						current.removeLast();
					}
				}
			}
 
		
	}

	private static String convertAsIP(List<Integer> ipSegments) {
		StringBuilder sb = new StringBuilder();
		for(int segment : ipSegments){
			sb.append(segment)
			  .append(".");
		}
		return sb.substring(0, sb.length() -1);
	}

	public static void main(String[] args) {
		System.out.println(restore("25525511135"));
		System.out.println(restore("0000"));
		System.out.println(restore("010010"));
		System.out.println(restore("101023"));
	}

}

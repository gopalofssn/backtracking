package com.gs.permutation;

import java.util.*;

public class PermuteString {

	private static List<String> permute(String s) {
		Map<Character, Integer> charAndCountMap = new HashMap<>();
		for(char c : s.toCharArray()){
			charAndCountMap.merge(c, 1, (a, b) -> a + b);
		}
		
		char[] v = new char[charAndCountMap.size()];
		int[] count = new int[charAndCountMap.size()];
		int counter = 0;
		for(Map.Entry<Character, Integer> entry : charAndCountMap.entrySet()){
			v[counter] = entry.getKey();
			count[counter] = entry.getValue();
			counter++;
		}
		List<String> result = new ArrayList<String>();
		permuteUtil(v, count, new char[s.length()], result, 0);
		return result;
	}

	private static void permuteUtil(char[] v, int[] count, char[] permute, List<String> result, int level) {
		if(level == permute.length){
			result.add(String.valueOf(permute));
			return;
		}
		for(int i = 0; i < v.length; i++){
			if(count[i] == 0) continue;
			permute[level] = v[i];
			count[i]--;
			permuteUtil(v, count, permute, result, level + 1);
			count[i]++;
		}
		
	}

	public static void main(String[] args) {
		testcase1();
		testcase3();
		testcase2();
	}

	private static void testcase1() {
		String s = "ABC";
		List<String> permutedList = permute(s);
		for (String stra : permutedList) {
			System.out.println(stra);
		}
		System.out.println("***********");
	}
	private static void testcase2() {
		String s = "AAB";
		List<String> permutedList = permute(s);
		for (String stra : permutedList) {
			System.out.println(stra);
		}
		System.out.println("***********");
	}
	private static void testcase3() {
		String s = "AAA";
		List<String> permutedList = permute(s);
		for (String stra : permutedList) {
			System.out.println(stra);
		}
		System.out.println("***********");
	}
}

package com.gs.algorithms.backtracking.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
  IP :A1C
  OP : a1c, A1c, 1AC, 1ac, c1A, c1a 
 */
public class UpperCaseLowerCasePermuteString {

	private static List<String> permute(String s) {
		Set<String> result = new HashSet<String>();
		helper(s, "", s.length(), result);
		return new ArrayList<String>(result);
	}

	private static void helper(String s, String permute, int length, Set<String> result) {
		if(permute.length() == length){
			result.add(permute);
			return;
		}
		
		for(int i = 0 ; i < s.length(); i++){
			 char c = s.charAt(i);
			 String newStr = s.substring(0, i) + s.substring(i+1);
			 if(Character.isDigit(c)){
				 helper(newStr, permute + c, length, result);
			 }else{
				 helper(newStr, permute + Character.toUpperCase(c), length, result);
				 helper(newStr, permute + Character.toLowerCase(c), length, result);
			 }
		}
		
	}

	public static void main(String[] args) {
		String s = "ge1";
		System.out.println(permute(s));
	}
}

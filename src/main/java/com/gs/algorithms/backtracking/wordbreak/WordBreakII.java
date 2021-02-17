package com.gs.wordbreak;

import java.util.*;

public class WordBreakII {

	 public List<String> wordBreak(String s, List<String> wordDict) {
	        Set<String> words = new HashSet<String>(wordDict);
	        return helper(s, words, new LinkedList<String>(), new HashMap<String, List<String>>());
	    }
	    
	    private  List<String> helper(String content, Set<String> words, LinkedList<String> current , Map<String, List<String>> cache){	
	    	if(cache.containsKey(content)){
	    		return cache.get(content);
	    	}else if(content.isEmpty()){
	    		return new ArrayList<String>(current);
	    	}
	    	
	    	List<String> sentenceList = new ArrayList<String>();
	        for(int i = 1; i <= content.length(); i++){ // catsanddog, sanddog , dog
	            String word = content.substring(0, i);//cat , sand, dog
	            if(words.contains(word)){
	            	System.err.println(word);
	            	String nextContent = content.substring(i);// sanddog, dog , ""
	            	current.addLast(word);// [cat], [cat , sand] , [cat, sand, dog] 
	            	List<String> result = helper(nextContent, words, current, cache); 
	            	sentenceList.add(convertAsString(new ArrayList<String>(result)));
	            	current.removeLast();
	            }
	         }
        	cache.putIfAbsent(content, new ArrayList<String>());
        	cache.get(content).addAll(sentenceList);
	        return cache.get(content);
	    }
	    
	    private String convertAsString(List<String> wordList){
	    	System.out.println("wordList " + wordList);
	        StringBuilder sb = new StringBuilder();
	        for(String word : wordList){
	            sb.append(word)
	              .append(" ");
	        }
	        return sb.substring(0, sb.length() -1 );
	    }
	    
	    private final Map<String, List<String>> cache = new HashMap<>();

	    public List<String> wordBreak(String s, Set<String> dict) {
	        if (cache.containsKey(s)) return cache.get(s);
	        List<String> result = new LinkedList<>();
	        if (dict.contains(s)) result.add(s);
	        for (int i = 1; i < s.length(); i++) {
	            String left = s.substring(0,i), right = s.substring(i);
	            if (dict.contains(left) ) {//&& containsSuffix(dict, right)) {
	                for (String ss : wordBreak(right, dict)) {
	                    result.add(left + " " + ss);
	                }
	            }
	        }
	        cache.put(s, result);
	        return result;
	    }
	    
	public static void main(String[] args) {
		String s = "catsanddog";
	    String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
	    System.out.println(new WordBreakII().wordBreak(s, new ArrayList<String>(Arrays.asList(wordDict))));

	    s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	    String[] wordDict2 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
	  //  System.out.println(new WordBreakII().wordBreak(s, new HashSet<String>(Arrays.asList(wordDict2))));

	}

}

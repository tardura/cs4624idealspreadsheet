package edu.cs4624.idealspreadsheet.data;

import java.util.HashMap;
import java.util.Map;

public class WordcountMap {
	Map<String, Integer> mapping;
	
	public WordcountMap() {
		mapping = new HashMap<String, Integer>();
	}
	
	public void addEntry(String word, int occurences) {
		mapping.put(word, occurences);
	}
	
	public Map<String, Integer> getMapping() {
		return mapping;
	}
}

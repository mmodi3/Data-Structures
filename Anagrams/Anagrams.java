package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams{
	final Integer[] primes = {2 , 3 , 5 , 7, 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 , 67 , 71 , 73 , 79 , 83 , 89 , 97 , 101};
	Map<Character, Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;
	/**
	 * Instantiates a new object of class Anagram
	 */
	public Anagrams() {
		 letterTable = new HashMap<Character,Integer>();
		 anagramTable = new HashMap<Long,ArrayList<String>>(); 
		 this.buildLetterTable();
	}
	/**
	 * Reads file to find the list of words you are finding anagrams within
	 * @param s = file of strings being read
	 * @throws IOException Throws exception if file not found
	 */
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader ( new InputStreamReader (fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
		}
	/**
	 * Creates the letterTable that has the alphabet as keys and the first 26 primes as values
	 */
	private void buildLetterTable(){
		Character[] temp = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v', 'w', 'x', 'y', 'z'};
		int i = 0;
		while(i < 26) {
			letterTable.put(temp[i], primes[i]);
			i++;
		}
	}
	/**
	 * 
	 * @param s = String for which the HashCode was creating a key
	 * @return Key for the received string
	 */
	private Long myHashCode(String s) {
		long res = 1;
		for(int i = 0; i < s.length(); i++) {
			res = res*letterTable.get(s.charAt(i));
		}
		return res;
		
	}
	/**
	 * Function that adds strings to anagrams HasMap
	 * @param s = string that is being added to the HashMap
	 */
	private void addWord(String s) {
		if (anagramTable.containsKey(myHashCode(s))) {
			ArrayList<String> temp = anagramTable.get(myHashCode(s));
			temp.add(s);
			anagramTable.put(myHashCode(s), temp);
		} else {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(s);
			anagramTable.put(myHashCode(s), temp);
		}
	}
	/**
	 * Function to find the max anagrams list
	 * @return ArrayList that gives the (key, value) pair of the ArrayList with the max anagrams
	 */
	protected ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
		ArrayList<Map.Entry<Long,ArrayList<String>>>  res = new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		
		Map.Entry<Long,ArrayList<String>> maxEntry = null;
	    for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
	        if (maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()){
	        		maxEntry = entry;
	        		res.clear();
	        		res.add(entry);
	        } else if (entry.getValue().size() == maxEntry.getValue().size()){
	            res.add(entry);
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args){
		Anagrams a = new Anagrams();
		
		final long startTime = System.nanoTime();
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1){
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime /1000000000);
		System.out.println("Elapsed Time : "+ seconds + " seconds");
		System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey());
		System.out.println ("List of max anagrams: "+ maxEntries.get(0).getValue());
		System.out.println("Length of list of max anagrams: " + maxEntries.get(0).getValue().size());
		
	}
	
	
}

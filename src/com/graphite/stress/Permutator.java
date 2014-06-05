package com.graphite.stress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutator {

	private static String[] permutationLetters;
	private static List<String> permutations;
	private static int count = 0;
	
	public static void main(String[] args) {
		
		permute(Arrays.asList("a","b", "c", "d", "e", "f").toArray(new String[0]));
		
	}
	
	public static List<String> permute(String[] letters) {
		
		count = 0;
		
		System.out.println("Received letters: " + Arrays.toString(letters));
		
		permutations = new ArrayList<String>();
		permutationLetters = letters;
		
		permutation(0);
		
		System.out.println("Number of permutations: " + count);
		
		//System.out.println(permutations);
		
		return permutations;
		
	}

	static void swap(int pos1, int pos2)
	{
		String temp = permutationLetters[pos1];
		permutationLetters[pos1] = permutationLetters[pos2];
		permutationLetters[pos2] = temp;
	}

	public static void permutation(int start)
	{
		if (start != 0)
		{
			String generatedString = "";
			for (int i = 0; i < start; i++) {
				generatedString += permutationLetters[i];
			}
			permutations.add(generatedString);
			count++;
		}

		for (int i = start; i < permutationLetters.length; i++)
		{
			swap(start, i);
			permutation(start + 1);
			swap(start, i);
		}
	}	

}
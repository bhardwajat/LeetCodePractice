import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class General {

	public static void main(String[] args) {
		

		String s = "TATATAGCTTGTCTCCCTAATGTTAGTTCATGCTCGTAAGAGAACTTAGCCTACTAGGACGAGAGAACCGCACGGCGTCGTGAGGTATTTTTCGTAGGACACGCCAGATAGACGGTGGCAATGCCCGTTCAATATGACGCGATGTACGGCTAATGGGAACACTGCCCGACGCGTCTTTAGGACTGTGAGTTGCGGGTTACAGCTATGGTCTTATTGGTATCCGGCCCCTTTCGAGTCGCGATGCGCCTGCCACCACGATATTCGCCCGAAACGCGATTTGTGGGCGAGGTAGTCGTGTTCAACCCTGTAAATTTCCCTAGGTATAATCGTTCTAAGGTTCGCACATACACATCCACACCTACCTTTACACAGTTCGAGGTTCTATACGTCCTCTGAGTGCGTGTTAACACGCCCGTAAATGGGCATTTGGAGTCAGACCAGTACTTTGCGATAAACTTTACTTCCGCGAGACCTGTCCCTGGAACCCTGTTGTAAGGGTTAGGGTTTAATAGCTCCATGTCGTGTGCCTATAAGAAAAGGACGAATGGTGACAGTCCGGCTTAGCCAGGACAATGCGTGGCTGACGACGTCCAGGGTAAATTGAGTTGAATTCGCCTAATTTTAGGGTGTCTTGGTTCAATGAGGTGTCGACTTAACAAAAGGCGACATCAGTTGTCATCTTGCCTTGATAAAGTAAAACACGTGAATAGCCTATCCGGTCTGACCCCCGGGCCATGTGCTTCACCCAGGGAGCATCGCCGCTCTAGAGACGGTGTTCGTAGTCTCGATAACATGTGGGGTAATATAGAATATCCAAGACCGGTAGGAGGGGCGGTTCCGCGTCATAAGAAGTCCCAACGTGGCCTGCCACGTTCAAACAGGATACGCTATAACAGCTTCGTGGGTAATTGATGGATACGCCCGCAGGCTACCCATGCTCTTGCGATTTTGCAACCCTCGGAACCGTCACTCGTACACCCAGACATCATCTCATACAATTGCCTCACCTTCATGCCGGTACATAGGTGCCATCTCCGCTTAAGAATCCTCGCAGCAATTAATGTGACAGCACGCTAGTCCACTAGCGTATGATTACGCCACCGGGCCACCATGGACAAAAACGTTGAATTCCGACTAATAGACGAGTGTCCGATCGGGTCAACCGATCTCGGATGTTGCGTACCAGGACTACTGGGCTCGGGCCGAATCAGACACACGTATGCAACAGATACCGATAGGCGTCTTCCTAAGTAACAGCCGTAATCAATGGTGCCACAGATCTACTAATTACGGTGAAGATCATGGCCCACGACGCTGTACGGGTTTATAGCTGCCACAAACTTTAGGAAGTTTCAGCAATCGACGCGTAGTATGTGTGCTCAGACGGGTCGAGCATGCACTTGTGTATTAAGTTACTTGGCTGAACAACCTGTTGATAGATCTTGAGAGGACCGAGAAATTGCCCTCCGGTTATGAAACAGGTCCTGCGTACCAATCCTT";
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		System.out.println(map);
		int[] a = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'A']++;
		}
		if((a[0] == a[2]) && (a[2] == a[6]) && (a[6] == a[19])) {
			System.out.println("true");
		}
		int extra = s.length() / 4;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= extra) {
				map.put((char) (65 + i), (a[i] - s.length()/4));
			}
		}
		System.out.println(map);
		int size = map.size();
		int begin = 0;
		int end = 0;
		int len = Integer.MAX_VALUE; 
		while (end < s.length()) {
			char endchar = s.charAt(end);

			if (map.containsKey(endchar)) {
				map.put(endchar, map.get(endchar) - 1);
				if (map.get(endchar) == 0) {
					size--;
				}

			}
			end++;
			while(size == 0) {
				char startchar = s.charAt(begin);
				if(map.containsKey(startchar)) {
					map.put(startchar, map.get(startchar)+1);
					if(map.get(startchar) > 0) {
						size++;
					}
				}
				if(end - begin < len) {
					len = end - begin;
				}
				begin++;
			}
		}
		System.out.println(len);

	}
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;

public class HackerRank {
	
	public static void main(String[] args) {
		char[] str = new char[] {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
		reverse(str, 0, str.length-1);
		int left = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i] == ' ') {
				reverse(str, left, i - 1);
				left = i + 1;
			}
		}
		reverse(str, left, str.length-1);
		for(char a: str) {
			System.out.print(a + " ");
		}
		
	}
	
	private static void reverse(char[] str, int left, int right) {
		while(left < right) {
			char c = str[right];
			str[right] = str[left];
			str[left] = c;
			left++;
			right--;
		}
	}
}

//int[] days = new int[] {1, 4, 6, 7, 8, 20};
//int[] costs = new int[] {2, 7, 15};
//int[][] dp = new int[costs.length+1][days.length+1];
//
//for(int column = 1; column <= costs.length; column++) {
//	dp[column][0] = costs[column-1];
//}
//
//for(int row = 1; row <= days.length; row++) {
//	dp[0][row] = days[row-1];
//}
//
//
//
//for(int row = 0; row < dp.length; row++) {
//	for(int column = 0; column < dp[0].length; column++) {
//		System.out.print(dp[row][column] + " ");
//	}
//	System.out.println();
//}
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
		String S = "0110";
		int N = 3;
		for(int i = 1; i <= N; i++) {
			String small = convert(i);
			if(!S.contains(small)){
				System.out.println("false");
				break;
			}
		}
		System.out.println("true");
	}
	
	private static String convert(int N) {
		StringBuilder sb = new StringBuilder();
		while(N != 0) {
			int r = N%2;
			sb.append(String.valueOf(r));
			N = N/2;
		}
		
		return sb.reverse().toString();
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
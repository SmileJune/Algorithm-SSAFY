package com.ssafy.ehoi;

import java.util.Scanner;

public class Day18_BOJ_S2_1850 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		int c = (int)recur(a, b);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	static long recur(long a, long b) {
		if (a%b==0) return b;
		
		return recur(b, a%b);
		
	}
	
}

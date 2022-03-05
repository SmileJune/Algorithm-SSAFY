package com.ssafy.ehoi;

import java.util.Scanner;

public class Day25_BOJ_B2_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		
		int a = Integer.parseInt(sb.reverse().toString());
		
		sb = new StringBuilder(sc.next());
		
		int b = Integer.parseInt(sb.reverse().toString());
		
		System.out.println(a > b ? a : b);
		
		
		
		
		
		
		sc.close();
		
	}
}

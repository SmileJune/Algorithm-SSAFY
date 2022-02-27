package com.ssafy.ehoi;

import java.util.Scanner;

public class Day19_BOJ_S5_1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int gcd = cal(a,b); // 최대 공약수
			
			int LCM = a * b / gcd; // 최소 공배수
			
			System.out.println(LCM);
					
		}
		
		
		sc.close();
	}
	// 최대 공약수
	public static int cal(int a, int b) {
		if (a%b == 0) return b;
		
		return cal(b, a%b);
	}
}

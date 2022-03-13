package com.ssafy.ehoi;

import java.util.Scanner;

public class Day34_BOJ_S3_11726 {
	static int[] cases = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		cases[1] = 1;
		cases[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			cases[i] = (cases[i-1] + cases[i-2])%10007;
		}
		
		System.out.println(cases[n]);
		
		sc.close();
	}
}

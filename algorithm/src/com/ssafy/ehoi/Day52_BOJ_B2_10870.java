package com.ssafy.ehoi;

import java.util.Scanner;

public class Day52_BOJ_B2_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
		
		sc.close();
	}
	
	public static int fibo(int num) {
		if (num == 0) return 0;
		if (num == 1) return 1;
		
		return fibo(num-1) + fibo(num-2);
		
	}
}

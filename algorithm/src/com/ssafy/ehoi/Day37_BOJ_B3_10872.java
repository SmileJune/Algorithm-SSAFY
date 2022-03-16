package com.ssafy.ehoi;

import java.util.Scanner;

public class Day37_BOJ_B3_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fac(n));
		sc.close();
	}
	
	public static int fac(int num) {
		if (num <= 1) return 1;
		
		return num * fac(num-1);
	}
}

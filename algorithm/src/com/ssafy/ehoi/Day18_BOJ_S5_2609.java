package com.ssafy.ehoi;

import java.util.Scanner;

public class Day18_BOJ_S5_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int GCD = recur(a,b);
		int LCM = a * b / GCD; // 최소공배수는 두 수의 곱에다가 최대공약수로 나눠준 것!
		
		System.out.println(GCD);
		System.out.println(LCM);
		
		sc.close();
		
		
	
		
	}
	
	static int recur(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return recur(b, a%b);
	}
}

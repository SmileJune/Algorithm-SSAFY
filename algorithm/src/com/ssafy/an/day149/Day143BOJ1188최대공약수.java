package com.ssafy.an.day149;

import java.util.Scanner;

public class Day143BOJ1188최대공약수 { // 1188 음식 평론가
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		System.out.println(M - gcd(N, M));
		sc.close();
	}

	private static int gcd(int n, int m) {
		return n % m == 0 ? m : gcd(m, n % m);
	}
}
//	static int gcd(int a, int b) { //최대공약수 구하는 함수
//		while (b != 0) {
//			int r = a % b;	
//			a = b;
//			b = r;
//		}
//		return a;
//	}
package com.ssafy.ehoi;

import java.util.Scanner;

/*
 * a,b,c 모두 int를 쓸 수 있는 자연수 
 * 시간제한이 0.5초 인걸 봐서는 빠르게 풀어야 하나 ?
 */
public class Day28_BOJ_S1_1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		System.out.println(multiple(a, b, c));

		sc.close();
	}

	public static long multiple(int a, int b, int c) {
		// 베이스 파트
		if (b == 1)
			return a % c;

		// 재귀 파트
		long tmp = 1L * multiple(a, b / 2, c);
		// tmp에 담아놓고 왜 tmp 안 쓰고 직접 재귀 던지세요?
		return b % 2 == 0 ? (tmp * tmp) % c : ((tmp * tmp) % c * (a % c)) % c;

	}
}

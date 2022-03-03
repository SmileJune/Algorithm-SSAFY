package com.ssafy.hwang;

import java.util.Scanner;
public class Day24_BOJ_베르트랑공준 {
	static boolean[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = -1;
		while (true) {
			N = sc.nextInt();
			if(N==0) {
				return;
			}
			if (N == 1) {
				System.out.println(1);
				continue;
			}
			int cnt = 0;
			getPrime(N);
			

			for (int i = N+1; i <= 2 * N; i++) {
				if (arr[i] == false) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	public static void getPrime(int N) {
		arr = new boolean[2 * N + 1];
		for (int i = 2; i <= Math.sqrt(2 * N); i++) {
			if (arr[i] == false) {
				for (int j = i * i; j <= 2 * N; j += i) {
					arr[j] = true;
				}
			}
		}
	}
}

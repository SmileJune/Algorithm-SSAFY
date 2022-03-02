package com.ssafy.hwang;

import java.util.Scanner;

public class Day23_BOJ_소수 {
	static boolean[] isNotPrime;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		isNotPrime = new boolean[N+1];
		isNotPrime[1] = true;
		int sum = 0;
		getPrime(N);
		for(int i=M; i<=N;i++) {
			if(!isNotPrime[i]) {
				sum += i;
			}
		}
		for(int i=M; i<=N;i++) {
			if(!isNotPrime[i]) {
				System.out.println(sum);
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	public static void getPrime(int N) {

		for (int i = 2; i < Math.sqrt(N); i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}

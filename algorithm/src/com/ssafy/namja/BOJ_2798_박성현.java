package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2798_박성현 {
	static int[] cards;
	static int N, M;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		for (int i = 0; i < N; i++)
			cards[i] = sc.nextInt();
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= M)
						max = Math.max(sum, max);
				}
			}
		}
		System.out.println(max);
	}
}
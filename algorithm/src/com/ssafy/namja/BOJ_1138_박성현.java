package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1138_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] key = new int[N];
		int[] batch = new int[N];
		for (int i = 0; i < N; i++) {
			key[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = key[i];
			for (int j = 0; j < N; j++) {
				if (cnt == 0 && batch[j] == 0) {
					batch[j] = i + 1;
					break;
				}
				if (batch[j] == 0)
					cnt--;
			}
		}
		for (int i : batch)
			System.out.print(i + " ");
	}
}
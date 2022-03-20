package com.ssafy.ehoi;

import java.util.Scanner;

public class Day41_BOJ_S3_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 종류
		int K = sc.nextInt(); // 만들려고 하는 액수
		
		int[] won = new int[N];
		for (int i = 0; i < N; i++) {
			won[i] = sc.nextInt();
		}
		
		int ans = 0;
		for (int i = won.length-1; i >= 0; i--) {
			if ((K/won[i]) != 0) {
				ans += K/won[i];
				K -= (K/won[i])*won[i];
			}
			if (K == 0) break;
		}
		
		
		System.out.println(ans);
		sc.close();
	}
}

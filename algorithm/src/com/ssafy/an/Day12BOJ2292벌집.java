package com.ssafy.an;

import java.util.Scanner;

public class Day12BOJ2292벌집 { // 2292
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sum = 1;// += 1 + i * 6
		int ans = 0; // 18258번째가 N의 최대인 1000_000_000을 넘음 
		for (int i = 0; i < 18258; i++) {
			sum += i * 6;
			if (sum >= N) {
				ans = i + 1;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}

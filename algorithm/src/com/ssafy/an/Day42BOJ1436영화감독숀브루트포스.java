package com.ssafy.an;

import java.util.Scanner;

public class Day42BOJ1436영화감독숀브루트포스 { // 1436 영화감독 숀 666 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int ans = 666;
		while (cnt != N) {
			if (is666(ans))
				cnt++;
			ans++;
		}

		System.out.println(ans - 1);
		sc.close();
	}

	private static boolean is666(int ans) {
		return Integer.toString(ans).contains("666");
	}
}

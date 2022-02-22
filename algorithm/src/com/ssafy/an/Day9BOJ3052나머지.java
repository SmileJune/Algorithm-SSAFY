package com.ssafy.an;

import java.util.Scanner;

public class Day9BOJ3052나머지 { // 3052
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] s = new int[42]; // 나머지는 0 ~ 41
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			s[n % 42]++;
		}
		int cnt = 0;
		for (int i : s) {
			if (i != 0)
				cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}

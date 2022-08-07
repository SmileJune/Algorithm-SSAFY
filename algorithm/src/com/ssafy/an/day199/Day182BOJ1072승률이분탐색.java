package com.ssafy.an.day199;

import java.util.Scanner;

public class Day182BOJ1072승률이분탐색 { // 1072 승률 이분탐색 
	static int X, Y, Z;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		Z = getPercent(X, Y);

		int ans = -1;
		int l = 0;
		int r = 1_000_000_000;
		while (l <= r) {
			int mid = (l + r) / 2;

			if (getPercent(X + mid, Y + mid) != Z) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(ans);
		sc.close();
	}

	static int getPercent(int x, int y) {
		return (int) ((long) y * 100 / x);
	}
}

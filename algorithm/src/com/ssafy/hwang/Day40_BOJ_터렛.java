package com.ssafy.hwang;

import java.util.Scanner;

public class Day40_BOJ_터렛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			int l_pow = (int)( Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			System.out.println(sol(x1,x2,y1,y2,r1, r2, l_pow));
		}
	}

	public static int sol(int x1,int x2, int y1, int y2, int r1, int r2, int l_pow) {
		if (r1 == r2 && x1==x2 && y1==y2) {
			return -1;
		}
		if (Math.pow(r1 + r2,2) < l_pow) {
			return 0;
		}
		if (Math.pow(r1 + r2,2) == l_pow) {
			return 1;
		}
		if (l_pow == Math.pow(r1 - r2,2)) {
			return 1;
		}
		if (l_pow < Math.pow(r1 - r2,2)) {
			return 0;
		}
		return 2;
	}
}
package com.ssafy.hwang;

import java.util.Scanner;

public class BOJ_Z {
	static int cnt, R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		recur(0, 0, (int) Math.pow(2, N));
		System.out.println(cnt);
	}

	private static void recur(int sR, int sC, int n) {
		if (n == 1) {
			return;
		}
		n /= 2;
		if (R < sR + n && C < sC + n) {
			recur(sR, sC, n);
			return;
		}
		if (R < sR + n) {
			cnt += n*n * 1;
			recur(sR, sC + n, n);
			return;
		}
		// cnt = 8 , (2,0) 2
		if (C < sC + n) {
			cnt += n*n * 2;
			recur(sR + n, sC, n);
			return;
		}

		cnt += n*n * 3;
		recur(sR + n, sC + n, n);

	}
}

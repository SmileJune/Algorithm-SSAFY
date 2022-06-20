package com.ssafy.an.day149;

import java.util.Scanner;

public class Day134BOJ17991CarrylessSquareRootCal { // 17991 carryless square root 자력아님
	public static int len;
	public static int[] sqr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sqr = new int[s.length()];
		len = sqr.length;
		for (int i = 0; i < len; i++)
			sqr[i] = s.charAt(i) - '0';

		int[] res = wrapper();

		if (res == null)
			System.out.println(-1);
		else {
			for (int i = 0; i < res.length; i++)
				System.out.print(res[i]);
			System.out.println();
		}
	} // 구선생님 도움

	public static int[] wrapper() {
		if (len % 2 == 0)
			return null;

		int[] cur = new int[(len + 1) / 2];
		int[] sum = new int[len];
		boolean res = go(cur, sum, 0);

		if (!res)
			return null;

		return cur;
	}

	public static boolean go(int[] cur, int[] sum, int k) {
		if (k == cur.length)
			return isSqr(sum);

		int s = k == 0 ? 1 : 0;

		for (int d = s; d < 10; d++) {
			int[] cpy = copy(sum);
			cur[k] = d;

			int cLen = cur.length - 1;
			cpy[2 * k] = (cpy[2 * k] + cur[k] * cur[k]) % 10;
			for (int z = k - 1; z >= 0; z--)
				cpy[k + z] = (cpy[k + z] + 2 * cur[k] * cur[z]) % 10;

			if (cpy[k] != sqr[k])
				continue;

			boolean res = go(cur, cpy, k + 1);
			if (res)
				return true;
		}

		return false;
	}

	public static int[] copy(int[] a) {
		int[] res = new int[a.length];
		for (int i = 0; i < res.length; i++)
			res[i] = a[i];
		return res;
	}

	public static boolean isSqr(int[] arr) {
		for (int i = 0; i < sqr.length; i++)
			if (arr[i] != sqr[i])
				return false;
		return true;
	}
}

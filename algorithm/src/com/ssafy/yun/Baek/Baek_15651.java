package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_15651 {
	static int n, m;
	static int[] arr, sel;
	static Scanner sc = new Scanner(System.in);
	static StringBuffer sb;

	public static void main(String[] args) {
		sb = new StringBuffer();
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		sel = new int[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		comb(0);
		System.out.println(sb);

	}

	static void comb(int sidx) {
		if (sidx == m) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			sel[sidx] = arr[i];
			comb(sidx + 1);
		}
	}

}

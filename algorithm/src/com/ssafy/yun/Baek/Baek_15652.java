package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_15652 {
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
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		comb(0, 0);
		System.out.println(sb);

	}

	static void comb(int idx, int sidx) {
		if (sidx == m) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[sidx] = arr[i];
			comb(i, sidx+1);
		}
	}

}

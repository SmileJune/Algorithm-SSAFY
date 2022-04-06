package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_6603 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr, sel;
	static int n;

	public static void main(String[] args) {
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n == 0)
				return;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			sel = new int[6];
			comb(0, 0);
			System.out.println();
		}
	}

	static void comb(int idx, int sidx) {
		if (sidx == 6) {
			String ans = Arrays.toString(sel).replaceAll(",", "");
			System.out.println(ans.substring(1, ans.length()-1));
			return;
		}

		for (int i = idx; i < n; i++) {
			sel[sidx] = arr[i];
			comb(i + 1, sidx + 1);
		}
	}

}

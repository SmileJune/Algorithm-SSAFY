package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_4047 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			solution();
			System.out.println();
		}
	}

	static void solution() {
		String str = sc.next();

		boolean[] arrS = new boolean[14];
		boolean[] arrD = new boolean[14];
		boolean[] arrH = new boolean[14];
		boolean[] arrC = new boolean[14];

		for (int i = 0; i < str.length(); i += 3) {
			int number = Integer.parseInt(str.substring(i + 1, i + 3));
			switch (str.charAt(i)) {
			case 'S':
				if (arrS[number] == true) {
					System.out.print("ERROR");
					return;
				}
				arrS[number] = true;
				break;
			case 'D':
				if (arrD[number] == true) {
					System.out.print("ERROR");
					return;
				}
				arrD[number] = true;
				break;
			case 'H':
				if (arrH[number] == true) {
					System.out.print("ERROR");
					return;
				}
				arrH[number] = true;
				break;
			case 'C':
				if (arrC[number] == true) {
					System.out.print("ERROR");
					return;
				}
				arrC[number] = true;
				break;
			}
		}

		int numS = 0;
		for (int i = 0; i < arrS.length; i++) {
			if (arrS[i] == false) {
				numS++;
			}
		}
		System.out.printf("%d ", numS - 1);
		int numD = 0;
		for (int i = 0; i < arrD.length; i++) {
			if (arrD[i] == false) {
				numD++;
			}
		}
		System.out.printf("%d ", numD - 1);
		int numH = 0;
		for (int i = 0; i < arrH.length; i++) {
			if (arrH[i] == false) {
				numH++;
			}
		}
		System.out.printf("%d ", numH - 1);
		int numC = 0;
		for (int i = 0; i < arrC.length; i++) {
			if (arrC[i] == false) {
				numC++;
			}
		}
		System.out.printf("%d ", numC - 1);

	}

}

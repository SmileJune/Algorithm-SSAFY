package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_1493 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		int p = sc.nextInt();
		int q = sc.nextInt();

		int[] pToArr = ampersand(p);
		int[] qToArr = ampersand(q);

		return sharp(new int[] { pToArr[0] + qToArr[0], pToArr[1] + qToArr[1] });
	}

	static int[] ampersand(int num) {
		int remainder = -1;
		int i = 1;
		int firstNum = 1;
		while (true) {
			if (firstNum > num) {
				firstNum -= --i;
				remainder = num - firstNum;
				break;
			}
			firstNum += i;
			i++;
		}
		return new int[] { 1 + remainder, i - remainder };
	}

	static int sharp(int[] arr) {
		int x = arr[0];
		int y = arr[1];

		return (x + y - 1) * (x + y - 2) / 2 + x;
	}

}

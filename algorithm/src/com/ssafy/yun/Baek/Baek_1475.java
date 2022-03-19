package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1475 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();

		int[] arr = new int[9];
		for (int i = 0; i < str.length(); i++) {
			int num = Integer.parseInt(str.substring(i, i + 1));
			if (num == 9) {
				num = 6;
			}
			arr[num]++;
		}

		// 6제외하고 맥스값
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 6) {
				continue;
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// 6의 값
		int six = arr[6];
		int forSix = six / 2;
		if (six % 2 != 0) {
			forSix++;
		}

		System.out.println(Math.max(forSix, max));
	}

}

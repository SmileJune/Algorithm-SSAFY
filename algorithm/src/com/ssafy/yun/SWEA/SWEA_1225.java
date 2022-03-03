package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_1225 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d ", tc);
			solution();
			System.out.println();
		}

	}

	static void solution() {
		sc.nextInt();

		// 8개 숫자를 배열에 담는다.
		int[] arr = new int[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 프로그램을 진행시키고 프로그램이 종료될 때 마지막 인덱스를 구해준다.
		int idx = -1;
		int num = 0;
		while (true) {
			idx++;
			num++;

			if (num >= 6) {
				num -= 5;
			}

			if (idx >= 8) {
				idx -= 8;
			}

			arr[idx] -= num;
			if (arr[idx] <= 0) {
				arr[idx] = 0;
				break;
			}
		}

		for (int i = idx + 1; i < idx + 1 + 8; i++) {
			System.out.printf("%d ", arr[i % 8]);
		}

	}

}

package com.ssafy.an;

import java.util.Scanner;

public class Day12_BOJ_2477 { // 2477
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int maxWidth = 0;
		int maxHeight = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0)
				maxWidth = arr[i][1] > maxWidth ? arr[i][1] : maxWidth;
			else
				maxHeight = arr[i][1] > maxHeight ? arr[i][1] : maxHeight;
		}
		int innerWidth = 0;
		int innerHeight = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) { // width를 돌때는 height로 검증
				if (maxHeight == arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1])
					innerWidth = arr[i][1];
			} else { // idx에러 조심..
				if (maxWidth == arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1])
					innerHeight = arr[i][1];
			}

		}

		System.out.println((maxWidth * maxHeight - innerWidth * innerHeight) * N);
		sc.close();
	}
}

package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0622_JO_2046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int num = 1;

		int[][] arr = new int[n][n];

		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = num;
				}
				num++;
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < n; j++) {
						arr[i][j] = num++;
					}
				} else {
					for (int j = n - 1; j >= 0; j--) {
						arr[i][j] = num++;
					}
				}
				num = 1;
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = num * (j + 1);
				}
				num++;
			}
			break;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf(arr[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}

package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[7][2];

		int T = sc.nextInt();
		int limit = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();

			map[grade][gender]++;
		}

		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 1; j++) {
				sum += Math.ceil(map[i][j] / (double) limit);
			}
		}
		System.out.println(sum);

	}

}

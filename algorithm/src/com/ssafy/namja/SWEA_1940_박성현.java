package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_1940_박성현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int speed = 0, distance = 0;

			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if (cmd == 1)
					speed += sc.nextInt();
				else if (cmd == 2) {
					int acc = sc.nextInt();
					speed = (speed > acc ? speed - acc : 0);
				}
				distance += speed;
			}

			System.out.printf("#%d %d\n", t, distance);
		}
	}
}
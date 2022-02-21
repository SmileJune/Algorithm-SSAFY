package com.ssafy.ehoi;

import java.util.Scanner;

public class Day13_BOJ_S1_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			int a_left = sc.nextInt();
			int a_bottom = sc.nextInt();
			int a_right = sc.nextInt();
			int a_top = sc.nextInt();
			int b_left = sc.nextInt();
			int b_bottom = sc.nextInt();
			int b_right = sc.nextInt();
			int b_top = sc.nextInt();

			// 공통 부분 없는애 d
			if (a_right < b_left || b_right < a_left || a_top < b_bottom || b_top < a_bottom) {
				System.out.println("d");
			}
			// 점인 애 c
			else if ((a_right == b_left && (a_top == b_bottom || a_bottom == b_top))
					|| (b_right == a_left && (a_top == b_bottom || a_bottom == b_top))) {
				System.out.println("c");
			}
			// 선분 b
			else if ((a_right==b_left && (a_top>b_bottom || a_bottom<b_top))
					|| (b_right == a_left && (a_top>b_bottom || a_bottom>b_top))
					|| (a_bottom == b_top && (a_right > b_left || b_right >a_left))
					|| (b_bottom == a_top && (a_right > b_left || b_right >a_left))
					) {
				System.out.println("b");
			}
			// 나머지 : 겹치는 애 a
			else
				System.out.println("a");

		}

		sc.close();
	}
}

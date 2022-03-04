package com.ssafy.ehoi;

import java.util.Scanner;

public class Day25_BOJ_B2_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int R = sc.nextInt();
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				for (int r = 0; r < R; r++) {
					System.out.print(str.charAt(j));
				}
			}
            System.out.println();
		}
		sc.close();
	}
}

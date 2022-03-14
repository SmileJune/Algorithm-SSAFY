package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_11021 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("Case #%d: %d%n", tc, sc.nextInt() + sc.nextInt());
		}
	}

}

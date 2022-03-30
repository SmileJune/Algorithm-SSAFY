package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1085 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int ans = Integer.MAX_VALUE;
		ans = Math.min(ans, Math.min(w - x, x));
		ans = Math.min(ans, Math.min(h - y, y));
		System.out.println(ans);
	}

}

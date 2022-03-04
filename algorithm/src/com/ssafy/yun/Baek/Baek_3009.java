package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_3009 {

	static Scanner sc = new Scanner(System.in);
	static int x1, y1, x2, y2, x3, y3;

	public static void main(String[] args) {
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		x3 = sc.nextInt();
		y3 = sc.nextInt();

		int x = checkX();
		int y = checkY();
		System.out.printf("%d %d", x, y);
	}

	static int checkX() {
		if (x1 == x2) {
			return x3;
		}
		if (x2 == x3) {
			return x1;
		}

		return x2;
	}

	static int checkY() {
		if (y1 == y2) {
			return y3;
		}
		if (y2 == y3) {
			return y1;
		}

		return y2;
	}

}

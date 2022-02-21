package com.ssafy.yun;

import java.util.Scanner;

public class IM_Test {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %6f%n", tc, solution());
		}

	}

	public static double solution() {
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double h = (4 * (x + y) - Math.sqrt(16 * Math.pow(x + y, 2) - 48 * x * y)) / 24;
		double a = x - 2 * h;
		double b = y - 2 * h;
		double V = a * b * h;

		V *= Math.pow(10, 6);
		V = Math.round(V);
		V /= Math.pow(10, 6);
		return V;

	}

}

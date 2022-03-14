package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_10952 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == 0 && b == 0) {
				return;
			}

			System.out.println(a + b);
		}
	}

}

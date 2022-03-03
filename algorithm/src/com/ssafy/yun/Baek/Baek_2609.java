package com.ssafy.yun;

import java.util.Scanner;

public class Baek_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int temp = 0;
		if (b > a) {
			temp = a;
			a = b;
			b = temp;
		}

		int ans1 = 0;
		for (int i = 1; i <= b; i++) {
			if (a % i == 0 && b % i == 0) {
				ans1 = i;
			}
		}

		System.out.println(ans1);

		int x = 1;
		int y = 1;
		while (true) {
			if (a * x == b * y) {
				break;
			}
			if (a * x > b * y) {
				y++;
			} else {
				x++;
			}
		}
		System.out.println(a * x);
	}
}

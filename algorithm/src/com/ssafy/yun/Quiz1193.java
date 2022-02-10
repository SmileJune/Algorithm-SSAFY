package com.ssafy.yun;

import java.util.Scanner;

public class Quiz1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		int sum = 0;
		int i = 1;
		while (true) {
			sum += i;

			if (sum >= input) {
				break;
			}
			i++;
		}

		int line = i;
		int remainder = input - (sum - i);

		if (line % 2 == 0) {
			System.out.printf("%d/%d", remainder, i - remainder + 1);
		} else {
			System.out.printf("%d/%d", i - remainder + 1, remainder);
		}

	}

}
